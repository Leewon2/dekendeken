package com.ssafy.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ws.model.dto.Article;
import com.ssafy.ws.model.dto.SearchCondition;
import com.ssafy.ws.model.service.ArticleService;

import io.swagger.annotations.Api;

@CrossOrigin("*")
@RestController
@RequestMapping("/article")
@Api(tags = "게시판 컨트롤러")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	

	// 포스트로 보내고
	@PostMapping("/write")
	public ResponseEntity<?> ArticleWrite(Article article){
		articleService.ArticleWrite(article);
		return new ResponseEntity<Article>(article, HttpStatus.CREATED);
	}
	
	@GetMapping("/search/{articleTitle}")
	public ResponseEntity<?> ArticleSearchByTitle(SearchCondition condition){
		List<Article> searchByTitle = articleService.ArticleSearchByTitle(condition);
		return new ResponseEntity<List<Article>>(searchByTitle, HttpStatus.OK);
	}
	
	// 읽어오기 위해 get으로 요청
	@GetMapping("/list")
	public ResponseEntity<?> ArticleList(){
		// list하나 새로 만들고, dramaservice에서 작성한 getList 메서드사용
		List<Article> ArticleList = articleService.ArticleList();
		return new ResponseEntity<List<Article>>(ArticleList, HttpStatus.OK);
	}
	
	@GetMapping("/select/{articleSeq}")
	public ResponseEntity<?> ArticleSelectOne(@PathVariable int articleSeq){
		// 객체 하나 생성하고 dramaservice에서 작성한 detail 메서드 사용
		Article ArticleDetail = articleService.ArticleSelectOne(articleSeq);
		return new ResponseEntity<Article>(ArticleDetail, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	// swagger UI의 body부분에 보여주기 위해 requestBody 어노테이션 사용
	public ResponseEntity<?> ArticleUpdate(Article article){
		// dramaservice에서 작성한 modifyDrama 메서드 사용
		articleService.ArticleUpdate(article);
		// 반환할 값 없으니, 반환 되었으면 ok상태 출력
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{articleSeq}")
	// 삭제하기 위해 delete로 요청
	public ResponseEntity<?> ArticleDelete(@PathVariable int articleSeq){
		// dramaservice에서 생성한 deleteDrama메서드 사용해서 바로 지워버리기
		articleService.ArticleDelete(articleSeq);
		// 반환할 값 없으니, 반환되었으면 ok상태만 출력
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	

	

}
