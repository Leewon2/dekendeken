package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.ArticleDao;
import com.ssafy.ws.model.dto.Article;
import com.ssafy.ws.model.dto.SearchCondition;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleDao articleDao;
	
	
	@Override
	public void ArticleWrite(Article article) {
		articleDao.ArticleWrite(article);
		
	}

	@Override
	public List<Article> ArticleSearchByTitle(SearchCondition condition) {
		return articleDao.ArticleSearchByTitle(condition);
	}

	@Override
	public List<Article> ArticleList() {
		return articleDao.ArticleList();
	}

	@Override
	public Article ArticleSelectOne(int articleSeq) {
		return articleDao.ArticleSelectOne(articleSeq);
	}

	@Override
	public void ArticleUpdate(Article article) {
		articleDao.ArticleUpdate(article);
	}

	@Override
	public void ArticleDelete(int articleSeq) {
		articleDao.ArticleDelete(articleSeq);
	}

}
