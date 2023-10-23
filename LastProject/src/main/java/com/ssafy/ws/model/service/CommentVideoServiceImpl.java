package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.CommentVideoDao;
import com.ssafy.ws.model.dto.CommentVideo;



@Service
public class CommentVideoServiceImpl implements CommentVideoService {

	
	@Autowired
	private CommentVideoDao commentVideoDao; 
	
	@Override
	public void CommentVideoWrite(CommentVideo commentVideo) {
		commentVideoDao.CommentVideoWrite(commentVideo);
	}

	@Override
	public List<CommentVideo> CommentVideoList(int commentVideoSeq) {
		return commentVideoDao.CommentVideoList(commentVideoSeq);
	}

	@Override
	public CommentVideo CommentVideoDetail(int commentSeq) {
		return commentVideoDao.CommentVideoDetail(commentSeq);
	}

	@Override
	public void CommentVideoUpdate(CommentVideo commentVideo) {
		commentVideoDao.CommentVideoUpdate(commentVideo);
	}

	@Override
	public void CommentVideoDelete(int commentSeq) {
		commentVideoDao.CommentVideoDelete(commentSeq);
	}


	


}