package com.myboard.model;

import java.util.List;

import com.myboard.util.CommentDTO;

public interface CommentService {
	//�߰�
	public void insert(CommentDTO dto);
	//�󼼺���
	public List<CommentDTO> getList(int bnum);
	public void delete(int cnum);
}
