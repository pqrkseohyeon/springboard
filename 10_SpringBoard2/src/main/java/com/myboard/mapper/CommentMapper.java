package com.myboard.mapper;

import java.util.List;

import com.myboard.dto.CommentDTO;

public interface CommentMapper {
  public List<CommentDTO> getList(int bnum);
  public void insert(CommentDTO  cdto);
  public void delete(int cnum);
}
