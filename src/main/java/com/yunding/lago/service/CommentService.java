package com.yunding.lago.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunding.lago.bean.Article;
import com.yunding.lago.bean.ArticleWithBLOBs;
import com.yunding.lago.bean.Comment;
import com.yunding.lago.bean.CommentWithReply;
import com.yunding.lago.bean.ReplyToComment;
import com.yunding.lago.util.MyConstants;
import com.yunding.lago.dao.ArticleMapper;
import com.yunding.lago.dao.CommentMapper;
import com.yunding.lago.dao.ReplyToCommentMapper;

@Service
public class CommentService {
	private CommentMapper commentMapper = null;
	@Autowired
	public void setCommentMapper(CommentMapper commentMapper) {
		this.commentMapper = commentMapper;
	}
	
	private ReplyToCommentMapper replyToCommentMapper = null;
	@Autowired
	public void setReplyToCommentMapper(ReplyToCommentMapper replyToCommentMapper) {
		this.replyToCommentMapper = replyToCommentMapper;
	}
	
	public Comment queryCommentById(Integer id) {
		return this.commentMapper.selectByPrimaryKey(id);
	}
	
	public List<Comment> queryCommentByArticleId(Integer articleId) {
		return this.commentMapper.selectByArticleId(articleId);
	}
	
	public List<CommentWithReply> queryCommentWithReplyByArticleId(Integer articleId) {
		List<Comment> commentList = this.queryCommentByArticleId(articleId);
		List<ReplyToComment> replyToCommentList = this.replyToCommentMapper.selectByArticleId(articleId);
		List<CommentWithReply> list = new ArrayList<CommentWithReply>();
		for(int i = 0; i < commentList.size(); i++) {
			CommentWithReply commentWithReply = new CommentWithReply();
			commentWithReply.setId(commentList.get(i).getId());
			commentWithReply.setArticleid(commentList.get(i).getArticleid());
			commentWithReply.setFloorno(commentList.get(i).getFloorno());
			commentWithReply.setUserid(commentList.get(i).getUserid());
			commentWithReply.setNickname(commentList.get(i).getNickname());
			commentWithReply.setProfilephotourl(commentList.get(i).getProfilephotourl());
			commentWithReply.setCreatedon(commentList.get(i).getCreatedon());
			commentWithReply.setRecordstatus(commentList.get(i).getRecordstatus());
			commentWithReply.setContent(commentList.get(i).getContent());
			List<ReplyToComment> replyList = new ArrayList<ReplyToComment>();
			for(int j = 0; j < replyToCommentList.size(); j++) {
				if (replyToCommentList.get(j).getCommentid() == commentList.get(i).getId()) {
					replyList.add(replyToCommentList.get(j));
				}
			}
			commentWithReply.setReplyToCommentList(replyList);
			list.add(commentWithReply);
		}
		return list;
	}
	
	public int addComment(Comment comment) {
		return this.commentMapper.insertSelective(comment);
	}
	
	public int updateComment(Comment comment) {
		return this.commentMapper.updateByPrimaryKeyWithBLOBs(comment);
	}
	
	public int addReplyToComment(ReplyToComment replyToComment) {
		return this.replyToCommentMapper.insertSelective(replyToComment);
	}
	
	public int updateReplyToComment(ReplyToComment replyToComment) {
		return this.replyToCommentMapper.updateByPrimaryKeyWithBLOBs(replyToComment);
	}
}
