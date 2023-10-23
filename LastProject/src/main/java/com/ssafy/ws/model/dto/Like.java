package com.ssafy.ws.model.dto;

public class Like {
	private int likeSeq;
	private String likeUserId;
	private int likeVideoSeq;
	
	public Like() {
		// TODO Auto-generated constructor stub
	}

	public Like(int likeSeq, String likeUserId, int likeVideoSeq) {
		super();
		this.likeSeq = likeSeq;
		this.likeUserId = likeUserId;
		this.likeVideoSeq = likeVideoSeq;
	}

	public int getLikeSeq() {
		return likeSeq;
	}

	public void setLikeSeq(int likeSeq) {
		this.likeSeq = likeSeq;
	}

	public String getLikeUserId() {
		return likeUserId;
	}

	public void setLikeUserId(String likeUserId) {
		this.likeUserId = likeUserId;
	}

	public int getLikeVideoSeq() {
		return likeVideoSeq;
	}

	public void setLikeVideoSeq(int likeVideoSeq) {
		this.likeVideoSeq = likeVideoSeq;
	}
	
}
