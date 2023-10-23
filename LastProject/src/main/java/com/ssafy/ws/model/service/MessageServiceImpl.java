package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.MessageDao;
import com.ssafy.ws.model.dto.Message;
import com.ssafy.ws.model.dto.User;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDao messageDao;

	@Override
	public void MessageReply(Message message) {
		messageDao.MessageReply(message);
	}

	@Override
	public List<Message> MessageList(String msgToId) {
		return messageDao.MessageList(msgToId);
	}

	@Override
	public Message MessageDetail(int msgSeq) {
		// 메세지 읽음 확인
		messageDao.MessageRead(msgSeq);
		return messageDao.MessageDetail(msgSeq);
	}

	@Override
	public void MessageReport(Message message) {
		messageDao.MessageReport(message);
	}
	
	@Override
	public void MessageRead(int msgSeq) {
		messageDao.MessageRead(msgSeq);
	}

	@Override
	public void MessageDelete(int msgSeq) {
		messageDao.MessageDelete(msgSeq);
	}

	@Override
	public void YouAreBadUser(User user) throws Exception {
		messageDao.YouAreBadUser(user);
	}
	
	@Override
	public List<Message> BlackMessageList() {
		return messageDao.BlackMessageList();
	}
	//신고 메시지 가져오기
		

	// 메세지 몇개 안읽었는지 확인
	// 1개라도 안읽었으면 1 return, 하나도 없으면 0 return
	
}
