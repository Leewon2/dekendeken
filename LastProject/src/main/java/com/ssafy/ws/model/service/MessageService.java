package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.model.dto.Message;
import com.ssafy.ws.model.dto.User;

public interface MessageService {
	// 쪽지 보내기 && 답장하기 => 어차피 로그인 유저가 보내고, 답장하니까 똑같다.
	// loginUser가 보내면 되겠다. 무엇을? message 내용을
	public void MessageReply(Message message);
	
	// 불량유저에게 쪽지 보내기
	public void YouAreBadUser(User user) throws Exception;
	
	// 개인 쪽지 List 보여주기
	// 파라미터 => 로그인한 유저의 쪽지함 이므로 loginUser인지 확인해야함
	// DTO message에서는 ToId가 되겠다.
	public List<Message> MessageList(String msgToId);
	
	// 개인 쪽지 중 한 개 클릭 시 (detail)
	public Message MessageDetail(int msgSeq);
	
	// 신고하기 => reportState만 변경시켜주자.
	public void MessageReport(Message message);
	
	// 삭제하기 => 쪽지 삭제하기
	public void MessageDelete(int msgSeq);
	
	//신고 메시지 가져오기
	public List<Message> BlackMessageList();
	
	public void MessageRead(int msgSeq);
	

}
