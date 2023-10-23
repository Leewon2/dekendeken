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

import com.ssafy.ws.model.dto.TodoList;
import com.ssafy.ws.model.service.TodoListService;

import io.swagger.annotations.Api;

@CrossOrigin("*")
@RestController
@RequestMapping("/todolist")
@Api(tags = "todoList 컨트롤러")
public class TodoListController {
	
	@Autowired
	private TodoListService todoListService;
	

	// 포스트로 보내고
	@PostMapping("/write")
	public ResponseEntity<?> TodoListWrite(TodoList todoList){
		todoListService.TodoListWrite(todoList);
		return new ResponseEntity<TodoList>(todoList, HttpStatus.CREATED);
	}
	
	// 읽어오기 위해 get으로 요청
	@GetMapping("/list")
	public ResponseEntity<?> TodoListList(String todolistUserId) {
		// list하나 새로 만들고, dramaservice에서 작성한 getList 메서드사용
		List<TodoList> TodoListList = todoListService.TodoListList(todolistUserId);
		return new ResponseEntity<List<TodoList>>(TodoListList, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> TodoListUpdate(TodoList todoList){
		// dramaservice에서 작성한 modifyDrama 메서드 사용
		todoListService.TodoListUpdate(todoList);
		// 반환할 값 없으니, 반환 되었으면 ok상태 출력
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{todolistSeq}")
	// 삭제하기 위해 delete로 요청
	public ResponseEntity<?> TodoListDelete(@PathVariable int todolistSeq){
		// dramaservice에서 생성한 deleteDrama메서드 사용해서 바로 지워버리기
		todoListService.TodoListDelete(todolistSeq);
		// 반환할 값 없으니, 반환되었으면 ok상태만 출력
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	

	

}
