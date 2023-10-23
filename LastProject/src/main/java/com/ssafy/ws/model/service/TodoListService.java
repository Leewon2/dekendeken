package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.model.dto.TodoList;

public interface TodoListService {
	public void TodoListWrite(TodoList todoList);
	
	public List<TodoList> TodoListList(String todolistUserId);
	
	public void TodoListUpdate(TodoList todoList);
	
	public void TodoListDelete(int todolistSeq);
}
