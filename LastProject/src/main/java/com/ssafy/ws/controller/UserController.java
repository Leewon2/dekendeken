package com.ssafy.ws.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ws.model.dto.Article;
import com.ssafy.ws.model.dto.Poketmon;
import com.ssafy.ws.model.dto.User;
import com.ssafy.ws.model.service.UserService;

import io.swagger.annotations.Api;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
@Api(tags = "유저 컨트롤러")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/list") //전체 유저
	public ResponseEntity<List<User>> articleList() throws Exception {
		List<User> users = userService.userList();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	
	@PostMapping("/register")//회원가입  깔끔하게 만들기 위한 설정이 필요, 포켓몬 매핑하기도
	public ResponseEntity<?> writeU(User user) throws Exception{
		
		//가입자의 아이디 중복과 닉네임 중복을 여기서 합니다!!
		if(userService.userCheckId(user.getUserId())==0 && userService.userCheckNickname(user.getUserNickname())==0) {
			int pockectmonN = 0;
			Random random = new Random();
			
			//포켓몬 구현함수 작성
			// == CHANGE
			if(user.getUserSex()==0) {
				if(user.getUserInterestBigSport().equals("라켓운동")) {
					pockectmonN = 1;
				}else if(user.getUserInterestBigSport().equals("조깅/하이킹")) {
					pockectmonN = 2;
				}else if(user.getUserInterestBigSport().equals("격투기")) {
					if(user.getUserHeight()-100 < user.getUserWeight()) {
						pockectmonN = 5;
					}
					pockectmonN = 4;
				}else if(user.getUserInterestBigSport().equals("수중운동")) {
					int [] arr = {6,8};
					pockectmonN = arr[random.nextInt(100)%2];
				}else if(user.getUserInterestBigSport().equals("숨쉬기운동")) {
					pockectmonN = 9;
				}else if(user.getUserInterestBigSport().equals("헬스/요가")) {
					pockectmonN = 10;
				}else if(user.getUserInterestBigSport().equals("댄스")) {
					pockectmonN = 12;
				}else if(user.getUserInterestBigSport().equals("설상운동")) {
					int [] arr = {14,15};
					pockectmonN = arr[random.nextInt(100)%2];
				}else if(user.getUserInterestBigSport().equals("구기운동")) {
					pockectmonN = 16;
				}else {
					pockectmonN = 17;
				}
			}else {
				if(user.getUserInterestBigSport().equals("라켓운동")) {
					pockectmonN = 1;
				}else if(user.getUserInterestBigSport().equals("조깅/하이킹")) {
					pockectmonN = 3;
				}else if(user.getUserInterestBigSport().equals("격투기")) {
					pockectmonN = 4;
				}else if(user.getUserInterestBigSport().equals("수중운동")) {
					int [] arr = {7,8};
					pockectmonN = arr[random.nextInt(100)%2];
				}else if(user.getUserInterestBigSport().equals("숨쉬기운동")) {
					pockectmonN = 9;
				}else if(user.getUserInterestBigSport().equals("헬스/요가")) {
					pockectmonN = 11;
				}else if(user.getUserInterestBigSport().equals("댄스")) {
					pockectmonN = 13;
				}else if(user.getUserInterestBigSport().equals("설상운동")) {
					pockectmonN = 15;
				}else if(user.getUserInterestBigSport().equals("구기운동")) {
					pockectmonN = 16;
				}else {
					pockectmonN = 17;
				}
			}
			
			user.setUserPokectmonGroup(pockectmonN);
			
			
			List<Poketmon> list = userService.userGetPocketmon(pockectmonN);
			//System.out.println(pockectmonN);
			//System.out.println(list.get(0));
			
			int ttmp = random.nextInt(100)%list.size();
			user.setUserPokectmonName(list.get(ttmp).getPoketmonName());
			user.setUserPokectmonUrl(list.get(ttmp).getUploadPath());
			
			userService.userSignup(user);
			
			return new ResponseEntity<String>("sucess", HttpStatus.OK);
		}
		
		
		return new ResponseEntity<String>("중복 체크 바람",HttpStatus.OK);
	}
	
	@GetMapping("/detail/{userSeq}")//마이페이지
	public ResponseEntity<User> mypage(@PathVariable int userSeq) throws Exception{
		User user = userService.userDetail(userSeq);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping("/list/{userAdress}")//동네찾기
	public ResponseEntity<List<User>> userNeighbors(@PathVariable String userAdress) throws Exception{
		List<User> users = userService.userNeighbors(userAdress);
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@GetMapping("/rogin")//로그인
	public ResponseEntity<?> rogin(String userId, String userPwd) throws Exception{
		User tmpuser = new User(userId, userPwd);
		tmpuser =userService.userLogin(tmpuser);
//		if(tmpuser==null) {
//			return new ResponseEntity<String>("너 잘못했다", HttpStatus.BAD_GATEWAY);
//		}
		return new ResponseEntity<User>(tmpuser, HttpStatus.OK);
	}
	
	
	@GetMapping("/out")//로그아웃 
	public ResponseEntity<?> out() throws Exception{
		User tmpuser =null;
		return new ResponseEntity<User>(tmpuser, HttpStatus.OK);
	}
	
	@GetMapping("/userCheckId")//아이디 췍 체크 메서드의 경우 공통의 아이디가 있으면 1이 반환ㅇ됨
	public ResponseEntity<?> userCheckIdt(String userId) throws Exception{
		
		return new ResponseEntity<Integer>(userService.userCheckId(userId), HttpStatus.OK);
	}
	
	@GetMapping("/userCheckNickname")//닉네임 췍 공통의 아이디가 있으면 1이 반환ㅇ됨
	public ResponseEntity<?> userCheckNickname(String userCheckNickname) throws Exception{
		return new ResponseEntity<Integer>(userService.userCheckNickname(userCheckNickname), HttpStatus.OK);
	}
	
	@PutMapping("/userCal")//칼로리 업글
	public ResponseEntity<Void> userUpdateCal(User user) throws Exception{
		userService.userUpdateCal(user);
		User tmpuser = userService.userDetail(user.getUserSeq());
		if(tmpuser.getUserTotalCalorie()>=10000 && tmpuser.getUserDayCalorie() != 2) {
			//새로운 포켓몬으러 교체
			//System.out.println(tmpuser.getUserPokectmonName());
			//System.out.println(tmpuser.getUserTotalCalorie());
			Poketmon pkm = userService.userRevolutionPocketmon(tmpuser.getUserPokectmonName());
			//System.out.println(pkm);
			//System.out.println(tmpuser.toString());
			tmpuser.setUserPokectmonName(pkm.getPoketmonName());
			tmpuser.setUserPokectmonUrl(pkm.getUploadPath());
			
			userService.userUpdatePocketmon(tmpuser);
		}
		return new ResponseEntity<Void>( HttpStatus.OK);
	}
	@PutMapping("/userUdate")//정보 수정
	public ResponseEntity<Void> userUpdate(User user) throws Exception{
		userService.userUpdate(user);
		return new ResponseEntity<Void>( HttpStatus.OK);
	}
	
	@PutMapping("/badScoreUpdate")// 벌점 추가
	public ResponseEntity<Void> badScoreUpdate(User user) throws Exception{

		userService.badScoreUpdate(user);
		User tmpuser = userService.userDetail2(user.getUserId());
		userService.YouCannotUseMessageAnymore(tmpuser);
		return new ResponseEntity<Void>( HttpStatus.OK);
	}
	
//	@PutMapping("/pockemon")//포켓몬 지나
//	public ResponseEntity<Void> update(User user) throws Exception{
//		userService.userUpdatePocketmon(user);
//		return new ResponseEntity<Void>( HttpStatus.OK);
//	}
}
