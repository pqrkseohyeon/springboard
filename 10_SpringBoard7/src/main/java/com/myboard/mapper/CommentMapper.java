package com.myboard.mapper;

import java.util.List;

import com.myboard.dto.CommentDTO;

public interface CommentMapper {
	public List<CommentDTO> getList(int bnum);
	//추가하기
	public void insert(CommentDTO cdto);
	//삭제하기
	public void delete(int cnum);
}
