package com.suhong.board.controller;

import com.suhong.board.domain.BoardVO;
import com.suhong.board.mapper.BoardMapper;
import com.suhong.board.service.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board/")
public class BoardController {

  private final BoardServiceImpl boardService;

  @GetMapping("/list")
  public void list() {
    BoardVO boardVO = boardService.getOne(1);

  }

}