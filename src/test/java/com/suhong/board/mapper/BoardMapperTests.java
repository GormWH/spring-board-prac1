package com.suhong.board.mapper;

import com.suhong.board.domain.BoardVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j2
public class BoardMapperTests {

  @Autowired(required = false)
  private BoardMapper boardMapper;

  @Test
  public void testGetOne() {
    BoardVO boardVO = boardMapper.getOne(1);
    log.info(boardVO);
  }

}
