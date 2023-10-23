package com.ssafy.ws.model.dto;

import java.util.Date;

public class CommentVideo {
	private int commentSeq;
	private int commentVideoSeq;
	private String commentUserId;
	private String commentContent;
	private Date commentJoinedAt;
	
	public CommentVideo() {
		// TODO Auto-generated constructor stub
	}

	public CommentVideo(int commentSeq, int commentVideoSeq, String commentUserId, String commentContent,
			Date commentJoinedAt) {
		super();
		this.commentSeq = commentSeq;
		this.commentVideoSeq = commentVideoSeq;
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

	public int getCommentVideoSeq() {
		return commentVideoSeq;
	}

	public void setCommentVideoSeq(int commentVideoSeq) {
		this.commentVideoSeq = commentVideoSeq;
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
