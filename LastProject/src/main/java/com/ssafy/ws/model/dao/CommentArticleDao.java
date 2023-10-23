package com.ssafy.ws.model.dao;

import java.util.List;

import com.ssafy.ws.model.dto.CommentArticle;


public interface CommentArticleDao {
	// CRUD 만들기

		// 댓글에서 생성하는게 뭐가 있을까??? 게시판 댓글 쓰기가 있겠구만
		// => create는 return 값이 필요한가?? => 만들어서 그냥 DB에 올리는 거니까? 필요 없을 듯???
		// => 파라미터값은 필요한가??? => CommentArticle이 필요할 듯??? 입력 받아야 하니까
		// C
		public void CommentArticleWrite(CommentArticle commentArticle);

		// 댓글에서 읽어 들이는게 뭐가 필요할까?? => 전체 댓글 보이기, 하나 선택하기 (selectOne)
		// => 반환값 : 전체 댓글은 list가 되겠고, 하나는 객체가 되겠다.
		// => 파라미터 : 전체는 없어도 되고, 하나는 commentSeq로 하자.
		// R
		public List<CommentArticle> CommentArticleList(int commentArticleSeq);

		public CommentArticle CommentArticleSelectOne(int commentSeq);

		// 댓글에서 업데이트는 뭐가 있을까?? => 댓글 수정 밖에 없겠다.
		// => 반환값 : 반환값은 필요 없겠다. DB에 바로 수정 들어가면 되니까
		// => 파라미터 : CommentArticle을 받아야 수정을 하겠지?
		// U
		public void CommentArticleUpdate(CommentArticle commentArticle);

		
		// 댓글에서 삭제는 뭐가 있을까?? => 댓글 삭제
		// => 반환값 : DB에서 삭제하는 거니까 반환값 필요 없음
		// => 파라미터 : 파라미터는 seq를 기준으로 삭제해보자.
		// D
		public void CommentArticleDelete(int commentSeq);

	}

