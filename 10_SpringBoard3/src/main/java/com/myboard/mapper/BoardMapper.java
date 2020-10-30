package com.myboard.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.myboard.dto.BoardDTO;
import com.myboard.util.SearchDTO;


/*
 * Mapper > �Ű����� 2�� �̻� > Param ������̼� ����
 * 
 */
public interface BoardMapper {
	
@Insert ("INSERT INTO SPRINGBOARD VALUES(SPRINGBOARD_SEQ.NEXTVAL, #{title}, #{content}, #{writer}, SYSDATE, #{hitcount}, #{password}, 0)")

	// mapper.class �� = mapper.xml id
	//�߰�
	public void insert(BoardDTO board);
	//��ü����
	public List<BoardDTO> list(HashMap<String, Object>hm);
	//��ü����2
	public List<BoardDTO> findAlls(SearchDTO dto);
	//����
	public void update(BoardDTO board);
	//����
	public void delete(int num);
	//�󼼺���
	public BoardDTO view(int num);
	//����
	public int count(SearchDTO dto);
	//��ȸ�� ����
	public boolean plusCnt(int num);
	//��ۼ� ����
	public void updateReplyCnt(@Param("bnum") int bnum, @Param("cnt") int cnt);
	// @Param > xml�� #{}(����)�� �ش�
}
