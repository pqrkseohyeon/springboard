package com.myboard.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CommentDTO {
	private int cnum;
	private String userid;
	private String content;
	@JsonFormat(shape= JsonFormat.Shape.STRING, 
			pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date regdate;
	private int bnum;
	
	
	

}
