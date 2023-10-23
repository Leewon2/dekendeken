package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.model.dto.Article;
import com.ssafy.ws.model.dto.SearchCondition;


public interface ArticleService {

	// 기본적인 서비스 구현해보자.
	// article은 crud가 전부일듯??
	
	// 게시글 등록
	public void ArticleWrite(Article article);

	
	// 게시글 검색
	public List<Article> ArticleSearchByTitle(SearchCondition condition);
	
	// 게시글 전체 조회
	public List<Article> ArticleList();
	
	// 게시글 디테일 조회
	public Article ArticleSelectOne(int articleSeq);

	// 게시글 수정
	public void ArticleUpdate(Article article);
	
	// 게시글 삭제
	public void ArticleDelete(int articleSeq);
}
