<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="false"%>

<c:set var="loginId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('uid')}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : 'ID='+=loginId}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>소통하는곳</title>
    <link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
    <style>
        .container {
            display: flex;
            justify-content: space-between;
        }
        a {
            white-space:nowrap;
        }
        .column {
            width: 32%;
            background-color: #f0f0f0;
            padding: 10px;
            box-sizing: border-box;
        }
        .info {
            display: grid;
            grid-template-columns: 240px 1fr 1fr 90px; /* 4개의 컬럼으로 나눔 */ /*1fr은 다 더해서 그 값 분의 1 이란뜻*/
            gap: 10px; /* 컬럼 사이의 간격 */

        }
        .post {
            margin-bottom: 10px;
            padding: 10px;
            background-color: white;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis; /* "..."으로 표현 */
            display: block;
        }
        .post:last-child {
            margin-bottom: 0;
        }
        .info, h2{
            padding-bottom: 10px;
        }
    </style>
</head>
<body>
<div id="menu">
    <ul>
        <li id="logo"><a href="<c:url value='/'/>">소통하는곳</a></li>
        <li><a href="<c:url value='/'/>">Home</a></li>
        <li><a href="<c:url value='/board/list'/>">Board</a></li>
        <li><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
        <li><a href="<c:url value='/register/add'/>">Sign in</a></li>
        <li><a href="<c:url value='/board/list'/>"><i class="fa fa-search"></i></a></li>
    </ul>
</div>

<div class="container">
    <div class="column">
        <h2>최근 게시물</h2>

        <div class="info"><div>제목</div><div>댓글 수</div><div>조회 수</div><div>작성일자</div></div>

        <c:forEach var="boardDto" items="${list_d}">
            <div class="info">
                <div class="post"><a href="<c:url value="/board/read?bid=${boardDto.bid}"/>">${boardDto.title}</a></div>
                <div>${boardDto.comment_cnt}</div>
                <div>${boardDto.view_cnt}</div>
                <div><fmt:formatDate value="${boardDto.create_date}" pattern="yyyy-MM-dd" type="date"/></div>
            </div>
        </c:forEach>
    </div>
    <div class="column">
        <h2>조회수 많은 게시물</h2>

        <div class="info"><div>제목</div><div>댓글 수</div><div>조회 수</div><div>작성일자</div></div>

        <c:forEach var="boardDto" items="${list_vt}">
            <div class="info">
                <div class="post"><a href="<c:url value="/board/read?bid=${boardDto.bid}"/>">${boardDto.title}</a></div>
                <div>${boardDto.comment_cnt}</div>
                <div>${boardDto.view_cnt}</div>
                <div><fmt:formatDate value="${boardDto.create_date}" pattern="yyyy-MM-dd" type="date"/></div>
            </div>
        </c:forEach>
    </div>
    <div class="column">
        <h2>댓글 많은 게시물</h2>

        <div class="info"><div>제목</div><div>댓글 수</div><div>조회 수</div><div>작성일자</div></div>

        <c:forEach var="boardDto" items="${list_ct}">
            <div class="info">
                <div class="post"><a href="<c:url value="/board/read?bid=${boardDto.bid}"/>">${boardDto.title}</a></div>
                <div>${boardDto.comment_cnt}</div>
                <div>${boardDto.view_cnt}</div>
                <div><fmt:formatDate value="${boardDto.create_date}" pattern="yyyy-MM-dd" type="date"/></div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>