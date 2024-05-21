<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>registerInfo</title>
</head>
<body>
    <h2>회원 수정</h2>
    <form action="/my/register/update" method="post">
        id : ${user.uid}<br>
        pwd : <input type="text" value="${user.pwd}"><br>
        name : <input type="text" value="${user.name}"><br>
        email : <input type="text" value="${user.email}"><br>

        <input type="button" value="수정 정보 저장하기"><br>
    </form>
    <br>
    <br>
    <h4>회원 탈퇴</h4>
    <form action="/my/register/delete" method="post">
        <input type="hidden" value="${user.uid}">
        <input type="button" value="회원탈퇴"><br>
    </form>

</body>
</html>
