<%--
  Created by IntelliJ IDEA.
  User: suhong
  Date: 2022/04/28
  Time: 5:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Modify</title>
</head>
<body>
<h1>Modify</h1>
${boardDTO}
<form action="/board/modify/${boardDTO.bno}" method="post">
  <input name="bno" value="${boardDTO.bno}" readonly>
  <input name="title" value="${boardDTO.title}">
  <input name="content" value="${boardDTO.content}">
  <input type="hidden" name="page" value="${listDTO.page}">
  <input type="hidden" name="size" value="${listDTO.size}">
  <input type="hidden" name="searchType" value="${listDTO.searchType}">
  <input type="hidden" name="searchKeyword" value="${listDTO.searchKeyword}">
  <button>Modify</button>
</form>

<button>Remove</button>
</body>
</html>
