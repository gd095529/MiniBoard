<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
    <style>
        * { box-sizing:border-box; }

        form {
            width:400px;
            height:600px;
            display : flex;
            flex-direction: column;
            align-items:center;
            position : absolute;
            top:50%;
            left:50%;
            transform: translate(-50%, -50%) ;
            border: 1px solid rgb(89,117,196);
            border-radius: 10px;
        }

        .input-field {
            width: 300px;
            height: 40px;
            border : 1px solid rgb(89,117,196);
            border-radius:5px;
            padding: 0 10px;
            margin-bottom: 10px;
        }

        label {
            width:300px;
            height:30px;
            margin-top :4px;
        }

        button {
            background-color: rgb(89,117,196);
            color : white;
            width:300px;
            height:50px;
            font-size: 17px;
            border : none;
            border-radius: 5px;
            margin : 20px 0 30px 0;
        }

        .title {
            font-size : 50px;
            margin: 40px 0 30px 0;
        }

        .msg {
            height: 30px;
            text-align:center;
            font-size:16px;
            color:red;
            margin-bottom: 20px;
        }

        .sns-chk {
            margin-top : 5px;
        }
    </style>
    <title>Register</title>
</head>
<body>
<!-- form action="<c:url value="/register/add"/>" method="POST" onsubmit="return formCheck(this)"-->
<form:form modelAttribute="user">
    <div class="title">Register</div>
    <div id="msg" class="msg"><form:errors path="uid"/></div>
    <label for="">아이디</label>
    <input class="input-field" type="text" name="uid" placeholder="4~12자리">
    <label for="">비밀번호</label>
    <input class="input-field" type="text" name="pwd" placeholder="4~12자리">
    <label for="">이름</label>
    <input class="input-field" type="text" name="name" placeholder="홍길동">
    <label for="">이메일</label>
    <input class="input-field" type="text" name="email" placeholder="example@fastcampus.co.kr">

    <button>회원 가입</button>
</form:form>
<%--<script>--%>
<%--    function formCheck(frm) {--%>
<%--        let msg ='';--%>

<%--        if(frm.id.value.length<4) {--%>
<%--            setMessage('id의 길이는 4이상이어야 합니다.', frm.id);--%>
<%--            return false;--%>
<%--        }--%>

<%--        return true;--%>
<%--    }--%>

<%--    function setMessage(msg, element){--%>
<%--        document.getElementById("msg").innerHTML = `<i class="fa fa-exclamation-circle"> ${'${msg}'}</i>`;--%>

<%--        if(element) {--%>
<%--            element.select();--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>
</body>
</html>