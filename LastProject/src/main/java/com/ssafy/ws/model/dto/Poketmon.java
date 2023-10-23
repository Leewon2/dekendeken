package com.ssafy.ws.model.dto;

public class Poketmon {
	private String pokectmonName;
	private String uploadPath;
	
	public Poketmon() {}

	public String getPoketmonName() {
		return pokectmonName;
	}

	public void setPoketmonName(String poketmonName) {
		pokectmonName = poketmonName;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	@Override
	public String toString() {
		return "Poketmon [PoketmonName=" + pokectmonName + ", uploadPath=" + uploadPath + "]";
	}
	
	
	
}
