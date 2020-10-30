package com.myboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myboard.dto.CommentDTO;
import com.myboard.dto.MemberDTO;

public interface MemberMapper {
	//public MemberDTO login(@Param("id") String id,
	//		                             @Param("pass") String pass);
	public MemberDTO login(String id);
}
