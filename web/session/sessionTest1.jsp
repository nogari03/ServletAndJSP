<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% request.setCharacterEncoding("euc-kr"); %>
<%
    String id = request.getParameter("id");
    String passwd = request.getParameter("passwd");
    session.setAttribute("id",id);
    session.setMaxInactiveInterval(60*2); // 2분
%>
<h2>Session내장객체 예제</h2>
<form method="post" action="sessionTest2.jsp">
    가장 좋아하는 스포츠를 선택하세요 <br>
    <input type="radio" name="sports" value="태권도">태권도
    <input type="radio" name="sports" value="유도">유도
    <input type="radio" name="sports" value="프로레슬링">프로레슬링
    <input type="radio" name="sports" value="이종격투기">이종격투기<p>

    가장 좋아하는 게임을 선택하세요<br>
    <select name="game">
        <option value="스타크">스타크</option>
        <option value="wow">WOW</option>
        <option value="리니지">리니지</option>
    </select>
    <input type="submit" value="전송">
</form>
</body>
</html>
