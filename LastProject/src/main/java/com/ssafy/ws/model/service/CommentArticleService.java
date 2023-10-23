package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.model.dto.CommentArticle;

public interface CommentArticleService {

	// 기본적인 서비스 구현해보자.
	// CommentArticle은 crud가 전부일듯??
	
	// 게시물에 댓글 등록
	public void CommentArticleWrite(CommentArticle commentArticle);

	
	// 댓글 전체 조회
	public List<CommentArticle> CommentArticleList(int commentArticleSeq);
	
	// 게시글 디테일 조회
	public CommentArticle CommentArticleSelectOne(int commentSeq);

	// 게시글 수정
	public void CommentArticleUpdate(CommentArticle commentArticle);
	
	// 게시글 삭제
	public void CommentArticleDelete(int commentSeq);
}
