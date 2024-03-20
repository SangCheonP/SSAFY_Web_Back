<%@page import="model.dto.productDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 목록</h1>
	<form action="/day0319_practice/index">
		<input type="hidden" name="action" value="delete">
		<table>
			<tr>
				<th>선택</th>
				<th>제품코드</th>
				<th>모델명</th>
				<th>가격</th>
				<th>제조사</th>
				<th>세부사항</th>
			</tr>
			<%
				List<productDTO> list = (List<productDTO>)request.getAttribute("list");
				
				for(productDTO dto : list){
					%>
					<tr>
							<td><input type="checkbox" name="product" value=<%=dto.getNoteCode() %>></td>
							<td><%=dto.getNoteCode() %></td>
							<td><%=dto.getModel() %></td>
							<td><%=dto.getPrice() %></td>
							<td><%=dto.getCompany() %></td>
							<td><a href="/day0319_practice/index?action=detail&noteCode=<%=dto.getNoteCode() %>">조회</a></td>
					</tr>
					<%
				}
			%>
		</table>
		<button>삭제하기</button>
	</form>
</body>
</html>