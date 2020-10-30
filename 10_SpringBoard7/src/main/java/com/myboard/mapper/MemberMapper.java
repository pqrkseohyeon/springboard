package com.myboard.mapper;

import java.util.List;

import com.myboard.dto.MemberDTO;

public interface MemberMapper {
	//���̵��ߺ� Ȯ��
	public int idCheck(String id);
	//�߰�
	public void mInsert(MemberDTO mdto);
	//�α���
	public MemberDTO mLogin(String id);
	//��ü����
	public List<MemberDTO> mList();
	//�󼼺���
	public MemberDTO mDetail(String id);
	//����
	public MemberDTO mUpdate(String id);
	//����
	public void mDelete(String id);
	
}
