package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.VideoDao;
import com.ssafy.ws.model.dto.SearchCondition;
import com.ssafy.ws.model.dto.Video;


@Service
public class VideoServiceImpl implements VideoService{

	@Autowired
	private VideoDao videoDao;

	@Override
	public List<Video> VideoSearchByTitle(SearchCondition condition) {
		return videoDao.VideoSearchByTitle(condition);
	}

	@Override
	public List<Video> VideoList() {
		return videoDao.VideoList();
	}

	@Override
	public Video VideoDetail(int videoSeq) {
		return videoDao.VideoDetail(videoSeq);
	}

	@Override
	public void VideoDelete(int videoSeq) {
		videoDao.VideoDelete(videoSeq);
	}

	@Override
	public void VideoCntUpdate(Video video) {
		videoDao.VideoCntUpdate(video);
	}
	
	

}
