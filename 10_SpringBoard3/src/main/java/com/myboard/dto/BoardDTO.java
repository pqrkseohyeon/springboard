package com.myboard.dto;

import lombok.Data;

@Data
public class BoardDTO {
	// ���� > int num�� �� �� long num�� ����
	private int num;
	private String title;
	private String content;
	private String writer;
	private String regdate;
	private int hitcount;
	private String password;
	private int replyCnt;
}