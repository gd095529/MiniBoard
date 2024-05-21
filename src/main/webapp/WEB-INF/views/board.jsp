<%@ page import="com.myportfolio.web.domain.Comments" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page session="true"%>
<c:set var="loginId" value="${sessionScope.nick}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : loginId+'님'}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판</title>
    <link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: "Noto Sans KR", sans-serif;
        }

        .container {
            width : 50%;
            margin : auto;
        }

        .writing-header {
            position: relative;
            margin: 20px 0 0 0;
            padding-bottom: 10px;
            border-bottom: 1px solid #323232;
        }

        input {
            width: 100%;
            height: 35px;
            margin: 5px 0px 10px 0px;
            border: 1px solid #e9e8e8;
            padding: 8px;
            background: #f8f8f8;
            outline-color: #e6e6e6;
        }

        textarea {
            width: 100%;
            background: #f8f8f8;
            margin: 5px 0px 10px 0px;
            border: 1px solid #e9e8e8;
            resize: none;
            padding: 8px;
            outline-color: #e6e6e6;
        }

        .frm {
            width:100%;
        }
        .btn {
            background-color: rgb(236, 236, 236); /* Blue background */
            border: none; /* Remove borders */
            color: black; /* White text */
            padding: 6px 12px; /* Some padding */
            font-size: 16px; /* Set a font size */
            cursor: pointer; /* Mouse pointer on hover */
            border-radius: 5px;
        }

        .btn:hover {
            text-decoration: underline;
        }


        .comment-container {
            margin: 20px;
        }
        .comments, .reply {
            margin-bottom: 10px;
            padding: 5px;
            border: 1px solid #ccc;
        }
        .reply {
            margin-left: 20px;
        }
        .comment-info {
            margin-bottom: 5px;
        }
        .comment-content {
            margin-bottom: 5px;
        }
        .comments-actions button {
            margin-right: 5px;
        }

        .comments-container1 {
            width:100%;
            margin: 20px;
            padding: 10px;
            border: 1px solid #ddd;

        }

        th,td{
            padding: 5px; /* 모든 방향에 10px의 패딩 추가 */
        }

    </style>
</head>
<body>
<div id="menu">
    <ul>
        <li id="logo">소통하는곳</li>
        <li><a href="<c:url value='/'/>">Home</a></li>
        <li><a href="<c:url value='/board/list'/>">Board</a></li>
        <li><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
        <li><a href="<c:url value='/register/add'/>">Sign in</a></li>
        <li><a href=""><i class="fa fa-search"></i></a></li>
    </ul>
</div>
<script>
    let msg = "${msg}";
    if(msg=="WRT_ERR") alert("게시물 등록에 실패하였습니다. 다시 시도해 주세요.");
    if(msg=="MOD_ERR") alert("게시물 수정에 실패하였습니다. 다시 시도해 주세요.");
</script>
<div class="container">
    <h2 class="writing-header">게시판 ${mode=="new" ? "글쓰기" : "읽기"}</h2>
    <form id="form" class="frm" action="" method="post">
        <input type="hidden" name="bid" value="${boardsDto.id}">

        <input name="title" type="text" value="<c:out value='${boardsDto.title}'/>" placeholder="  제목을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}><br>
        <textarea name="content" rows="20" placeholder=" 내용을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}><c:out value="${boardsDto.content}"/></textarea><br>

        <c:if test="${mode eq 'new'}">
            <button type="button" id="writeBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 등록</button>
        </c:if>
        <c:if test="${mode ne 'new'}">
            <button type="button" id="writeNewBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 글쓰기</button>
        </c:if>
        <c:if test="${boardsDto.user_id eq loginId}">
            <button type="button" id="modifyBtn" class="btn btn-modify"><i class="fa fa-edit"></i> 수정</button>
            <button type="button" id="removeBtn" class="btn btn-remove"><i class="fa fa-trash"></i> 삭제</button>
        </c:if>
        <button type="button" id="listBtn" class="btn btn-list"><i class="fa fa-bars"></i> 목록</button>
    </form>
</div><br>

<c:if test="${mode ne 'new'}">
<div class="comments-container1">
    <h2>댓글 ${boardsDto.comment_cnt}</h2>

    <div id="commentList"></div>
    <div id="replyForm" style="display: none">
        <input type="text" name="replyComment">
        <button id="wrtRepBtn" type="button" style="display: none">등록</button>
        <button id="modComBtn" type="button" style="display: none">수정</button>
    </div>

    <table>
        <tr>
            <th rowspan="2" class="writer">${sessionScope.uid}</th>
            <td rowspan="5" class="content"><input type="text" name="comment" placeholder="댓글을 입력해주세요"></td>
            <td><input id="sendBtn" type="button" value="댓글등록"></td>
        </tr>
    </table>
</div>
</c:if>

<script>
    $(document).ready(function(){
        let formCheck = function() {
            let form = document.getElementById("form");
            if(form.title.value=="") {
                alert("제목을 입력해 주세요.");
                form.title.focus();
                return false;
            }

            if(form.content.value=="") {
                alert("내용을 입력해 주세요.");
                form.content.focus();
                return false;
            }
            return true;
        }

        $("#writeNewBtn").on("click", function(){
            location.href="<c:url value='/board/write'/>";
        });

        $("#writeBtn").on("click", function(){
            let form = $("#form");
            form.attr("action", "<c:url value='/board/write'/>");
            form.attr("method", "post");

            if(formCheck())
                form.submit();
        });

        $("#modifyBtn").on("click", function(){
            let form = $("#form");
            let isReadonly = $("input[name=title]").attr('readonly');

            // 1. 읽기 상태이면, 수정 상태로 변경
            if(isReadonly=='readonly') {
                $(".writing-header").html("게시판 수정");
                $("input[name=title]").attr('readonly', false);
                $("textarea").attr('readonly', false);
                $("#modifyBtn").html("<i class='fa fa-pencil'></i> 등록");
                return;
            }

            // 2. 수정 상태이면, 수정된 내용을 서버로 전송
            form.attr("action", "<c:url value='/board/modify${searchCondition.queryString}'/>");
            form.attr("method", "post");
            if(formCheck())
                form.submit();
        });

        $("#removeBtn").on("click", function(){
            if(!confirm("정말로 삭제하시겠습니까?")) return;

            let form = $("#form");
            form.attr("action", "<c:url value='/board/remove${searchCondition.queryString}'/>");
            form.attr("method", "post");
            form.submit();
        });

        $("#listBtn").on("click", function(){
            location.href="<c:url value='/board/list${searchCondition.queryString}'/>";
        });
    });
</script>

<c:if test="${mode ne 'new'}">
<script>
        // 현재 URL을 가져옵니다.
        const currentUrl = window.location.href;

        // URLSearchParams 객체를 생성합니다.
        const urlParams = new URLSearchParams(window.location.search);

        // 'bid' 파라미터의 값을 가져옵니다.
        const postValue = urlParams.get('bid');

        let bid = postValue;

        let showList = function (bid){
            $.ajax({
                type:'GET',       // 요청 메서드
                url: '/my/comments?bid='+bid,  // 요청 URI
                success : function(result){
                    $("#commentList").html(toHtml(result)); // 서버로 부터 응답이 도착하면 호출될 함수
                },
                error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
            }); // $.ajax()
        }


        $(document).ready(function(){
            showList(bid);

            $("#modComBtn").click(function(){
                if(!`${loginId}`){
                    alert("로그인이 필요합니다");
                    return;
                }

                let comment = $("input[name=replyComment]").val();
                let cid = $('#replyForm').parent().attr("data-cid");

                if(comment.trim()==''){
                    alert("댓글 입력해주세요");
                    $("input[name=replyComment]").focus()
                    return;
                }

                $.ajax({
                    type:'PATCH',       // 요청 메서드
                    url: '/my/comments/'+cid,  // 요청 URI // /my/comments/70 POST
                    headers : { "content-type": "application/json"}, // 요청 헤더
                    data : JSON.stringify({cid:cid, comment:comment}),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
                    success : function(result){
                        alert(result);
                        showList(bid);
                        $("input[name=replyComment]").val('');
                    },
                    error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
                }); // $.ajax()

                $("#replyForm").css("display","none");
                $("input[name=replyComment]").val('');
                $("#replyForm").appendTo("body");
            });


            $("#wrtRepBtn").click(function(){
                if(!`${loginId}`){
                    alert("로그인이 필요합니다");
                    return;
                }

                let comment = $("input[name=replyComment]").val();
                let pcid =$("#replyForm").parent().attr("data-pcid");

                if(comment.trim()==''){
                    alert("댓글 입력해주세요");
                    $("input[name=replyComment]").focus()
                    return;
                }

                $.ajax({
                    type:'POST',       // 요청 메서드
                    url: '/my/comments?bid='+bid,  // 요청 URI // /my/comments?bid=644 POST
                    headers : { "content-type": "application/json"}, // 요청 헤더
                    data : JSON.stringify({pcid:pcid, bid:bid, comment:comment}),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
                    success : function(result){
                        alert(result);
                        showList(bid);
                    },
                    error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
                }); // $.ajax()

                $("#replyForm").css("display","none");
                $("input[name=replyComment]").val('');
                $("#replyForm").appendTo("body");
            });

            $("#sendBtn").click(function(){
                if(!`${loginId}`){
                    alert("로그인이 필요합니다");
                    return;
                }

                let comment = $("input[name=comment]").val();

                if(comment.trim()==''){
                    alert("댓글 입력해주세요");
                    $("input[name=comment]").focus()
                    return;
                }

                $.ajax({
                    type:'POST',       // 요청 메서드
                    url: '/my/comments?bid='+bid,  // 요청 URI // /my/comments?bno=644 POST
                    headers : { "content-type": "application/json"}, // 요청 헤더
                    data : JSON.stringify({bid:bid, comment:comment}),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
                    success : function(result){
                        alert(result);
                        showList(bid);
                        $("input[name=comment]").val("")
                    },
                    error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
                }); // $.ajax()

                $("#replyForm").css("display","none");
                $("input[name=replyComment]").val('');
                $("#replyForm").appendTo("body");
            });

            //답글 펼칠때
            $("#commentList").on("click", ".replyBtn",function() {
                // 1. replyForm을 옮김
                $("#replyForm").appendTo($(this).parent());

                // 2. 답글을 입력할 폼을 보여주고,
                $("#replyForm").css("display", "block");
                $("#wrtRepBtn").css("display", "block");
                $("#modComBtn").css("display", "none");
                $("input[name=replyComment]").val("");
                $("input[name=replyComment]").focus()
            });

            //수정 펼칠때
            $("#commentList").on("click", ".modBtn",function() {
                // 1. replyForm을 옮김
                $("#replyForm").appendTo($(this).parent());

                // 2. 답글을 입력할 폼을 보여주고,
                $("#replyForm").css("display", "block");
                $("#modComBtn").css("display", "block");
                $("#wrtRepBtn").css("display", "none");
                let comment = $("span.comment", $(this).parent()).text();
                $("input[name=replyComment]").val(comment);
                $("input[name=replyComment]").focus()
            });

            // $(".delBtn").click(function(){
            $("#commentList").on("click", ".delBtn",function(){
                let cid = $(this).parent().attr("data-cid");
                let bid = $(this).parent().attr("data-bid");

                $.ajax({
                    type:'DELETE',       // 요청 메서드
                    url: '/my/comments/'+cid+'?bid='+bid,  // 요청 URI
                    success : function(result){
                        alert(result);
                        showList(bid);
                    },
                    error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
                }); // $.ajax()
            });
        });

        let toHtml = function (commets){
            let tmp = "<div class='comment-container'>";

            commets.forEach(function (comment){
                var dateString = comment.up_date;
                var date = new Date(dateString);
                // var formattedDate = date.toLocaleDateString('ko-KR');
                var formattedDateTime = date.toLocaleString('ko-KR', {
                    year: 'numeric', month: 'numeric', day: 'numeric',
                    hour: '2-digit', minute: '2-digit', second: '2-digit'
                });


                tmp += '<div class="comments" data-cid='+ comment.cid
                tmp += ' data-pcid='+ comment.pcid
                tmp += ' data-bid='+ comment.bid +'>'
                if(comment.cid!=comment.pcid)
                    tmp+= 'ㄴ'
                tmp += ' <span class="commenter">'+ comment.commenter + '</span>'
                tmp += ' || '+formattedDateTime
                if(`${loginId}` == comment.commenter) {
                    tmp += '<button class ="delBtn"> 삭제</button>'
                    tmp += '<button class ="modBtn"> 수정</button>'
                }
                tmp += '<button class ="replyBtn"> 답글</button>'
                tmp += '<br><span class ="comment">'+ comment.comment + '</span>'

                tmp += '</div>'
            })

            return tmp + "</div>";
        }

</script>
</c:if>

</body>
</html>