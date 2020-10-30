package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.myboard.util.MemberDTO;


public interface MemberDAO {
	//추가
	public void dao_MemberInsert(MemberDTO member);
	//전체보기
	public List<MemberDTO> dao_MemberList(HashMap<String, Object> hm);
	//수정
	public void dao_MemberUpdate(MemberDTO member);
	//삭제
	public void dao_MemberDelete(String id);
	//상세보기
	public MemberDTO dao_MemberView(String id);
	//회원수
	public int dao_MemberCount(HashMap<String, Object> hm);
	//로그인 체크
	public MemberDTO dao_LoginCheck(String id);
	//아이디 체크
	public MemberDTO dao_IdCheck(String id);
}
