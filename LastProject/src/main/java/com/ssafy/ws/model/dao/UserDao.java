package com.ssafy.ws.model.dao;

import java.util.List;

import com.ssafy.ws.model.dto.Poketmon;
import com.ssafy.ws.model.dto.User;

public interface UserDao {
	
	List<User> userList() throws Exception;
	
	List<User> userNeighbors(String userAdress) throws Exception;
	
	List<Poketmon> userGetPocketmon(int pocketmonGroup) throws Exception; //수정사항
	Poketmon userRevolutionPocketmon(String pokectmonName) throws Exception; //수정사항

	boolean userSignup(User user) throws Exception;

	User userLogin(User user) throws Exception;
	
	User userDetail(int userSeq) throws Exception;
	
	User userDetail2(String userId) throws Exception;

	int userCheckId(String userId) throws Exception;
	
	int userCheckNickname(String userNickname) throws Exception;
	
	void userUpdateCal(User user) throws Exception;
	
	void userUpdate(User user) throws Exception;
	
	void userUpdatePocketmon(User user) throws Exception;
	
	// 벌점 추가 기능
	void badScoreUpdate(User user) throws Exception;
	
	// 쪽지 금지 기능
	void YouCannotUseMessageAnymore(User user) throws Exception;

}
