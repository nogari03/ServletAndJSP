<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <button name="join" onclick="location.href='./join.jsp'">회원가입하기</button>
        <button name="login" onclick="location.href='./login.jsp'">로그인하기</button>

        <c:set var="map" value="<%= new java.util.HashMap()%>" scope="application" />
        <c:set target="${map}" property="id" value="${param.id}" />
        <c:set target="${map}" property="name" value="${param.name}" />
        <c:set target="${map}" property="password" value="${param.password}" />
        <c:set target="${map}" property="re_password" value="${param.re_password}" />
    </div>
        <!-- test -->
        <c:out value="${map.id}" />
        <c:out value="${map.name}" />
        <c:out value="${map.password}" />
        <c:out value="${map.re_password}" />
        <!-- test end -->
</body>
</html>
