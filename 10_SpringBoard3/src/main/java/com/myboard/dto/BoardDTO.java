package com.myboard.dto;

import lombok.Data;

@Data
public class BoardDTO {
	// 실제 > int num은 넘 작 long num이 적절
	private int num;
	private String title;
	private String content;
	private String writer;
	private String regdate;
	private int hitcount;
	private String password;
	private int replyCnt;
}
