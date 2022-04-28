package com.suhong.util;

import com.suhong.board.dto.ListDTO;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Paginator {

  private int page;
  private int size;
  private int total;
  private int start, end;
  private boolean prev, next;

  public Paginator(ListDTO listDTO, int total) {
    this.page = listDTO.getPage();
    this.size = listDTO.getSize();
    this.total = total;

    int maxPage = (this.total - 1) / this.size + 1;

    int end = ((this.page - 1) / this.size + 1) * 10;
    this.start = end - 9;
    this.end = Math.min(end, maxPage);

    this.prev = this.start != 1;
    this.next = this.end < maxPage;
  }

}
