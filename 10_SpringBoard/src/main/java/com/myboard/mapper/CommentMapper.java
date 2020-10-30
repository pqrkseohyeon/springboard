package com.myboard.mapper;

import java.util.List;

import com.myboard.util.CommentDTO;

public interface CommentMapper {
	

	public List<CommentDTO> getList(int bnum);
	public void insert(CommentDTO dto);
	public void delete(int cnum);
	public CommentDTO read(int cnum);
}
