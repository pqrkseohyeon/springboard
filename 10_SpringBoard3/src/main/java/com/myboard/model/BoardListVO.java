package com.myboard.model;

import java.util.List;

import com.myboard.dto.BoardDTO;

import lombok.Data;

@Data
public class BoardListVO {
	private int count;
	private List<BoardDTO> list;
	private String pageHtml;
	
	public BoardListVO(int count, List<BoardDTO> list, String pageHtml) {
		this.count=count;
		this.list=list;
		this.pageHtml=pageHtml;
	}	
}
