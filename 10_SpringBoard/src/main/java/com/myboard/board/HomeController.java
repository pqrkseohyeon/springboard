package com.myboard.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myboard.dto.BoardDTO;
import com.myboard.model.BoardListVO;
import com.myboard.model.BoardService;
import com.myboard.model.PageAction;
import com.myboard.util.SearchDTO;

@Controller
public class HomeController {
	
	@Autowired
	private BoardService service;
		
	@GetMapping("/")
	public String main() {
		return "redirect:list";
	}
	
	@GetMapping("bInsert")
	public String insert() {
		return "insert";
	}
	
	@PostMapping("bInsert")
	public String insert(BoardDTO board) {
		service.insert(board);
		return "redirect:list";
	}
	
	@GetMapping("list")
	public String list(Model model, SearchDTO sdto){
		List<BoardDTO> list = service.findAll(sdto);
		int count = service.count(sdto);
		int rowNo = count - ((sdto.getPageNum()-1)*10);
		model.addAttribute("listResult", list);
		model.addAttribute("count", count);
		model.addAttribute("rowNo", rowNo);
		
		return "list";
	}
	
	@GetMapping("get/{num}")
	// @PathVariable > url("get/{num}")통해 값 가져올 수 있다 (REST)
	public String get(@PathVariable("num") int num, Model model) {
		service.plusCnt(num);
		BoardDTO board = service.findByNum(num);
		model.addAttribute("board", board);
		return "view";
	}
	
	@GetMapping("view")
	// @PathVariable > url("get/{num}")통해 값 가져올 수 있다 (REST)
	public void view(int num, Model model) {
		System.out.println("num : "+num);
		service.plusCnt(num);
		BoardDTO board = service.findByNum(num);
		model.addAttribute("board", board);
	}
	
	//상세보기
	/*
	 * @GetMapping(value="bView", produces="text/plain;charset=UTF-8") public String
	 * view(Model model, @RequestParam("num") int num ) {
	 * 
	 * BoardDTO board = service.findByNum(num); model.addAttribute("board", board);
	 * return "view"; }
	 */
	
	//수정하기 폼
	@GetMapping("get/bUpdate")
	public String update(Model model, int num) {
		BoardDTO board = service.findByNum(num);
		model.addAttribute("board", board);
		return "update";
	}
	
	//수정하기
	@PostMapping("get/bUpdate")
	public String update(BoardDTO board) {
		service.update(board);
		//다시 main으로 reload
		return "redirect:list";
	}
	
	//삭제하기
	@GetMapping("bDelete")
	@ResponseBody
	public String delete(int num) {
		service.delete(num);
		return "success";
	}
}
