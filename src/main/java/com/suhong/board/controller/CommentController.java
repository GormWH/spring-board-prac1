package com.suhong.board.controller;

import com.suhong.board.dto.CommentDTO;
import com.suhong.board.dto.ListDTO;
import com.suhong.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

  @PostMapping(value = "/register")
  public Map<String, Integer> register(@RequestBody CommentDTO commentDTO) {
    log.info("======/comment/register======");
    int commentCount = commentService.register(commentDTO);
    return Map.of("result", commentCount);
  }

}
