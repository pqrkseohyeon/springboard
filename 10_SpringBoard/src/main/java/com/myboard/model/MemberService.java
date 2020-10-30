package com.myboard.model;

import java.util.HashMap;
import java.util.List;


import com.myboard.util.MemberDTO;

public interface MemberService {
	//추가
	public void MemberInsert(MemberDTO member);
	//전체보기
	public List<MemberDTO> MemberList(HashMap<String, Object> hm);
	//수정
	public void MemberUpdate(MemberDTO member);
	//삭제
	public void MemberDelete(String id);
	//상세보기
	public MemberDTO MemberView(String id);
	//회원수
	public int MemberCount(HashMap<String, Object> hm);
	//로그인체크
	public MemberDTO LoginCheck(String id);
	//아이디체크
	public MemberDTO IdCheck(String id);
}
