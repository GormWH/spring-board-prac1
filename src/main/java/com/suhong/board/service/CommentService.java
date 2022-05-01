package com.suhong.board.service;

import com.suhong.board.dto.CommentDTO;
import com.suhong.board.dto.ListDTO;

import java.util.List;

public interface CommentService {

  List<CommentDTO> getList(Integer bno, ListDTO listDTO);

  Integer register(CommentDTO commentDTO);

}
