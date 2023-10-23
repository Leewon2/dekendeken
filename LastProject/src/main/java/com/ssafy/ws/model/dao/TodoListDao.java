package com.ssafy.ws.model.dao;

import java.util.List;

import com.ssafy.ws.model.dto.TodoList;

public interface TodoListDao {
	
	
	// CRUD 작성해보자.
	// C
	public void TodoListWrite(TodoList todoList);
	
	// R
	// 로그인한 유저의 전체 todolist만 보여주면 된다.
	public List<TodoList> TodoListList(String todolistUserId);
	
	// U
	// TodoList의 GoalCheck를 바꾸자.
	public void TodoListUpdate(TodoList todoList);
	
	// D
	public void TodoListDelete(int todolistSeq);
}
