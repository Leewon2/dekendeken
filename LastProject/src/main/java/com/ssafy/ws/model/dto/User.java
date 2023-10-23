package com.ssafy.ws.model.dto;

public class User {
	private int userSeq;
	private String userId;
	private String userPwd;
	private String userName;
	private String userNickname;
	private String userEmail;
	private String userAdress;
	private String userInterestBigSport;
	private String userInterestSmallSport;
	private int userSex;
	private int userAge;
	private int userHeight;
	private int userWeight;
	private String userExcerciseGoal;
	private int userDayCalorie;
	private int userTotalCalorie;
	private String userPokectmonName;
	private String userPokectmonUrl;
	private int userWarning;
	private int userPokectmonGroup;
	private boolean userBooleanMsg;
	private int userManager;
	
	
	public User() {}
	
	public User(String userId, String userPwd) {

		this.userId = userId;
		this.userPwd = userPwd;
	}
	
	public User(String userId, String userPwd, String userName, String userNickname, String userEmail,
			String userAdress, String userInterestBigSport, String userInterestSmallSport, int userSex,
			int userAge, int userHeight, int userWeight, String userExcerciseGoal) {

		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userNickname = userNickname;
		this.userEmail = userEmail;
		this.userAdress = userAdress;
		this.userInterestBigSport = userInterestBigSport;
		this.userInterestSmallSport = userInterestSmallSport;
		this.userSex = userSex;
		this.userAge = userAge;
		this.userHeight = userHeight;
		this.userWeight = userWeight;
		this.userExcerciseGoal = userExcerciseGoal;

	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAdress() {
		return userAdress;
	}

	public void setUserAdress(String userAdress) {
		this.userAdress = userAdress;
	}

	public String getUserInterestBigSport() {
		return userInterestBigSport;
	}

	public void setUserInterestBigSport(String userInterestBigSport) {
		this.userInterestBigSport = userInterestBigSport;
	}

	public String getUserInterestSmallSport() {
		return userInterestSmallSport;
	}

	public void setUserInterestSmallSport(String userInterestSmallSport) {
		this.userInterestSmallSport = userInterestSmallSport;
	}

	public int getUserSex() {
		return userSex;
	}

	public void setUserSex(int userSex) {
		this.userSex = userSex;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public int getUserHeight() {
		return userHeight;
	}

	public void setUserHeight(int userHeight) {
		this.userHeight = userHeight;
	}

	public int getUserWeight() {
		return userWeight;
	}

	public void setUserWeight(int userWeight) {
		this.userWeight = userWeight;
	}

	public String getUserExcerciseGoal() {
		return userExcerciseGoal;
	}

	public void setUserExcerciseGoal(String userExcerciseGoal) {
		this.userExcerciseGoal = userExcerciseGoal;
	}

	public int getUserDayCalorie() {
		return userDayCalorie;
	}

	public void setUserDayCalorie(int userDayCalorie) {
		this.userDayCalorie = userDayCalorie;
	}

	public int getUserTotalCalorie() {
		return userTotalCalorie;
	}

	public void setUserTotalCalorie(int userTotalCalorie) {
		this.userTotalCalorie = userTotalCalorie;
	}

	public String getUserPokectmonName() {
		return userPokectmonName;
	}

	public void setUserPokectmonName(String userPokectmonName) {
		this.userPokectmonName = userPokectmonName;
	}

	public String getUserPokectmonUrl() {
		return userPokectmonUrl;
	}

	public void setUserPokectmonUrl(String userPokectmonUrl) {
		this.userPokectmonUrl = userPokectmonUrl;
	}

	public int getUserWarning() {
		return userWarning;
	}

	public void setUserWarning(int userWarning) {
		this.userWarning = userWarning;
	}

	public int getUserPokectmonGroup() {
		return userPokectmonGroup;
	}

	public void setUserPokectmonGroup(int userPokectmonGroup) {
		this.userPokectmonGroup = userPokectmonGroup;
	}

	public boolean isUserBooleanMsg() {
		return userBooleanMsg;
	}

	public void setUserBooleanMsg(boolean userBooleanMsg) {
		this.userBooleanMsg = userBooleanMsg;
	}

	public int getUserManager() {
		return userManager;
	}

	public void setUserManager(int userManager) {
		this.userManager = userManager;
	}
	
	

	
	
	
}