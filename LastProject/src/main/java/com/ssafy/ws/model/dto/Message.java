package com.ssafy.ws.model.dto;

public class Message {
	private int msgSeq;
	private String msgToId;
	private String msgFromId;
	private String msgContent;
	// 신고 처리 여부
	private boolean messageReportState;
	private boolean msgReadCheck; 
	
	
	public Message() {
		// TODO Auto-generated constructor stub
	}


	public Message(int msgSeq, String msgToId, String msgFromId, String msgContent, boolean messageReportState,
			boolean msgReadCheck) {
		super();
		this.msgSeq = msgSeq;
		this.msgToId = msgToId;
		this.msgFromId = msgFromId;
		this.msgContent = msgContent;
		this.messageReportState = messageReportState;
		this.msgReadCheck = msgReadCheck;
	}


	public int getMsgSeq() {
		return msgSeq;
	}


	public void setMsgSeq(int msgSeq) {
		this.msgSeq = msgSeq;
	}


	public String getMsgToId() {
		return msgToId;
	}


	public void setMsgToId(String msgToId) {
		this.msgToId = msgToId;
	}


	public String getMsgFromId() {
		return msgFromId;
	}


	public void setMsgFromId(String msgFromId) {
		this.msgFromId = msgFromId;
	}


	public String getMsgContent() {
		return msgContent;
	}


	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}


	public boolean isMessageReportState() {
		return messageReportState;
	}


	public void setMessageReportState(boolean messageReportState) {
		this.messageReportState = messageReportState;
	}


	public boolean isMsgReadCheck() {
		return msgReadCheck;
	}


	public void setMsgReadCheck(boolean msgReadCheck) {
		this.msgReadCheck = msgReadCheck;
	}

	
	
	
	
	
}
