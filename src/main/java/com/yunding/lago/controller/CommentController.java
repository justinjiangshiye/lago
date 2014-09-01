package com.yunding.lago.controller;

import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yunding.lago.bean.Article;
import com.yunding.lago.bean.ArticleWithBLOBs;
import com.yunding.lago.bean.Comment;
import com.yunding.lago.bean.ReplyToComment;
import com.yunding.lago.bean.User;
import com.yunding.lago.service.ArticleService;
import com.yunding.lago.service.CommentService;
import com.yunding.lago.service.UserService;
import com.yunding.lago.util.MyConstants;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CommentController extends BaseController {

	private ArticleService articleService = null;
	private CommentService commentService = null;
	
	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	@Autowired
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	@RequestMapping(value = "/commentSave", method = RequestMethod.POST)
	public String commentSave(Locale locale, Model model,
			Comment comment) {
		logger.info("The client locale is {}.", locale);
		logger.info("Comment Id is {}.", comment.getId());
		logger.info("Comment UserId is {}.", comment.getUserid());
		logger.info("Comment ArticleId is {}.", comment.getArticleid());
		logger.info("Comment Content is {}.", comment.getContent());

		if (comment.getUserid() == null) {
			String userLoginId = UUID.randomUUID().toString();
			User anonymousUser = new User();
			anonymousUser.setType(MyConstants.anonymousUser);
			anonymousUser.setLoginid(userLoginId);
			anonymousUser.setNickname(comment.getNickname());
			anonymousUser.setProfilephotourl("/images/default-user-photo.gif");
			anonymousUser.setLastvisiton(new Date());
			anonymousUser.setCreatedon(new Date());
			anonymousUser.setRegisteron(anonymousUser.getCreatedon());
			anonymousUser.setRecordstatus(0);
			this.getUserService().addUser(anonymousUser);
			anonymousUser = this.getUserService().queryUserByLoginId(userLoginId);
			comment.setUserid(anonymousUser.getId());
			comment.setProfilephotourl(anonymousUser.getProfilephotourl());
		}
		
		Date now = new Date();
		// TODO: calculate floor no
		comment.setFloorno(0);
		comment.setCreatedon(now);
		comment.setRecordstatus(0);
		commentService.addComment(comment);

		this.addMessage("添加评论成功！");
		
		Article article = this.articleService.queryArticleById(comment.getArticleid());
		return "redirect:/article/" + article.getSlugsurl();
	}
	
	@RequestMapping(value = "/commentDelete/{commentId}", method = RequestMethod.GET)
	public String commentDelete(Locale locale, Model model,
			@PathVariable Integer commentId) {
		logger.info("The client locale is {}.", locale);
		
		logger.info("Comment Id is {}", commentId);

		Comment comment = this.commentService
				.queryCommentById(commentId);		
		comment.setRecordstatus(2);
		this.commentService.updateComment(comment);

		this.addMessage("删除评论成功！");
		
		Article article = this.articleService.queryArticleById(comment.getArticleid());
		return "redirect:/article/" + article.getSlugsurl();
	}
	
	@RequestMapping(value = "/replyToCommentSave", method = RequestMethod.POST)
	public String replyToCommentSave(Locale locale, Model model,
			ReplyToComment replyToComment) {
		logger.info("The client locale is {}.", locale);
		logger.info("Comment Id is {}.", replyToComment.getId());
		logger.info("Comment UserId is {}.", replyToComment.getUserid());
		logger.info("Comment ArticleId is {}.", replyToComment.getArticleid());
		logger.info("Comment CommentId is {}.", replyToComment.getCommentid());
		logger.info("Comment Content is {}.", replyToComment.getContent());

		if (replyToComment.getUserid() == null) {
			String userLoginId = UUID.randomUUID().toString();
			User anonymousUser = new User();
			anonymousUser.setType(MyConstants.anonymousUser);
			anonymousUser.setLoginid(userLoginId);
			anonymousUser.setNickname(replyToComment.getNickname());
			anonymousUser.setProfilephotourl("/images/default-user-photo.gif");
			anonymousUser.setLastvisiton(new Date());
			anonymousUser.setCreatedon(new Date());
			anonymousUser.setRegisteron(anonymousUser.getCreatedon());
			anonymousUser.setRecordstatus(0);
			this.getUserService().addUser(anonymousUser);
			anonymousUser = this.getUserService().queryUserByLoginId(userLoginId);
			replyToComment.setUserid(anonymousUser.getId());
			replyToComment.setProfilephotourl(anonymousUser.getProfilephotourl());
		}
		
		Date now = new Date();
		// TODO: calculate floor no
		replyToComment.setCreatedon(now);
		replyToComment.setRecordstatus(0);
		commentService.addReplyToComment(replyToComment);

		this.addMessage("添加评论成功！");
		
		Article article = this.articleService.queryArticleById(replyToComment.getArticleid());
		return "redirect:/article/" + article.getSlugsurl();
	}
	

	@RequestMapping(value = "/replyToCommentDelete/{commentId}", method = RequestMethod.GET)
	public String replyToCommentDelete(Locale locale, Model model,
			@PathVariable Integer commentId) {
		logger.info("The client locale is {}.", locale);
		
		logger.info("Comment Id is {}", commentId);

		Comment comment = this.commentService
				.queryCommentById(commentId);		
		comment.setRecordstatus(2);
		this.commentService.updateComment(comment);

		this.addMessage("删除评论成功！");
		
		Article article = this.articleService.queryArticleById(comment.getArticleid());
		return "redirect:/article/" + article.getSlugsurl();
	}
}
