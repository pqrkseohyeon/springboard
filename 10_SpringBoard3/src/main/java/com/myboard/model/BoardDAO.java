package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import com.myboard.dto.BoardDTO;
import com.myboard.util.SearchDTO;

public interface BoardDAO {
	//추가
	public void dao_insert(BoardDTO board);
	//리스트
	public List<BoardDTO> dao_findAll(HashMap<String, Object> hm);
	//전체보기2
	public List<BoardDTO> dao_findAlls(SearchDTO dto);
	//상세보기
	public BoardDTO dao_findByNum(int num);
	//수정
	public void dao_update(BoardDTO board);
	//삭제
	public void dao_delete(int num);
	//개수
	public int dao_count(SearchDTO dto);
	//조회수 증가
	public boolean dao_plusCnt(int num);
}
