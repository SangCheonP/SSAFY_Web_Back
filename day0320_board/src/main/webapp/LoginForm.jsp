<%@page import="model.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
</head>
<body>
	<%
	MemberDTO loginInfo = (MemberDTO) request.getSession().getAttribute("loginInfo");
	if(loginInfo == null){
		%>
		<form action="/day0320_board/board" method="post">
			<input type="hidden" name="action" value="login">
			<input type="text" name="userId"><br>
			<input type="password" name="userPw"><br>
			<input type="submit" value="로그인">
		</form>
		<%
	} else{
		%>
		<b><%=loginInfo.getUserName() %></b>(<%=loginInfo.getUserId() %>)님 반갑습니다.
		<a href="/day0320_board/board?action=logout">로그아웃</a>
		<%
	}
	%>
</body>
</html>