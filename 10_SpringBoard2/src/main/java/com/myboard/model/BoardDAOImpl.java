package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myboard.dto.BoardDTO;
import com.myboard.mapper.BoardMapper;
import com.myboard.util.SearchDTO;


@Repository
public class BoardDAOImpl  implements BoardDAO{
  @Autowired
  private BoardMapper mapper;
	@Override
	public int dao_insert(BoardDTO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardDTO> dao_findAll(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDTO> dao_findAll(SearchDTO dto) {
		return mapper.findAlls(dto);
	}

	@Override
	public BoardDTO dao_findByNum(int num) {
		// TODO Auto-generated method stub
		return mapper.findByNum(num);
	}

	@Override
	public void dao_update(BoardDTO board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dao_delete(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int dao_getCount(SearchDTO dto) {
		// TODO Auto-generated method stub
		return mapper.getCount(dto);
	}

}
