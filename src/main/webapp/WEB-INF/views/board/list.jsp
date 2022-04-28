<%--
  Created by IntelliJ IDEA.
  User: suhong
  Date: 2022/04/27
  Time: 6:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h1>list</h1>
<button class="registerBtn">게시물 등록하기</button>

${paginator}
<table>
  <thead>
  <tr>
    <th>글 번호</th>
    <th>제목</th>
    <th>작성자</th>
    <th>작성일</th>
  </tr>
  </thead>
  <tbody class="boardTable">
  <c:forEach items="${boardList}" var="board">
    <tr class="board" data-bno="${board.bno}">
      <td>${board.bno}</td>
      <td>${board.title}</td>
      <td>${board.writer}</td>
      <td>${board.regDate}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<ul class="pagination">
  <c:if test="${paginator.prev}">
    <li><a href="${paginator.start - 1}">prev</a></li>
  </c:if>
  <c:forEach begin="${paginator.start}" end="${paginator.end}" var="num">
    <li>
      <a href="${num}">${num}</a>
    </li>
  </c:forEach>
  <c:if test="${paginator.next}">
    <li><a href="${paginator.end + 1}">next</a></li>
  </c:if>
</ul>

<form class="actionForm" method="get">
  <input type="hidden" name="page" value="${listDTO.page}">
  <input type="hidden" name="size" value="${listDTO.size}">
  <input type="hidden" name="searchType" value="${listDTO.searchType}">
  <input type="hidden" name="searchKeyword" value="${listDTO.searchKeyword}">
</form>

<script>
  // 게시물 등록 버튼
  document.querySelector(".registerBtn").addEventListener("click", e => {
    self.location = `/board/register${listDTO.link}`
  }, false);

  const actionForm = document.querySelector(".actionForm");
  const boardTable = document.querySelector(".boardTable");
  const pagination = document.querySelector(".pagination");

  // 게시물 조회 링크
  boardTable.addEventListener("click", e => {
    e.stopPropagation();
    e.preventDefault();
    const target = e.target.closest(".board");
    const bno = target.getAttribute("data-bno");
    console.log(bno);
    actionForm.setAttribute("action", `/board/read/\${bno}`);
    actionForm.submit();
  }, false);

  // 페이징 링크
  pagination.addEventListener("click", e => {
    e.preventDefault();
    e.stopPropagation();
    const href = e.target.closest("a").getAttribute("href");
    actionForm.querySelector("input[name='page']").value = href;
    actionForm.setAttribute("action", `/board/list`);
    actionForm.submit();
  }, false);


</script>
</body>
</html>
