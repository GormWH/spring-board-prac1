package com.suhong.board.mapper;

import com.suhong.board.domain.CommentVO;
import com.suhong.board.dto.ListDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {

  List<CommentVO> getList(@Param("bno")Integer bno, @Param("listDTO")ListDTO listDTO);

  void register(CommentVO commentVO);

  int getCommentCount(Integer bno);
}
