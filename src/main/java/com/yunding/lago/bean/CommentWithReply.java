package com.yunding.lago.bean;

import java.util.List;

public class CommentWithReply extends Comment {
	private List<ReplyToComment> replyToCommentList;

	public List<ReplyToComment> getReplyToCommentList() {
		return replyToCommentList;
	}

	public void setReplyToCommentList(List<ReplyToComment> replyToCommentList) {
		this.replyToCommentList = replyToCommentList;
	}
}