package com.myboard.util;

import java.util.List;

import lombok.Data;

@Data
public class MemberListVO {
	private int count;
	private List<MemberDTO> list;
	private String pageHtml;
	
	public MemberListVO(int count, List<MemberDTO> list,String pageHtml ) {
		this.count=count;
		this.list=list;
		this.pageHtml=pageHtml;
	}
	
	
}
