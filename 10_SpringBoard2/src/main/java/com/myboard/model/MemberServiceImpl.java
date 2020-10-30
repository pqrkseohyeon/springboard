package com.myboard.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myboard.dto.MemberDTO;
import com.myboard.mapper.MemberMapper;

@Service
public class MemberServiceImpl  implements MemberService{
  @Autowired
  private MemberMapper memberMapper;
  
	@Override
	public MemberDTO login(String id) {
		return memberMapper.login(id);
	}

}
