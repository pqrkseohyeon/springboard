package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myboard.dto.BoardDTO;
import com.myboard.util.SearchDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO dao;
	
	//�߰�
	@Override
	public void insert(BoardDTO board) {
		dao.dao_insert(board);		
	}

	//��ü����2
	@Override
	public List<BoardDTO> findAll(SearchDTO dto) {		
		return dao.dao_findAlls(dto);
	}
	
	//��ü����
	@Override
	public List<BoardDTO> findAll(HashMap<String, Object> hm) {		
		return dao.dao_findAll(hm);
	}
	
	//�󼼺���
	@Override
	public BoardDTO findByNum(int num) {
		return dao.dao_findByNum(num);
	}

	//�����ϱ�
	@Override
	public void update(BoardDTO board) {
		dao.dao_update(board);		
	}

	@Override
	public void delete(int num) {
		dao.dao_delete(num);
	}

	@Override
	public int count(SearchDTO sdto) {		
		return dao.dao_count(sdto);
	}

	@Override
	public boolean plusCnt(int num) {
		return dao.dao_plusCnt(num);
		
	}

	

}
