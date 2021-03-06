package com.suhong.board.mapper;

import com.suhong.board.domain.BoardVO;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class BoardMapperTests {

  @Autowired(required = false)
  private BoardMapper boardMapper;

  @Test
  public void testGetOne() {
    log.info("=============");
    log.info(boardMapper);
    BoardVO boardVO = boardMapper.getOne(1);
    log.info(boardVO);
  }

}
