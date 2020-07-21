<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:set var="file1" value="${param.param1}" />
    <c:set var="file2" value="${param.param2}" />

    파라미터 1: <c:out value="${file1}" /><br>
    파라미터 2: <c:out value="${file2}" /><br>

    <c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

    <c:if test="${not empty file1}">
        <img src="${contextPath}/download.do?fileName=${file1}" width="300" height="300"/><br>
    </c:if>
    <br>
    <c:if test="${not empty file2}">
        <img src="${contextPath}/download.do?fileName=${file2}" width="300" height="300"/><br>
    </c:if>
    파일 내려받기 :<br>
    <a href="/download.do?fileName=${file2}">파일내려받기</a>
</body>
</html>
