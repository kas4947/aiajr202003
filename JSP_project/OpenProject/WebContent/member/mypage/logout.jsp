<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	alert('로그아웃 되었습니다.');
	<%
	 session.invalidate();
	%>
	location.href = '../loginForm.jsp';
</script>
</head>
<body>
	

</body>
</html>