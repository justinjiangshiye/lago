package com.yunding.lago.controller;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.util.Version;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.yunding.lago.bean.Article;
import com.yunding.lago.bean.ArticleWithBLOBs;
import com.yunding.lago.service.ArticleService;
import com.yunding.lago.util.HtmlToPlainText;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SearchController extends BaseController {

	private ArticleService articleService = null;
	private IndexWriter indexWriter = null;
	private IKAnalyzer analyzer = null;

	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@Autowired()
	public void setIndexWriter(IndexWriter indexWriter) {
		this.indexWriter = indexWriter;
	}

	@Autowired()
	public void setIKAnalyzer(IKAnalyzer analyzer) {
		this.analyzer = analyzer;
	}
	
	private static final String STARTTAG="<font color='red'>";
    private static final String ENDTAG="</font>";

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/admin/indexBuild", method = RequestMethod.GET)
	public String adminIndexBuild(Locale locale, Model model) throws IOException {

		try {
			indexWriter.deleteAll();
			logger.info("Index deleted.");

			List<Article> articles = this.articleService.queryAllArticles();

			HtmlToPlainText formatter = new HtmlToPlainText();
			for (int i = 0; i < articles.size(); i++) {
				ArticleWithBLOBs article = this.articleService
						.queryArticleById(articles.get(i).getId());

				Document doc = new Document();
				
				String textContent = formatter.getPlainText(article.getContent());
				Field category = new Field("category", article.getCategory(),
						Field.Store.YES, Field.Index.ANALYZED);
				Field title = new Field("title", article.getTitle(),
						Field.Store.YES, Field.Index.ANALYZED);
				Field content = new Field("content", textContent,
						Field.Store.YES, Field.Index.ANALYZED);
				Field keywords = new Field("keywords", article.getKeywords(),
						Field.Store.YES, Field.Index.ANALYZED);
				Field abstractContent = new Field("abstractContent",
						article.getAbstractcontent(), Field.Store.YES,
						Field.Index.ANALYZED);
				Field id = new Field("id", article.getId().toString(),
						Field.Store.YES, Field.Index.NO);
				doc.add(category);
				doc.add(title);
				doc.add(content);
				doc.add(keywords);
				doc.add(abstractContent);
				doc.add(id);
				this.indexWriter.addDocument(doc);
			}
			
			this.indexWriter.commit();
			logger.info("Index rebuilt.");
		} catch (IOException e) {
			e.printStackTrace();
			try {
				indexWriter.rollback();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return "admin/indexBuild";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws IOException 
	 * @throws ParseException 
	 * @throws InvalidTokenOffsetsException 
	 */
	@RequestMapping(value = "/search/{text}", method = RequestMethod.GET)
	public String luceneSearch(Locale locale, Model model,
			@PathVariable String text) throws IOException, ParseException, InvalidTokenOffsetsException {
		logger.info("The search text is {}", text);
		IndexSearcher searcher=getSearcher();
        QueryParser parser=new MultiFieldQueryParser(Version.LUCENE_48, new String[]{"title","content", "keywords", "category"}, analyzer);
        parser.setDefaultOperator(QueryParser.Operator.OR);
        Query query=parser.parse(text);
        TopDocs td=searcher.search(query,10);
        ScoreDoc[] sd=td.scoreDocs;
        logger.info("Search result count is {}", sd.length);
        SimpleHTMLFormatter simpleHtmlFormatter=new SimpleHTMLFormatter(STARTTAG, ENDTAG);
        Highlighter highlighter=new Highlighter(simpleHtmlFormatter,new QueryScorer(query));
        Document doc;
        TokenStream tokenStream=null;
        List<ArticleWithBLOBs> list=new ArrayList<ArticleWithBLOBs>();

        for(int i=0;i<sd.length;i++){
            ArticleWithBLOBs article = new ArticleWithBLOBs();
             
            int docId=sd[i].doc;
            doc=searcher.doc(docId);
             
            String title=doc.get("title");
            tokenStream=analyzer.tokenStream("title", new StringReader(title));
            title=highlighter.getBestFragment(tokenStream, title);
            article.setTitle(title==null?doc.get("title"):title);
         
            String content=doc.get("content");
            tokenStream=analyzer.tokenStream("content", new StringReader(content));
            content=highlighter.getBestFragment(tokenStream, content);
             
            article.setContent(content==null?(doc.get("content").length()<200?doc.get("content"):doc.get("content").substring(0, 199)):content);
            article.setCategory(doc.get("category"));
            list.add(article);
        }
        
        model.addAttribute("searchResult", list);
		
		return "search";
	}
	
	@SuppressWarnings("deprecation")
    private IndexSearcher getSearcher() throws IOException{
        return new IndexSearcher(IndexReader.open(indexWriter.getDirectory()));
    }
}
