<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: suhong
  Date: 2022/04/28
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
${boardDTO}
<h1>제목: ${boardDTO.title}</h1>
<h4>작성자: ${boardDTO.writer}</h4>
<h4>작성일: ${boardDTO.regDate}</h4>
<h3>${boardDTO.content}</h3>

<button class="returnBtn">목록으로 돌아가기</button>
<button class="modifyBtn">수정 / 삭제</button>

<table>
  <thead>
    <tr>
      <td>#</td>
      <td>내용</td>
      <td>작성자</td>
      <td>작성일</td>
    </tr>
  </thead>
  <tbody class="commentTableBody">

  </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="/resources/js/comment.js"></script>
<script>
  const returnBtn = document.querySelector("button.returnBtn");
  const modifyBtn = document.querySelector("button.modifyBtn");

  returnBtn.addEventListener("click", () => {
    self.location = `/board/list${listDTO.link}`;
  }, false);

  modifyBtn.addEventListener("click", () => {
    self.location = `/board/modify/${boardDTO.bno}${listDTO.link}`;
  }, false);

  const commentTableBody = document.querySelector(".commentTableBody");

  const bno = ${boardDTO.bno};
  console.log("bno = ", bno);
  const page = 1;
  const size = 10;

  const commentList = commentService.getList({bno, page, size}, function(data) {
    let str = "";
    data.forEach( comment => {
      str += `<tr><td>\${comment.cno}</td><td>\${comment.commentText}</td><td>\${comment.commenter}</td><td>\${comment.regDate}</td></tr>`
    })
    console.log(str);
    commentTableBody.innerHTML = str;
  });


</script>
</body>
</html>
