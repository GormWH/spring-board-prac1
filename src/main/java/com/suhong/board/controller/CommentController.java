package com.suhong.board.controller;

import com.suhong.board.dto.CommentDTO;
import com.suhong.board.dto.ListDTO;
import com.suhong.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

  private final CommentService commentService;

  @GetMapping("/")
  public String root() {
    return "comment root";
  }

  @GetMapping(value = "/list/{bno}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<CommentDTO> list(@PathVariable("bno") Integer bno, ListDTO listDTO) {
    return commentService.getList(bno, listDTO);
  }

}
