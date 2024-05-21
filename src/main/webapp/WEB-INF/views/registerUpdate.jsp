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
        email : ${user.email}<br>
        pwd : <input type="text" value="" placeholder="4자리 이상 12자리 이하"><br>
        name : <input type="text" value="${user.username}"><br>
        nickname 중복체크 만들기 : <input type="text" value="${user.nickname}"><br>

        <input type="button" value="수정 정보 저장하기"><br>
    </form>
    <br>
    <br>
    <h4>회원 탈퇴</h4>
    <form action="/my/register/delete" method="post">
        <input type="hidden" value="${user.id}">
        <input type="button" value="회원탈퇴"><br>
    </form>

</body>
</html>
