<%@ page import="main.sec01.Test01.UserVO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>title</title>
    <style>
        table, th, tr{
            border: solid 1px black;
        }
    </style>
</head>
<body>
<form id="basicForm" method="post" action="/user01">
    고객번호 <input type="text" name="id" >
    <input type="submit" value="조회">
    <input type="hidden" name="command" value="search">
    <input type="button" value="고객추가" onclick="location.href='./user01edit.jsp'">
</form>
<hr>
<table>
    <tr>
        <th>고객번호</th>
        <th>고객이름</th>
        <th>고객주소</th>
        <th>고객주</th>
        <th>고객우편번호</th>
        <th>고객국가</th>
        <th>고객담당자</th>
        <th>고객메일주소</th>
        <th>수정</th>
    </tr>
    <form name="rowForm" method="post" action="/user01">
    <c:forEach items="${list}" var="UserVO" >
            <tr>
                <th>${UserVO.cust_id}</th>
                <th>${UserVO.cust_name}</th>
                <th>${UserVO.cust_address}</th>
                <th>${UserVO.cust_state}</th>
                <th>${UserVO.cust_zip}</th>
                <th>${UserVO.cust_country}</th>
                <th>${UserVO.cust_contact}</th>
                <th>${UserVO.cust_email}</th>

                <!--여기 jstl 써서 수정할것 -->
                <input type="hidden" name="id" value="${UserVO.cust_id}" />
                <input type="hidden" name="name" value="${UserVO.cust_name}" />
                <input type="hidden" name="address" value="${UserVO.cust_address}" />
                <input type="hidden" name="state" value="${UserVO.cust_state}" />
                <input type="hidden" name="zip" value="${UserVO.cust_zip}" />
                <input type="hidden" name="country" value="${UserVO.cust_country}" />
                <input type="hidden" name="contact" value="${UserVO.cust_contact}" />
                <input type="hidden" name="email" value="${UserVO.cust_email}" />

                <th>
                    <input type="submit" value="수정">
                    <input type="hidden" name="command" value="edit">
                </th>
            </tr>
    </c:forEach>
    </form>
</table>
</body>
</html>