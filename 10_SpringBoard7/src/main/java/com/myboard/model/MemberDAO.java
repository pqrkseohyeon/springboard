package com.myboard.model;

import java.util.List;

import com.myboard.dto.MemberDTO;

public interface MemberDAO {
	//아이디확인
	public int dao_idCheck(String id);
	//추가
	public void dao_mInsert(MemberDTO mdto);
	//로그인
	public MemberDTO dao_mLogin(String id);
	//전체보기
	public List<MemberDTO> dao_mList();
	//상세보기
	public MemberDTO dao_mDetail(String id);
	//수정
	public MemberDTO dao_mUpdate(String id);
	//삭제
	public void dao_mDelete(String id);
}
