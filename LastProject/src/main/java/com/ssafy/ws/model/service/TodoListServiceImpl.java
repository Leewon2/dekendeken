package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.TodoListDao;
import com.ssafy.ws.model.dto.TodoList;

@Service
public class TodoListServiceImpl implements TodoListService{

	
	@Autowired
	private TodoListDao todoListDao; 
	
	@Override
	public void TodoListWrite(TodoList todoList) {
		todoListDao.TodoListWrite(todoList);
	}

	@Override
	public List<TodoList> TodoListList(String todolistUserId) {
		return todoListDao.TodoListList(todolistUserId);
	}

	@Override
	public void TodoListUpdate(TodoList todoList) {
		todoListDao.TodoListUpdate(todoList);
		
	}

	@Override
	public void TodoListDelete(int todolistSeq) {
		todoListDao.TodoListDelete(todolistSeq);
	}

}
