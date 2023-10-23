package com.ssafy.ws.model.dao;

import java.util.List;

import com.ssafy.ws.model.dto.SearchCondition;
import com.ssafy.ws.model.dto.Video;


public interface VideoDao {
	// CRUD 만들기

	// 게시판에서 읽어 들이는게 뭐가 필요할까?? => 검색기능(serachByTitle로 해보자),
	// => 전체 게시판 불러오기, 하나 선택하기 (selectOne)
	// => 반환값 : 검색, 전체 게시판은 list가 되겠고, 하나는 객체가 되겠다.
	// => 파라미터 : 검색은 condition 있어야 겠고, 전체는 없어도 되고, 하나는 articleseq로 하자.
	// R
	public List<Video> VideoSearchByTitle(SearchCondition condition);

	public List<Video> VideoList();

	public Video VideoDetail(int videoSeq);
	
	public void VideoCntUpdate(Video video);
	
	// 게시판에서 삭제는 뭐가 있을까?? => 게시판 삭제
	// => 반환값 : DB에서 삭제하는 거니까 반환값 필요 없음
	// => 파라미터 : 파라미터는 seq를 기준으로 삭제해보자.
	// D
	public void VideoDelete(int videoSeq);

}
