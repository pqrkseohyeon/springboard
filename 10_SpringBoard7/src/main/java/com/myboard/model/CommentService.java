package com.myboard.model;

import java.util.List;

import com.myboard.dto.CommentDTO;

public interface CommentService {
	//추가
	public void insert(CommentDTO cdto);
	//상세보기
	public List<CommentDTO> getList(int num);
	//수정
	//삭제
	public void delete(int cnum);
	//리스트

}
