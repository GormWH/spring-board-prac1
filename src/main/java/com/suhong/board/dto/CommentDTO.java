package com.suhong.board.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDTO {
  private Integer cno;
  private Integer bno;
  private String commentText;
  private String commenter;
  private LocalDateTime regDate;
  private LocalDateTime updateDate;
}
