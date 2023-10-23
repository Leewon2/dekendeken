package com.ssafy.ws.model.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ws.model.dao.MessageDao;
import com.ssafy.ws.model.dao.UserDao;
import com.ssafy.ws.model.dto.Poketmon;
import com.ssafy.ws.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	@Autowired
	private MessageDao messageDao;

	@Override
	public List<User> userList() throws Exception {
		return userDao.userList();
	}

	@Override
	public List<User> userNeighbors(String userAdress) throws Exception {
		return userDao.userNeighbors(userAdress);
	}
	
	@Override
	public List<Poketmon> userGetPocketmon(int pocketmonGroup) throws Exception {
		return userDao.userGetPocketmon(pocketmonGroup);
	}
	
	@Override
	public Poketmon userRevolutionPocketmon(String pokectmonName) throws Exception {
		return userDao.userRevolutionPocketmon(pokectmonName);
	}

	
	@Override
	public int userCheckId(String userId) throws Exception {
		int tmp = userDao.userCheckId(userId);
		
		return tmp;
	}

	@Override
	public int userCheckNickname(String userNickname) throws Exception {
		int tmp =userDao.userCheckNickname(userNickname);
		return tmp;
	}
	
	
	
	@Transactional
	@Override
	public boolean userSignup(User user) throws Exception {	
		userDao.userSignup(user);
		return true;
	}
	
	@Transactional
	@Override
	public User userLogin(User user) throws Exception {
		User tmpuser = userDao.userLogin(user);
		if(tmpuser != null) {
			return tmpuser;
		}
		return null;
	}

	

	@Transactional
	@Override
	public void userUpdateCal(User user) throws Exception {
		userDao.userUpdateCal(user);
		
	}

	@Transactional
	@Override
	public void userUpdate(User user) throws Exception {
		userDao.userUpdate(user);
		
	}

	@Transactional
	@Override
	public void userUpdatePocketmon(User user) throws Exception {
		userDao.userUpdatePocketmon(user);
		
	}

	@Override
	public User userDetail(int userSeq) throws Exception {
		return userDao.userDetail(userSeq);
	}
	
	@Override
	public User userDetail2(String userId) throws Exception {
		return userDao.userDetail2(userId);
	}
	
	@Override
	public void badScoreUpdate(User user) throws Exception {
		userDao.badScoreUpdate(user);
	}

	@Override
	public void YouCannotUseMessageAnymore(User user) throws Exception {
		if(user.getUserWarning()>=3) {
			userDao.YouCannotUseMessageAnymore(user);
			//System.out.println(user.getUserId());
			messageDao.YouAreBadUser(user);
		}

		
		
	}

	
	

}
