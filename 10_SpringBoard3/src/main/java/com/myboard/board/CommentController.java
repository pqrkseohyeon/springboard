package com.myboard.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myboard.model.CommentService;
import com.myboard.util.CommentDTO;



@RequestMapping("/reply")	// @RequestMapping > 컨트롤러가 2개 > 매핑주소 잘찾게끔 하기 위해 
@RestController // ★ responsebody + controller > 자동으로 json값으로 리턴
public class CommentController {
	@Autowired
	private CommentService service;
	
	@PostMapping("commentInsert")
	// @RequestBody > 전달받은 json 데이터 > convert(변환) > bean객체로 전달하게끔
	public String insert(@RequestBody CommentDTO dto) {
		service.insert(dto);
		return "success";
	}
	

	@GetMapping("commentList")
	public List<CommentDTO> list(int bnum) {
		System.out.println("bnum : "+bnum);
		List<CommentDTO> clist = service.getList(bnum);
		return clist;
	}
	
	@GetMapping("commentDelete")
	public String delete(int cnum) {
		service.delete(cnum);
		return "success";
	}
	
	@DeleteMapping(value = "/del/{cnum}")
	public String delete2(@PathVariable("cnum") int cnum) {
		service.delete(cnum);
		System.out.println("CNUM : "+cnum);
		return "success";
	}
	
}
