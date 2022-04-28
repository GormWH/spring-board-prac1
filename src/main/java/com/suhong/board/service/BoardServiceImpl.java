package com.suhong.board.service;

import com.suhong.board.domain.BoardVO;
import com.suhong.board.dto.BoardDTO;
import com.suhong.board.dto.ListDTO;
import com.suhong.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService{

  private final ModelMapper modelMapper;
  private final BoardMapper boardMapper;

  @Override
  public BoardDTO getOne(Integer bno) {
    return modelMapper.map(boardMapper.getOne(bno), BoardDTO.class);
  }

  @Override
  public List<BoardDTO> getList(ListDTO listDTO) {
    List<BoardVO> boardVOList = boardMapper.getList(listDTO);
    List<BoardDTO> boardDTOList = boardVOList.stream()
            .map(boardVO -> modelMapper.map(boardVO, BoardDTO.class))
            .collect(Collectors.toList());
    return boardDTOList;
  }

  @Override
  public void register(BoardDTO boardDTO) {
    boardMapper.register(modelMapper.map(boardDTO, BoardVO.class));
  }

  @Override
  public int getTotal() {
    return boardMapper.getTotal();
  }

  @Override
  public void modify(BoardDTO boardDTO) {
    boardMapper.modify(modelMapper.map(boardDTO, BoardVO.class));
  }

  @Override
  public void delete(Integer bno) {
    boardMapper.delete(bno);
  }
}
