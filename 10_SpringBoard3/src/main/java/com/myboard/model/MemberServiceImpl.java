package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myboard.util.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO dao;
	
	@Override
	public void MemberInsert(MemberDTO member) {
		dao.dao_MemberInsert(member);
	}

	@Override
	public List<MemberDTO> MemberList(HashMap<String, Object> hm) {		
		return dao.dao_MemberList(hm);
	}

	@Override
	public void MemberUpdate(MemberDTO member) {
		
		
	}

	@Override
	public void MemberDelete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberDTO MemberView(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int MemberCount(HashMap<String, Object> hm) {
		return dao.dao_MemberCount(hm);
	}


	@Override
	public MemberDTO LoginCheck(String id) {
		return dao.dao_LoginCheck(id);
	}

	@Override
	public MemberDTO IdCheck(String id) {		
		return dao.dao_IdCheck(id);
	}

	

}
