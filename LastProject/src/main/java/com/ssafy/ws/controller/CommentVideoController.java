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
import com.ssafy.ws.model.service.CommentVideoService;

import io.swagger.annotations.Api;

@CrossOrigin("*")
@RestController
@RequestMapping("/CommentVideo")
@Api(tags = "영상 댓글 컨트롤러")
public class CommentVideoController {
	
	@Autowired
	private CommentVideoService commentVideoService;
	
	
	// 포스트로 보내고
	@PostMapping("/write")
	public ResponseEntity<?> CommentVideoWrite(CommentVideo commentVideo){
		commentVideoService.CommentVideoWrite(commentVideo);
		return new ResponseEntity<CommentVideo>(commentVideo, HttpStatus.CREATED);
	}
	
	// 읽어오기 위해 get으로 요청
	@GetMapping("/list/{commentVideoSeq}")
	public ResponseEntity<?> CommentVideoList(@PathVariable int commentVideoSeq){
		List<CommentVideo> CommentVideoList = commentVideoService.CommentVideoList(commentVideoSeq);
		return new ResponseEntity<List<CommentVideo>>(CommentVideoList, HttpStatus.OK);
	}
	
	@GetMapping("/select/{commentSeq}")
	public ResponseEntity<?> CommentVideoDetail(@PathVariable int commentSeq){
		// 객체 하나 생성하고 dramaservice에서 작성한 detail 메서드 사용
		CommentVideo CommentVideoDetail = commentVideoService.CommentVideoDetail(commentSeq);
		return new ResponseEntity<CommentVideo>(CommentVideoDetail, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	// swagger UI의 body부분에 보여주기 위해 requestBody 어노테이션 사용
	public ResponseEntity<?> CommentVideoUpdate(CommentVideo commentVideo){
		// dramaservice에서 작성한 modifyDrama 메서드 사용
		commentVideoService.CommentVideoUpdate(commentVideo);
		// 반환할 값 없으니, 반환 되었으면 ok상태 출력
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
//	드라마 삭제 delete localhost:8080/api/drama{id}
	@DeleteMapping("/delete/{commentSeq}")
	// 삭제하기 위해 delete로 요청
	public ResponseEntity<?> CommentVideoDelete(@PathVariable int commentSeq){
		// dramaservice에서 생성한 deleteDrama메서드 사용해서 바로 지워버리기
		commentVideoService.CommentVideoDelete(commentSeq);
		// 반환할 값 없으니, 반환되었으면 ok상태만 출력
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
