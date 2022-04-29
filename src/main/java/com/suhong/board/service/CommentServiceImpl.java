package com.suhong.board.service;

import com.suhong.board.domain.CommentVO;
import com.suhong.board.dto.CommentDTO;
import com.suhong.board.dto.ListDTO;
import com.suhong.board.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class CommentServiceImpl implements CommentService{

  private final CommentMapper commentMapper;
  private final ModelMapper modelMapper;

  @Override
  public List<CommentDTO> getList(Integer bno, ListDTO listDTO) {
    List<CommentVO> commentVOList = commentMapper.getList(bno, listDTO);
    List<CommentDTO> commentDTOList = commentVOList.stream()
            .map(commentVO -> modelMapper.map(commentVO, CommentDTO.class))
            .collect(Collectors.toList());
    return commentDTOList;
  }
}
