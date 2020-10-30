package com.myboard.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myboard.dto.CommentDTO;
import com.myboard.mapper.BoardMapper;
import com.myboard.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentMapper cmapper;
	private BoardMapper bmapper;

	@Override
	public List<CommentDTO> getList(int bnum) {
		return cmapper.getList(bnum);
	}

	//¥Ò±€ √ﬂ∞°
	@Override
	public void insert(CommentDTO cdto) {
		bmapper.updateReplyCnt(cdto.getBnum(), 1);
		cmapper.insert(cdto);
	}
	
	//¥Ò±€ ªË¡¶
	public void delete(int cnum) {
		cmapper.delete(cnum);
	}
}