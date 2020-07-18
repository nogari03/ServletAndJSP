<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.io.*" %>

<html>
<head>
    <title>Application 기본 객체 사용하여 자원 읽기</title>
</head>
<body>

<%
    String resourcePath = "/servlet/notice.txt";
%>
자원의 실제 경로 : 자원의 실제 경로 : 실제 물리적 위치를 확인할 수 있다. <br>
<%= application.getRealPath(resourcePath)%>
<br>
----------<br>
<%= resourcePath %>의 내용<br>
<%
    char[] buff = new char[128];
    int len = -1;

    try(InputStreamReader br = new InputStreamReader(
            application.getResourceAsStream(resourcePath), "UTF-8")){
        while ((len = br.read(buff)) != -1 ){
            out.print(new String(buff, 0, len));
        }
    }catch (IOException ex){
        out.print("익셉션 발생 : "+ ex.getMessage());
    }
%>
</body>
</html>
