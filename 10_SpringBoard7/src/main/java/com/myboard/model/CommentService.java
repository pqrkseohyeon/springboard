package com.myboard.model;

import java.util.List;

import com.myboard.dto.CommentDTO;

public interface CommentService {
	//�߰�
	public void insert(CommentDTO cdto);
	//�󼼺���
	public List<CommentDTO> getList(int num);
	//����
	//����
	public void delete(int cnum);
	//����Ʈ

}
