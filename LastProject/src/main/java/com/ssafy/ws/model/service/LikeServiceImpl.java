package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.LikeDao;
import com.ssafy.ws.model.dto.Like;

@Service
public class LikeServiceImpl implements LikeService {

	
	@Autowired
	private LikeDao likeDao;

	@Override
	public void LikeRegist(Like like) {
		likeDao.LikeRegist(like);
	}

	@Override
	public List<Like> LikeUserList(String loginUserId) {
		return likeDao.LikeUserList(loginUserId);
	}

	@Override
	public List<Like> LikeVideoList(int videoSeq) {
		return likeDao.LikeVideoList(videoSeq);
	}

	@Override
	public void LikeVideoDelete(Like like) {
		likeDao.LikeVideoDelete(like);
	}

	@Override
	public void LikeVideoInsert(Like like) {
		likeDao.LikeVideoInsert(like);
	}

	@Override
	public Like LikeVideoSelectOne(Like like) {
		// TODO Auto-generated method stub
		return likeDao.LikeVideoSelectOne(like);
	}

}
