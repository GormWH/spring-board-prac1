package com.suhong.board.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentVO {
  private Integer cno;
  private Integer bno;
  private String commentText;
  private String commenter;
  private LocalDateTime regDate;
  private LocalDateTime updateDate;
}
