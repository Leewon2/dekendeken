package com.ssafy.ws.model.dto;

import java.util.Date;

public class CommentArticle {
	private int commentSeq;
	private int commentArticleSeq;
	private String commentUserId;
	private String commentContent;
	private Date commentJoinedAt;
	
	public CommentArticle() {
		// TODO Auto-generated constructor stub
	}

	public CommentArticle(int commentSeq, int commentArticleSeq, String commentUserId, String commentContent,
			Date commentJoinedAt) {
		super();
		this.commentSeq = commentSeq;
		this.commentArticleSeq = commentArticleSeq;
		this.commentUserId = commentUserId;
		this.commentContent = commentContent;
		this.commentJoinedAt = commentJoinedAt;
	}

	public int getCommentSeq() {
		return commentSeq;
	}

	public void setCommentSeq(int commentSeq) {
		this.commentSeq = commentSeq;
	}

	public int getCommentArticleSeq() {
		return commentArticleSeq;
	}

	public void setCommentArticleSeq(int commentArticleSeq) {
		this.commentArticleSeq = commentArticleSeq;
	}

	public String getCommentUserId() {
		return commentUserId;
	}

	public void setCommentUserId(String commentUserId) {
		this.commentUserId = commentUserId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentJoinedAt() {
		return commentJoinedAt;
	}

	public void setCommentJoinedAt(Date commentJoinedAt) {
		this.commentJoinedAt = commentJoinedAt;
	}
	
	
	
}
