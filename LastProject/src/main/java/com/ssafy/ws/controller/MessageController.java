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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ws.model.dto.Message;
import com.ssafy.ws.model.service.MessageService;

import io.swagger.annotations.Api;

@CrossOrigin("*")
@RestController
@RequestMapping("/message")
@Api(tags = "메시지 컨트롤러")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	

	// 포스트로 보내고
	@PostMapping("/reply")
	public ResponseEntity<?> MessageReply(Message message){
		messageService.MessageReply(message);
		return new ResponseEntity<Message>(message, HttpStatus.CREATED);
	}
	
	// 읽어오기 위해 get으로 요청
	@GetMapping("/list")
	public ResponseEntity<?> MessageList(String msgToId){
		// list하나 새로 만들고, dramaservice에서 작성한 getList 메서드사용
		List<Message> MessageList = messageService.MessageList(msgToId);
		return new ResponseEntity<List<Message>>(MessageList, HttpStatus.OK);
	}
	
	@GetMapping("/detail/{msgSeq}")
	public ResponseEntity<?> MessageDetail(@PathVariable int msgSeq){
		// 객체 하나 생성하고 dramaservice에서 작성한 detail 메서드 사용
		Message MessageDetail = messageService.MessageDetail(msgSeq);
		return new ResponseEntity<Message>(MessageDetail, HttpStatus.OK);
	}
	
	@GetMapping("/black")
	public ResponseEntity<?> BlackMessageList(){
		// 객체 하나 생성하고 dramaservice에서 작성한 detail 메서드 사용
		List<Message> MessageList = messageService.BlackMessageList();
		return new ResponseEntity<List<Message>>(MessageList, HttpStatus.OK);
	}
	
	@PutMapping("/report")
	// swagger UI의 body부분에 보여주기 위해 requestBody 어노테이션 사용
	public ResponseEntity<?> MessageReport(Message message){
		// dramaservice에서 작성한 modifyDrama 메서드 사용
		messageService.MessageReport(message);
		// 반환할 값 없으니, 반환 되었으면 ok상태 출력
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/read")
	// swagger UI의 body부분에 보여주기 위해 requestBody 어노테이션 사용
	public ResponseEntity<?> MessageRead(int msgSeq){
		// dramaservice에서 작성한 modifyDrama 메서드 사용
		messageService.MessageRead(msgSeq);
		// 반환할 값 없으니, 반환 되었으면 ok상태 출력
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{msgSeq}")
	// 삭제하기 위해 delete로 요청
	public ResponseEntity<?> MessageDelete(@PathVariable int msgSeq){
		// dramaservice에서 생성한 deleteDrama메서드 사용해서 바로 지워버리기
		messageService.MessageDelete(msgSeq);
		// 반환할 값 없으니, 반환되었으면 ok상태만 출력
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	

	

}
