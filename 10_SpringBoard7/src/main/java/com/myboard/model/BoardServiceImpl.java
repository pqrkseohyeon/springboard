package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myboard.dto.BoardDTO;
import com.myboard.util.SearchDTO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO dao;

	//추가
	@Override
	public int insert(BoardDTO board) {
		return dao.dao_insert(board);
	}

	//전체보기
	public List<BoardDTO> findAll(SearchDTO dto) {
		return dao.dao_findAll(dto);
	}

	@Override
	public BoardDTO findByNum(int num) {
		return dao.dao_findByNum(num);
	}

	@Override
	public void update(BoardDTO board) {
		dao.dao_update(board);
	}

	@Override
	public void delete(int num) {
		dao.dao_delete(num);
	}

	@Override
	public int getCount(SearchDTO sdto) {
		return dao.dao_getCount(sdto);
	}
}
