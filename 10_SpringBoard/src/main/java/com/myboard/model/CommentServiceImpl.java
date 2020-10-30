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
	
	@Autowired 	//dao ���ֱ����.
	private CommentMapper cmapper;
	
	//�߰�
	@Override
	@Transactional //class�� ���� �Ϸ��۾����� ó�� , service���� �̷���� (view �ƴ�)
	public void insert(CommentDTO dto) {
		/*���� �ѳ��� �߿� bmapper  ���� > cmapper*/
		bmapper.updateReplyCnt(dto.getBnum(),1);
		
		cmapper.insert(dto);		
	}
	
	//��� ��ü����
	@Override
	public List<CommentDTO> getList(int bnum) {
		return cmapper.getList(bnum);
	}

	@Transactional
	@Override
	public void delete(int cnum) {		
		CommentDTO cdto = cmapper.read(cnum);
		//cnum�� �ش�Ǵ� cdto �� row ������
		bmapper.updateReplyCnt(cdto.getBnum(),-1);	
		
		cmapper.delete(cnum);			
	}

}
