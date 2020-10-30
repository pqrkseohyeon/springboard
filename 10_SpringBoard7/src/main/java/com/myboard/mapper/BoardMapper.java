package com.myboard.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;

import com.myboard.dto.BoardDTO;
import com.myboard.util.SearchDTO;

public interface BoardMapper {
	//�߰�
	public int insert(BoardDTO board);
	//��ü����
	public List<BoardDTO> findAll(SearchDTO dto);
	//�󼼺���
	public BoardDTO findByNum(int num);
	//����
	public void update(BoardDTO board);
	//����
	public void delete(int num);
	//����
	public int getCount(SearchDTO sdto);
	//��� �� ����
	public void updateReplyCnt(int num, int one);
}
