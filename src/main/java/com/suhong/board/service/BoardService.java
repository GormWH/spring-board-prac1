package com.suhong.board.service;

import com.suhong.board.domain.BoardVO;
import com.suhong.board.dto.BoardDTO;
import com.suhong.board.dto.ListDTO;

import java.util.List;

public interface BoardService {

  BoardDTO getOne(Integer bno);

  List<BoardDTO> getList(ListDTO listDTO);

  void register(BoardDTO boardDTO);

  int getTotal();

  void modify(BoardDTO boardDTO);

  void delete(Integer bno);
}
