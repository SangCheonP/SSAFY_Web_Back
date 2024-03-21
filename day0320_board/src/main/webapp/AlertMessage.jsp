<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alert Msg</title>
</head>
<body>
	<script type="text/javascript">
		alert('<%=request.getAttribute("alertMsg")%>');
		location.href = "<%=request.getAttribute("redirectPath") %>";
	</script>
</body>
</html>