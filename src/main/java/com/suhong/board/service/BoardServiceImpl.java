package com.suhong.board.service;

import com.suhong.board.domain.BoardVO;
import com.suhong.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl {

  private final BoardMapper boardMapper;

  public BoardVO getOne(Integer bno) {
    return boardMapper.getOne(bno);
  }

}
