package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myboard.dto.BoardDTO;
import com.myboard.util.SearchDTO;

@Service
public class BoardServiceImpl  implements BoardService{
@Autowired
 private BoardDAO dao;
	@Override
	public int insert(BoardDTO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardDTO> findAll(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDTO findByNum(int num) {
		// TODO Auto-generated method stub
		return dao.dao_findByNum(num);
	}

	@Override
	public void update(BoardDTO board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BoardDTO> findAll(SearchDTO dto) {
		return dao.dao_findAll(dto);
	}

	@Override
	public int getCount(SearchDTO dto) {
		// TODO Auto-generated method stub
		return dao.dao_getCount(dto);
	}

}







