package com.myboard.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myboard.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	public MemberDAO dao;
	
	//아이디 체크
	public int idCheck(String id) {
		return dao.dao_idCheck(id);
	}
	
	@Override
	public void mInsert(MemberDTO mdto) {
		dao.dao_mInsert(mdto);
	}

	@Override
	public List<MemberDTO> mList() {
		return dao.dao_mList();
	}

	@Override
	public MemberDTO mDetail(String id) {
		return dao.dao_mDetail(id);
	}

	@Override
	public MemberDTO mUpdate(String id) {
		return dao.dao_mUpdate(id);
	}

	@Override
	public void mDelete(String id) {
		dao.dao_mDelete(id);
	}

	@Override
	public MemberDTO mLogin(String id) {
		return dao.dao_mLogin(id);
	}

}
