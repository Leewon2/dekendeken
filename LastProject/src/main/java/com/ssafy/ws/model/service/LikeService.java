package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.model.dto.Like;

public interface LikeService {

	// 등록 => 유저 번호와 비디오 번호 입력 받아서 DB로 넘기자.
	public void LikeRegist(Like like);
	
	// 유저별로 좋아요를 누른 video
	// login한 사용자가 좋아요한 동영상 List를 뽑자.
	public List<Like> LikeUserList(String loginUser); 
	
	// 게시글 별 좋아요 수를 뽑자.
	public List<Like> LikeVideoList(int videoSeq);
	
	
	public void LikeVideoDelete(Like like);
	
	public void LikeVideoInsert(Like like);
	
	public Like LikeVideoSelectOne(Like like);
	
}
