<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form name="loginForm" method="post" action="./result.jsp" >
        ID: <input type="text" name="id"><br>
        암호: <input type="password" name="password"><br>
        <input type="submit" value="로그인">
    </form>
</body>
</html>
