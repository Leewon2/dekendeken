package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.CommentArticleDao;
import com.ssafy.ws.model.dto.CommentArticle;


@Service
public class CommentArticleServiceImpl implements CommentArticleService{

	@Autowired
	private CommentArticleDao commentArticleDao; 

	@Override
	public void CommentArticleWrite(CommentArticle commentArticle) {
		commentArticleDao.CommentArticleWrite(commentArticle);
	}

	@Override
	public List<CommentArticle> CommentArticleList(int commentArticleSeq) {
		return commentArticleDao.CommentArticleList(commentArticleSeq);
	}

	@Override
	public CommentArticle CommentArticleSelectOne(int commentSeq) {
		return commentArticleDao.CommentArticleSelectOne(commentSeq);
	}

	@Override
	public void CommentArticleUpdate(CommentArticle commentArticle) {
		commentArticleDao.CommentArticleUpdate(commentArticle);
	}

	@Override
	public void CommentArticleDelete(int commentSeq) {
		commentArticleDao.CommentArticleDelete(commentSeq);
	}
	


}