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
	
	//���������� �̵�
	@GetMapping("join")
	public String memberinsert() {
		return "mInsert";
	}
	
	//���̵� �ߺ�Ȯ��
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
	
	//ȸ������
	@PostMapping("join")
	@ResponseBody
	public String memberinsert(@RequestBody MemberDTO mdto) {
		service.mInsert(mdto);
		return mdto.getId();
	}
	
	//�α��������� �̵�
	@GetMapping("login")
	public String memberlogin() {
		return "mLogin";
	}
	
	//�α��� ����
	/*
	 * id�� �˻��ؼ� pass ������ ȸ��
	 * id�� ������ ȸ�� �ƴ�
	 * id�� �ִµ� pass�� ������ �������
	 * 
	 */
	
	@PostMapping("login")
	@ResponseBody //�ѱ�� ���� �����϶�
	public String memberlogin(HttpServletRequest request, String id, String pass) {
		MemberDTO mdto=service.mLogin(id);
		String retStr="";
		if(mdto==null) { //����� ������
			retStr="no";
		}else if(mdto.getPass().equals(pass)){ //�޾ƿ� pass�� ������ pass�� ������
			retStr="success";
			HttpSession session=request.getSession();
			session.setAttribute("id", id);
		}else {
			retStr="passError";
		}
		return retStr;
	}
	
	//�α׾ƿ�
	@GetMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.invalidate();
		return "mLogin";
	}
	
	//ȸ������ ������ �̵�
	@GetMapping("view")
	public String view(HttpServletRequest request, Model model) {
		HttpSession session=request.getSession();
		String userid=(String)session.getAttribute("id");
		MemberDTO mdto=service.mDetail(userid);
		model.addAttribute("member", mdto);
		return "mView";
	}
}
