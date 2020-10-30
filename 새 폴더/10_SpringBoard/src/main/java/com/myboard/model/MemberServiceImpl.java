package com.myboard.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myboard.dto.MemberDTO;
import com.myboard.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired MemberMapper mMapper;
	
	public void join(MemberDTO member) {
		mMapper.join(member);
	}
	
	public int idCheck(String id) {
		return mMapper.idCheck(id);
	}
	
	public MemberDTO loginCheck(String id) {
		return mMapper.loginCheck(id);
	}
}
