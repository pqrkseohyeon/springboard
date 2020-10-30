package com.myboard.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myboard.dto.CommentDTO;
import com.myboard.model.BoardService;
import com.myboard.model.CommentService;

@RequestMapping("/reply/*")
@RestController
public class CommentController {
	@Autowired
	private CommentService cservie;

	
	@GetMapping("/commentList")
	public List<CommentDTO> list(int num) {
	   List<CommentDTO> clist= cservie.getList(num);
		return clist;
	}
	
	//댓글추가
	@PostMapping("/commentInsert")
	public String insert(@RequestBody  CommentDTO cdto) {
		cservie.insert(cdto);
	
		return "success";
	}
	//삭제

	@DeleteMapping(value = "/del/{cnum}")
	public int   del(@PathVariable int cnum) {
		cservie.delete(cnum);
		return cnum;
	}

}
