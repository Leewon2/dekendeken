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
import com.ssafy.ws.model.dto.SearchCondition;
import com.ssafy.ws.model.dto.Video;
import com.ssafy.ws.model.service.VideoService;

import io.swagger.annotations.Api;


@CrossOrigin("*")
@RestController
@RequestMapping("/video")
@Api(tags = "비디오 컨트롤러")
public class VideoController {
	
	@Autowired
	private VideoService videoService;
	

	@GetMapping("/search")
	public ResponseEntity<?> VideoSearchByTitle(SearchCondition condition){
		List<Video> searchByTitle = videoService.VideoSearchByTitle(condition);
		return new ResponseEntity<List<Video>>(searchByTitle, HttpStatus.OK);
	}
	
	// 읽어오기 위해 get으로 요청
	@GetMapping("/list")
	public ResponseEntity<?> VideoList(){
		// list하나 새로 만들고, dramaservice에서 작성한 getList 메서드사용
		List<Video> VideoList = videoService.VideoList();
		return new ResponseEntity<List<Video>>(VideoList, HttpStatus.OK);
	}
	
	@GetMapping("/detail/{videoSeq}")
	public ResponseEntity<?> VideoDetail(@PathVariable int videoSeq){
		// 객체 하나 생성하고 dramaservice에서 작성한 detail 메서드 사용
		Video VideoDetail = videoService.VideoDetail(videoSeq);
		return new ResponseEntity<Video>(VideoDetail, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{videoSeq}")
	// 삭제하기 위해 delete로 요청
	public ResponseEntity<?> VideoDelete(@PathVariable int videoSeq){
		// dramaservice에서 생성한 deleteDrama메서드 사용해서 바로 지워버리기
		videoService.VideoDelete(videoSeq);
		// 반환할 값 없으니, 반환되었으면 ok상태만 출력
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/update")
	// swagger UI의 body부분에 보여주기 위해 requestBody 어노테이션 사용
	public ResponseEntity<?> VideoCntUpdate(Video video){
		// dramaservice에서 작성한 modifyDrama 메서드 사용
		videoService.VideoCntUpdate(video);
		// 반환할 값 없으니, 반환 되었으면 ok상태 출력
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	

	

}
