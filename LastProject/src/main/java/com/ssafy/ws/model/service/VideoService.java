package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.model.dto.SearchCondition;
import com.ssafy.ws.model.dto.Video;



public interface VideoService {

	// 기본적인 서비스 구현해보자.
	// article은 crud가 전부일듯??
	

	
	// 게시글 검색
	public List<Video> VideoSearchByTitle(SearchCondition condition);

	public List<Video> VideoList();

	public Video VideoDetail(int videoSeq);
	// 게시글 삭제
	public void VideoDelete(int videoSeq);
	
	public void VideoCntUpdate(Video video);
}
