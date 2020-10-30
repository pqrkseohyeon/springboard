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



@RequestMapping("/reply")	// @RequestMapping > ��Ʈ�ѷ��� 2�� > �����ּ� ��ã�Բ� �ϱ� ���� 
@RestController // �� responsebody + controller > �ڵ����� json������ ����
public class CommentController {
	@Autowired
	private CommentService service;
	
	@PostMapping("commentInsert")
	// @RequestBody > ���޹��� json ������ > convert(��ȯ) > bean��ü�� �����ϰԲ�
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
