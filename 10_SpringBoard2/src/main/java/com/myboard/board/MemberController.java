package com.myboard.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myboard.dto.MemberDTO;
import com.myboard.model.MemberService;

@RequestMapping("/member/*")
@Controller
public class MemberController {
	@Autowired
	private MemberService mService;

	//ȸ��������
	@GetMapping("join")
	public String join() {
		return "join";
	}
	//�α���
	/*
	 *   id�� �˻��ؼ�  pass ������ ȸ��
	 *   id�� ������ ȸ���ƴ�
	 *   id�� �ִµ� pass�� ������ ��� ����
	 * 
	 */
	@PostMapping
	@ResponseBody
	public String login(String id, String pass,HttpServletRequest request) {
		MemberDTO member = mService.login(id);
		String retStr ="";
		if(member==null) {
			retStr ="no";
		}else if(member.getPass().equals(pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("sessionDto", member);
			retStr ="success";
		}else {
			retStr ="passError";
		}
		return retStr;
		
	}
}
