package com.suhong.board.mapper;

import com.suhong.board.domain.BoardVO;
import com.suhong.board.dto.ListDTO;

import java.util.List;


public interface BoardMapper {

  BoardVO getOne(Integer bno);

  List<BoardVO> getList(ListDTO listDTO);

  void register(BoardVO boardVO);

  int getTotal();

  void modify(BoardVO boardVO);

  void delete(Integer bno);
}
