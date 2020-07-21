<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form name="changePwdForm" method="post" action="./main.jsp">
        현재암호 : <input type="password" name="currentPassword" value="${map.password}" readonly>
        새암호 : <input type="password" name="password">
        <input type="submit" value="암호변경">
    </form>
</body>
</html>
