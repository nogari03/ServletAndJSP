<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="updateForm" method="post" action="/user01">

    고객번호 <input type="text" name="id" value="${requestScope.UserVO.cust_id}"><br>
    고객이름 <input type="text" name="name" value="${requestScope.UserVO.cust_name}" ><br>
    고객주소 <input type="text" name="address" value="${requestScope.UserVO.cust_address}"><br>
    고객주 <input type="text" name="state" value="${requestScope.UserVO.cust_state}"><br>
    고객우편번호 <input type="text" name="zip" value="${requestScope.UserVO.cust_zip}"><br>
    고객국가 <input type="text" name="country" value="${requestScope.UserVO.cust_country}"><br>
    고객담당자 <input type="text" name="contact" value="${requestScope.UserVO.cust_contact}"><br>
    고객메일주소 <input type="text" name="email" value="${requestScope.UserVO.cust_email}"><br>

    <c:if test="${empty requestScope}" >
        <input type="submit" value="고객추가">
        <input type="hidden" name="command" value="add">
    </c:if>
    <c:if test="${not empty requestScope}" >
        <input type="submit" value="수정">
        <input type="hidden" name="command" value="update">
    </c:if>

</form>
</body>
</html>