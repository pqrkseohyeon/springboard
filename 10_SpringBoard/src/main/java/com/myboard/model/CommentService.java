package com.myboard.model;

import java.util.List;

import com.myboard.util.CommentDTO;

public interface CommentService {
	//추가
	public void insert(CommentDTO dto);
	//상세보기
	public List<CommentDTO> getList(int bnum);
	public void delete(int cnum);
}
