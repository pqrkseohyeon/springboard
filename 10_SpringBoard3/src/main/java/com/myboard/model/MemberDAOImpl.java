package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myboard.mapper.MemberMapper;
import com.myboard.util.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public void dao_MemberInsert(MemberDTO member) {
		mapper.insert(member);
	}

	@Override
	public List<MemberDTO> dao_MemberList(HashMap<String, Object> hm) {		
		return mapper.list(hm);
	}

	@Override
	public void dao_MemberUpdate(MemberDTO member) {
	
	}

	@Override
	public void dao_MemberDelete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberDTO dao_MemberView(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int dao_MemberCount(HashMap<String, Object> hm) {
		return mapper.count(hm);
	}


	@Override
	public MemberDTO dao_LoginCheck(String id) {
		// TODO Auto-generated method stub
		return mapper.logincheck(id);
	}

	@Override
	public MemberDTO dao_IdCheck(String id) {
		return mapper.idcheck(id);
	}

}
