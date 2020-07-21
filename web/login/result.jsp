<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:set var="id" value="${param.id}" scope="session" />
    <c:set var="name" value="${map.name}" scope="session" />
    <div>
        안녕하세요 ${name}님
        <button name="logout"
                onclick="<c:remove var="id" scope="session" />
                <c:remove var="name" scope="session" />
                location.href='./main.jsp'">로그아웃하기
        </button>
        <button name="changePwd" onclick="location.href='./changePwd.jsp'">암호변경하기</button>
    </div>
</body>
</html>
