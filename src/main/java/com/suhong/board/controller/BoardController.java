package com.suhong.board.controller;

import com.suhong.board.domain.BoardVO;
import com.suhong.board.dto.BoardDTO;
import com.suhong.board.dto.ListDTO;
import com.suhong.board.mapper.BoardMapper;
import com.suhong.board.service.BoardServiceImpl;
import com.suhong.util.Paginator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board/")
public class BoardController {

  private final BoardServiceImpl boardService;

  @GetMapping("/list")
  public void listGET(ListDTO listDTO, Model model) {
    List<BoardDTO> boardList = boardService.getList(listDTO);

    model.addAttribute("boardList", boardList);
    model.addAttribute("paginator", new Paginator(listDTO, boardService.getTotal()));
  }

  @GetMapping("/register")
  public void registerGET(ListDTO listDTO) {
    // blank body
  }

  @PostMapping("/register")
  public String registerPOST(@Param("boardDTO") BoardDTO boardDTO, ListDTO listDTO, Model model) {
    boardService.register(boardDTO);
    return "redirect:/board/list";
  }

  @GetMapping("/read/{bno}")
  public String readGET(@PathVariable("bno") Integer bno, ListDTO listDTO, Model model) {
    BoardDTO boardDTO = boardService.getOne(bno);
    model.addAttribute("boardDTO", boardDTO);
    return "/board/read";
  }

  @GetMapping("/modify/{bno}")
  public String modifyGET(@PathVariable("bno") Integer bno, ListDTO listDTO, Model model) {
    BoardDTO boardDTO = boardService.getOne(bno);
    model.addAttribute("boardDTO", boardDTO);
    return "/board/modify";
  }

  @PostMapping("/modify/{bno}")
  public String modifyPOST(@PathVariable("bno") Integer bno, BoardDTO boardDTO, ListDTO listDTO, Model model) {
    log.info(boardDTO);
    log.info(listDTO);
    boardService.modify(boardDTO);
    return String.format("redirect:/board/read/%d", bno);
  }

  @PostMapping("/delete/{bno}")
  public String deletePOST(@PathVariable("bno") Integer bno, ListDTO listDTO) {
    log.info("delete: " + bno);
    boardService.delete(bno);
    return "/board/list";
  }

}
