package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myboard.dto.BoardDTO;
import com.myboard.mapper.BoardMapper;
import com.myboard.util.SearchDTO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public void dao_insert(BoardDTO board) {
		mapper.insert(board);		
	}

	//전체보기
	@Override
	public List<BoardDTO> dao_findAll(HashMap<String, Object> hm) {		
		return mapper.list(hm);
	}
	
	//전체보기2
	@Override
	public List<BoardDTO> dao_findAlls(SearchDTO dto) {
		return mapper.findAlls(dto);
	}

	@Override
	public BoardDTO dao_findByNum(int num) {
		return mapper.view(num);
	}

	//수정하기
	@Override
	public void dao_update(BoardDTO board) {
		mapper.update(board);
	}

	@Override
	public void dao_delete(int num) {
		mapper.delete(num);		
	}

	@Override
	public int dao_count(SearchDTO dto) {
		return mapper.count(dto);
		
	}

	@Override
	public boolean dao_plusCnt(int num) {
		return mapper.plusCnt(num);
	}

	

}
