package com.ssafy.ws.model.dto;

import java.util.Date;

public class Article {
	private int articleSeq;
	private String articleWriter;
	private String articleTitle;
	private String articleContent;
	private Date articleCreatedAt;
	private int articleViewCnt;

	public Article() {
		// TODO Auto-generated constructor stub
	}

	public Article(int articleSeq, String articleWriter, String articleTitle, String articleContent,
			Date articleCreatedAt, int articleViewCnt) {
		super();
		this.articleSeq = articleSeq;
		this.articleWriter = articleWriter;
		this.articleTitle = articleTitle;
		this.articleContent = articleContent;
		this.articleCreatedAt = articleCreatedAt;
		this.articleViewCnt = articleViewCnt;
	}

	public int getArticleSeq() {
		return articleSeq;
	}

	public void setArticleSeq(int articleSeq) {
		this.articleSeq = articleSeq;
	}

	public String getArticleWriter() {
		return articleWriter;
	}

	public void setArticleWriter(String articleWriter) {
		this.articleWriter = articleWriter;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public Date getArticleCreatedAt() {
		return articleCreatedAt;
	}

	public void setArticleCreatedAt(Date articleCreatedAt) {
		this.articleCreatedAt = articleCreatedAt;
	}

	public int getArticleViewCnt() {
		return articleViewCnt;
	}

	public void setArticleViewCnt(int articleViewCnt) {
		this.articleViewCnt = articleViewCnt;
	}
	
	
	
}
