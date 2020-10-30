package com.myboard.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.myboard.dto.BoardDTO;
import com.myboard.util.SearchDTO;


/*
 * Mapper > 매개변수 2개 이상 > Param 어노테이션 쓰기
 * 
 */
public interface BoardMapper {
	
@Insert ("INSERT INTO SPRINGBOARD VALUES(SPRINGBOARD_SEQ.NEXTVAL, #{title}, #{content}, #{writer}, SYSDATE, #{hitcount}, #{password}, 0)")

	// mapper.class 명 = mapper.xml id
	//추가
	public void insert(BoardDTO board);
	//전체보기
	public List<BoardDTO> list(HashMap<String, Object>hm);
	//전체보기2
	public List<BoardDTO> findAlls(SearchDTO dto);
	//수정
	public void update(BoardDTO board);
	//삭제
	public void delete(int num);
	//상세보기
	public BoardDTO view(int num);
	//개수
	public int count(SearchDTO dto);
	//조회수 증가
	public boolean plusCnt(int num);
	//댓글수 증가
	public void updateReplyCnt(@Param("bnum") int bnum, @Param("cnt") int cnt);
	// @Param > xml의 #{}(변수)에 해당
}
