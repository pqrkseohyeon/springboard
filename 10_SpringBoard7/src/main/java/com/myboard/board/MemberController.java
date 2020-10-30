package com.myboard.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myboard.dto.MemberDTO;
import com.myboard.model.MemberService;

@RequestMapping("/member/*")
@Controller
public class MemberController {
	@Autowired
	public MemberService service;
	
	//가입페이지 이동
	@GetMapping("join")
	public String memberinsert() {
		return "mInsert";
	}
	
	//아이디 중복확인
	@PostMapping("idCheck")
	@ResponseBody
	public String idcheck(String id) {
		int result=service.idCheck(id);
		if(result>=1) {
			return "no";
		}else {
			return "yes";
		}
	}
	
	//회원가입
	@PostMapping("join")
	@ResponseBody
	public String memberinsert(@RequestBody MemberDTO mdto) {
		service.mInsert(mdto);
		return mdto.getId();
	}
	
	//로그인페이지 이동
	@GetMapping("login")
	public String memberlogin() {
		return "mLogin";
	}
	
	//로그인 실행
	/*
	 * id를 검사해서 pass 맞으면 회원
	 * id가 없으면 회원 아님
	 * id는 있는데 pass가 없으면 비번오류
	 * 
	 */
	
	@PostMapping("login")
	@ResponseBody //넘기는 것이 문자일때
	public String memberlogin(HttpServletRequest request, String id, String pass) {
		MemberDTO mdto=service.mLogin(id);
		String retStr="";
		if(mdto==null) { //멤버가 없을때
			retStr="no";
		}else if(mdto.getPass().equals(pass)){ //받아온 pass와 가져온 pass가 같을때
			retStr="success";
			HttpSession session=request.getSession();
			session.setAttribute("id", id);
		}else {
			retStr="passError";
		}
		return retStr;
	}
	
	//로그아웃
	@GetMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.invalidate();
		return "mLogin";
	}
	
	//회원정보 폼으로 이동
	@GetMapping("view")
	public String view(HttpServletRequest request, Model model) {
		HttpSession session=request.getSession();
		String userid=(String)session.getAttribute("id");
		MemberDTO mdto=service.mDetail(userid);
		model.addAttribute("member", mdto);
		return "mView";
	}
}
