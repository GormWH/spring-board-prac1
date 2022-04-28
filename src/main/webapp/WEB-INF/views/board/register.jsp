<%--
  Created by IntelliJ IDEA.
  User: suhong
  Date: 2022/04/28
  Time: 12:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Register</title>
</head>
<body>
<h1>Register</h1>
<form action="/board/register" method="post">
  <input type="text" name="title">
  <input type="text" name="content">
  <input type="text" name="writer">
  <button>Register</button>
</form>
</body>
</html>
