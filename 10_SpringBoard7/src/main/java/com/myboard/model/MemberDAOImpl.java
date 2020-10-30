package com.myboard.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myboard.dto.MemberDTO;
import com.myboard.mapper.MemberMapper;

@Repository
public class MemberDAOImpl implements MemberDAO{
	@Autowired
	public MemberMapper mapper;
	
	@Override
	public void dao_mInsert(MemberDTO mdto) {
		mapper.mInsert(mdto);
	}

	@Override
	public List<MemberDTO> dao_mList() {
		return mapper.mList();
	}

	@Override
	public MemberDTO dao_mDetail(String id) {
		return mapper.mDetail(id);
	}

	@Override
	public MemberDTO dao_mUpdate(String id) {
		return mapper.mUpdate(id);
	}

	@Override
	public void dao_mDelete(String id) {
		mapper.mDelete(id);
	}

	@Override
	public int dao_idCheck(String id) {
		return mapper.idCheck(id);
	}

	@Override
	public MemberDTO dao_mLogin(String id) {
		return mapper.mLogin(id);
	}

}
