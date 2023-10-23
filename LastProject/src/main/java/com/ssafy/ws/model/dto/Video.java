package com.ssafy.ws.model.dto;

public class Video {
	private int videoSeq;
	private String videoTitle;
	private String videoURL;
	private String videothumbnail;
	private int viewCnt;
	
	public Video() {
		// TODO Auto-generated constructor stub
	}

	public Video(int videoSeq, String videoTitle, String videoURL, String videothumbnail, int viewCnt) {
		super();
		this.videoSeq = videoSeq;
		this.videoTitle = videoTitle;
		this.videoURL = videoURL;
		this.videothumbnail = videothumbnail;
		this.viewCnt = viewCnt;
	}

	public int getVideoSeq() {
		return videoSeq;
	}

	public void setVideoSeq(int videoSeq) {
		this.videoSeq = videoSeq;
	}

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	public String getVideoURL() {
		return videoURL;
	}

	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}

	public String getVideothumbnail() {
		return videothumbnail;
	}

	public void setVideothumbnail(String videothumbnail) {
		this.videothumbnail = videothumbnail;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	
}
