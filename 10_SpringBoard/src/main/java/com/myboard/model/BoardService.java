package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import com.myboard.dto.BoardDTO;
import com.myboard.util.SearchDTO;

public interface BoardService {
	//�߰�
	public void insert(BoardDTO board);
	//����Ʈ
	public List<BoardDTO> findAll(HashMap<String, Object> hm);
	//����Ʈ2
	public List<BoardDTO> findAll(SearchDTO dto);
	//�󼼺���
	public BoardDTO findByNum(int num);
	//����
	public void update(BoardDTO board);
	//����
	public void delete(int num);
	//����
	public int count(SearchDTO sdto);
	//��ȸ�� ����
	public boolean plusCnt(int num);
}
