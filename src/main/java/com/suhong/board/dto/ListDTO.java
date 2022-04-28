package com.suhong.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ListDTO {

  private int page;
  private int size;
  private String searchType;
  private String searchKeyword;

  public ListDTO() {
    this.page = 1;
    this.size = 10;
  }

  public String getLink() {
    StringBuilder builder = new StringBuilder();
    builder.append(String.format("?page=%d&size=%d", page, size));
    if (searchType != null) {
      builder.append(String.format("&searchType=%s", searchType));
    }
    if (searchKeyword != null) {
      builder.append(String.format("&searchKeyword=%s", searchKeyword));
    }
    return builder.toString();
  }

  public int getSkip() {
    return (page - 1) * size;
  }

  public void setPage(int page) {
    this.page = Math.max(1, page);
  }

  public void setSize(int size) {
    this.size = Math.max(size, 10);
  }

  public void setSearchType(String searchType) {
    this.searchType = searchType;
  }

  public void setSearchKeyword(String searchKeyword) {
    this.searchKeyword = searchKeyword;
  }

}
