package com.myboard.board;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myboard.model.MemberService;
import com.myboard.model.PageAction;
import com.myboard.util.MemberDTO;
import com.myboard.util.MemberListVO;


/*
2���̻� �Ű����� x,
1. HashMap ���
2. SearchDTO
3. @Param
*/

@RequestMapping("/member")
@Controller
public class MemberController {
	@Autowired
	private MemberService mservice;
		
	@Autowired
	private PageAction page;
	
	@PostMapping("join")
	public String insert(MemberDTO member) {		
		mservice.MemberInsert(member);
		return "login";
	}
	
	@GetMapping("list")
	public String list(Model model, String pageNum, String field, String word){
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("field", field);
		hm.put("word", word);
		
		int count = mservice.MemberCount(hm);
		
		//�� ȭ�鿡 �������� ��
		int pageSize=5;
		
		if(pageNum==null) pageNum="1";
		
		int currentPage = Integer.parseInt(pageNum);
		
		int startRow = (currentPage-1)*pageSize+1;
		int endRow = startRow+pageSize-1;
		
		if(endRow>=count) endRow = count;
		
		hm.put("startRow", startRow);
		hm.put("endRow", endRow);
		
		String pageHtml = page.paging(count, pageSize, currentPage, field, word);
		
		List<MemberDTO> list = mservice.MemberList(hm);
		model.addAttribute("count", count);
		model.addAttribute("memlist", list);
		model.addAttribute("pageHtml", pageHtml);
			
		return "mlist";
	}
	
	//�α��� ��
	@GetMapping("loginform")
	public String login() {
		return "login";
	}
	
	//ȸ������ ��
	@GetMapping("joinform")
	public String join() {
		return "join";
	}
	
	//���̵� üũ
	@GetMapping("idcheckform")
	public String idcheckform() {
		return "idCheck";
	}	
	
	//
	@PostMapping("idcheck")
	@ResponseBody
	public String idcheck(HttpServletRequest request, String id) {
		MemberDTO member = mservice.IdCheck(id);
		String result ="";
		
		if(member!=null) result="no";
		else result ="yes";
		return result;
	}
	
	//�α���
	@PostMapping("logincheck")
	@ResponseBody //json > object��							// @Param > ������ �Ű����� ������ ��
	public String logincheck(HttpServletRequest request, @Param("id") String id,@Param("pass") String pass) {
		
		MemberDTO member = mservice.LoginCheck(id);
		String result = "";
		
		//ȸ���� �ƴϸ�	
		if(member==null)	result = "no";
		
		//ȸ��O, ��й�ȣ�� ������
		else if(member.getPass().equals(pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("id", member.getId());
			result="success";
			
		}else {	//����� Ʋ����
			result = "passError";
		}		
		return result;
	}
	
	
	@GetMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:login";
	}
	
}
