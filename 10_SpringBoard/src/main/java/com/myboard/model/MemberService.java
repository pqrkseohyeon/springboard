package com.myboard.model;

import java.util.HashMap;
import java.util.List;


import com.myboard.util.MemberDTO;

public interface MemberService {
	//�߰�
	public void MemberInsert(MemberDTO member);
	//��ü����
	public List<MemberDTO> MemberList(HashMap<String, Object> hm);
	//����
	public void MemberUpdate(MemberDTO member);
	//����
	public void MemberDelete(String id);
	//�󼼺���
	public MemberDTO MemberView(String id);
	//ȸ����
	public int MemberCount(HashMap<String, Object> hm);
	//�α���üũ
	public MemberDTO LoginCheck(String id);
	//���̵�üũ
	public MemberDTO IdCheck(String id);
}
