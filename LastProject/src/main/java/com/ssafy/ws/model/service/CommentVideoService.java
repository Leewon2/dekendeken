package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.model.dto.CommentVideo;


public interface CommentVideoService {

	// 기본적인 서비스 구현해보자.
	// CommentArticle은 crud가 전부일듯??
	
	// 게시물에 댓글 등록
	public void CommentVideoWrite(CommentVideo commentVideo);

	
	// 댓글 전체 조회
	public List<CommentVideo> CommentVideoList(int commentVideoSeq);
	
	// 게시글 디테일 조회
	public CommentVideo CommentVideoDetail(int commentSeq);

	// 게시글 수정
	public void CommentVideoUpdate(CommentVideo commentVideo);
	
	// 게시글 삭제
	public void CommentVideoDelete(int commentSeq);
}
