package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import com.myboard.dto.BoardDTO;
import com.myboard.util.SearchDTO;

public interface BoardService {
	//추가
	public void insert(BoardDTO board);
	//리스트
	public List<BoardDTO> findAll(HashMap<String, Object> hm);
	//리스트2
	public List<BoardDTO> findAll(SearchDTO dto);
	//상세보기
	public BoardDTO findByNum(int num);
	//수정
	public void update(BoardDTO board);
	//삭제
	public void delete(int num);
	//개수
	public int count(SearchDTO sdto);
	//조회수 증가
	public boolean plusCnt(int num);
}
