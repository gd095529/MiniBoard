<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registerInfo</title>
</head>
<body>

    <h2>가입 완료</h2>
    id : ${user.uid}<br>
    pwd : ${user.pwd}<br>
    name : ${user.name}<br>
    email : ${user.email}<br>

    <a href="<c:url value='/'/>">Home</a><br>
    <a href="<c:url value='/login/login'/>">로그인 하기</a>
</body>
</html>
