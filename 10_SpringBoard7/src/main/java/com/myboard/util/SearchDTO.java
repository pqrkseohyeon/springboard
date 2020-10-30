package com.myboard.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDTO {
	private int pageNum=1;
	private int amount=10;
	private String field;
	private String word;
	


}
