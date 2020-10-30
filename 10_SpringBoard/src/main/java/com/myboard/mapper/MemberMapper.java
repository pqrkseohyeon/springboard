package com.myboard.mapper;

import java.util.HashMap;
import java.util.List;


import com.myboard.util.MemberDTO;

public interface MemberMapper {
	
	
	public void insert(MemberDTO member);
	public List<MemberDTO> list(HashMap<String, Object> hm);
	public int count(HashMap<String, Object> hm);
	public MemberDTO logincheck(String id);
	public MemberDTO idcheck(String id);
}
