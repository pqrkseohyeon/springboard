package com.myboard.model;

import java.util.List;

import com.myboard.dto.MemberDTO;

public interface MemberDAO {
	//���̵�Ȯ��
	public int dao_idCheck(String id);
	//�߰�
	public void dao_mInsert(MemberDTO mdto);
	//�α���
	public MemberDTO dao_mLogin(String id);
	//��ü����
	public List<MemberDTO> dao_mList();
	//�󼼺���
	public MemberDTO dao_mDetail(String id);
	//����
	public MemberDTO dao_mUpdate(String id);
	//����
	public void dao_mDelete(String id);
}
