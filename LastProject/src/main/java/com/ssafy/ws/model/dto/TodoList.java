package com.ssafy.ws.model.dto;

public class TodoList {
	private int todolistSeq;
	private String todolistUserId;
	private String todolistGoal;
	private boolean todolistGoalCheck;
	
	public TodoList() {
		// TODO Auto-generated constructor stub
	}

	public TodoList(int todolistSeq, String todolistUserId, String todolistGoal, boolean todolistGoalCheck) {
		super();
		this.todolistSeq = todolistSeq;
		this.todolistUserId = todolistUserId;
		this.todolistGoal = todolistGoal;
		this.todolistGoalCheck = todolistGoalCheck;
	}

	public int getTodolistSeq() {
		return todolistSeq;
	}

	public void setTodolistSeq(int todolistSeq) {
		this.todolistSeq = todolistSeq;
	}

	public String getTodolistUserId() {
		return todolistUserId;
	}

	public void setTodolistUserId(String todolistUserId) {
		this.todolistUserId = todolistUserId;
	}

	public String getTodolistGoal() {
		return todolistGoal;
	}

	public void setTodolistGoal(String todolistGoal) {
		this.todolistGoal = todolistGoal;
	}

	public boolean isTodolistGoalCheck() {
		return todolistGoalCheck;
	}

	public void setTodolistGoalCheck(boolean todolistGoalCheck) {
		this.todolistGoalCheck = todolistGoalCheck;
	}
	
	
}
