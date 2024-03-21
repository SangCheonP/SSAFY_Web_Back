<%@page import="model.dao.BookDao"%>
<%@page import="model.dto.BookDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	<!-- 메인화면을 구현하세요 -->
	<h1>도서관리 JDBC 연동 </h1>
	
	<%
	
	BookDao dao = new BookDao();
	BookDto dto = dao.selectOne(1);
	
	%>
	<%= dto.getIsbn()%>
	<%= dto.getTitle()%>
	<%= dto.getWriter()%>
	<%= dto.getPrice()%>
</body>
</html>
