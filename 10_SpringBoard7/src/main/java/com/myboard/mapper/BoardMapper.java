package com.myboard.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;

import com.myboard.dto.BoardDTO;
import com.myboard.util.SearchDTO;

public interface BoardMapper {
	//추가
	public int insert(BoardDTO board);
	//전체보기
	public List<BoardDTO> findAll(SearchDTO dto);
	//상세보기
	public BoardDTO findByNum(int num);
	//수정
	public void update(BoardDTO board);
	//삭제
	public void delete(int num);
	//개수
	public int getCount(SearchDTO sdto);
	//댓글 수 업뎃
	public void updateReplyCnt(int num, int one);
}
