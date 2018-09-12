<%--
  Created by IntelliJ IDEA.
  User: wyc
  Date: 2018/9/10
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login/login" method="post">
    <input type="text" name="username">登录名<br/>
    <input type="password" name="password">用户名<br/>
    <button type="submit">登录</button>
</form>
</body>
</html>
