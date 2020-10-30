package com.myboard.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myboard.dto.BoardDTO;
import com.myboard.util.SearchDTO;

public interface BoardMapper {
	//�߰�
	public int insert(BoardDTO board);
	//����Ʈ
	public List<BoardDTO> findAll(HashMap<String, Object> hm);
	//����Ʈ
	public List<BoardDTO> findAlls(SearchDTO dto);
	
	//�󼼺���
	public BoardDTO findByNum(int num);
	//����
	public void update(BoardDTO board);
	//����
	public void delete(int num);
	//����
	public int getCount(SearchDTO dto);
	
	//reply ���� ����
	 public void updateReplyCnt(@Param("bnum") int bnum, @Param("amount") int amount);

}
