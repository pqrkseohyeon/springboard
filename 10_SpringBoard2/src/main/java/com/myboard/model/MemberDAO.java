package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.myboard.util.MemberDTO;


public interface MemberDAO {
	//�߰�
	public void dao_MemberInsert(MemberDTO member);
	//��ü����
	public List<MemberDTO> dao_MemberList(HashMap<String, Object> hm);
	//����
	public void dao_MemberUpdate(MemberDTO member);
	//����
	public void dao_MemberDelete(String id);
	//�󼼺���
	public MemberDTO dao_MemberView(String id);
	//ȸ����
	public int dao_MemberCount(HashMap<String, Object> hm);
	//�α��� üũ
	public MemberDTO dao_LoginCheck(String id);
	//���̵� üũ
	public MemberDTO dao_IdCheck(String id);
}
