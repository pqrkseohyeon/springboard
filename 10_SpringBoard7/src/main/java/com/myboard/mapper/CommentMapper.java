package com.myboard.mapper;

import java.util.List;

import com.myboard.dto.CommentDTO;

public interface CommentMapper {
	public List<CommentDTO> getList(int bnum);
	//�߰��ϱ�
	public void insert(CommentDTO cdto);
	//�����ϱ�
	public void delete(int cnum);
}
