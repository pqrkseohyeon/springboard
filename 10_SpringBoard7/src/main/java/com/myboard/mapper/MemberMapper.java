package com.myboard.mapper;

import java.util.List;

import com.myboard.dto.MemberDTO;

public interface MemberMapper {
	//아이디중복 확인
	public int idCheck(String id);
	//추가
	public void mInsert(MemberDTO mdto);
	//로그인
	public MemberDTO mLogin(String id);
	//전체보기
	public List<MemberDTO> mList();
	//상세보기
	public MemberDTO mDetail(String id);
	//수정
	public MemberDTO mUpdate(String id);
	//삭제
	public void mDelete(String id);
	
}
