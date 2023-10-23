package com.ssafy.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ws.model.dto.CommentVideo;
import com.ssafy.ws.model.dto.Like;
import com.ssafy.ws.model.service.LikeService;

import io.swagger.annotations.Api;

@CrossOrigin("*")
@RestController
@RequestMapping("/like")
@Api(tags = "좋아요 컨트롤러")
public class LikeController {
	
	@Autowired
	private LikeService likeService;
	

	// 포스트로 보내고
	@PostMapping("/regist")
	public ResponseEntity<?> LikeRegist(Like like){
		likeService.LikeRegist(like);
		return new ResponseEntity<Like>(like, HttpStatus.CREATED);
	}
	
	// 읽어오기 위해 get으로 요청
	@GetMapping("/LikeUserList/{loginUserId}")
	public ResponseEntity<?> LikeUserList(@PathVariable String loginUserId){
		List<Like> LikeUserList = likeService.LikeUserList(loginUserId);
		return new ResponseEntity<List<Like>>(LikeUserList, HttpStatus.OK);
	}
	
	@GetMapping("/LikeVideoList/{videoSeq}")
	public ResponseEntity<?> LikeVideoList(@PathVariable int videoSeq){
		// 객체 하나 생성하고 dramaservice에서 작성한 detail 메서드 사용
		List<Like> LikeVideoList = likeService.LikeVideoList(videoSeq);
		return new ResponseEntity<List<Like>>(LikeVideoList, HttpStatus.OK);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<?> LikeVideoInsert(Like like){
		likeService.LikeVideoInsert(like);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete")
	// 삭제하기 위해 delete로 요청
	public ResponseEntity<?> LikeVideoDelete(Like like){
		// dramaservice에서 생성한 deleteDrama메서드 사용해서 바로 지워버리기
		likeService.LikeVideoDelete(like);
		// 반환할 값 없으니, 반환되었으면 ok상태만 출력
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/selectOne")
	public ResponseEntity<?> LikeVideoSelectOne(Like like){
		Like selectOne = likeService.LikeVideoSelectOne(like);
		return new ResponseEntity<Like>(selectOne, HttpStatus.OK);
	}
	

	

}
