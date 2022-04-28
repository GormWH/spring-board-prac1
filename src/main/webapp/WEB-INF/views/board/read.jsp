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

<script>
  const returnBtn = document.querySelector("button.returnBtn");
  const modifyBtn = document.querySelector("button.modifyBtn");

  returnBtn.addEventListener("click", () => {
    self.location = `/board/list${listDTO.link}`;
  }, false);

  modifyBtn.addEventListener("click", () => {
    self.location = `/board/modify/${boardDTO.bno}${listDTO.link}`;
  }, false);
</script>
</body>
</html>
