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

	//추가하기
	public int dao_insert(BoardDTO board) {
		return mapper.insert(board);
	}
	//전체보기
	public List<BoardDTO> dao_findAll(SearchDTO dto) {
		return mapper.findAll(dto);
	}
	//상세보기
	public BoardDTO dao_findByNum(int num) {
		return mapper.findByNum(num);
	}

	//수정
	public void dao_update(BoardDTO board) {
		mapper.update(board);
	}

	//삭제
	public void dao_delete(int num) {
		mapper.delete(num);
	}

	//개수출력
	public int dao_getCount(SearchDTO sdto) {
		return mapper.getCount(sdto);
	}
}