package com.myboard.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myboard.mapper.BoardMapper;
import com.myboard.mapper.CommentMapper;
import com.myboard.util.CommentDTO;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private BoardMapper bmapper;
	
	@Autowired 	//dao 없애기루함.
	private CommentMapper cmapper;
	
	//추가
	@Override
	@Transactional //class내 내용 일련작업으로 처리 , service에서 이루어짐 (view 아님)
	public void insert(CommentDTO dto) {
		/*순서 넘나뤼 중요 bmapper  먼저 > cmapper*/
		bmapper.updateReplyCnt(dto.getBnum(),1);
		
		cmapper.insert(dto);		
	}
	
	//댓글 전체보기
	@Override
	public List<CommentDTO> getList(int bnum) {
		return cmapper.getList(bnum);
	}

	@Transactional
	@Override
	public void delete(int cnum) {		
		CommentDTO cdto = cmapper.read(cnum);
		//cnum에 해당되는 cdto 한 row 들고오기
		bmapper.updateReplyCnt(cdto.getBnum(),-1);	
		
		cmapper.delete(cnum);			
	}

}
