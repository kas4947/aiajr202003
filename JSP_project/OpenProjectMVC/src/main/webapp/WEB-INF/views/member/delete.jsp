<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<h1>삭제페이지입니다.</h1>
	<hr>

	<c:if test="${resultCnt != 0}">
		<h3>삭제가 완료되었습니다.</h3>
	</c:if>

	<c:if test="${resultCnt == 0}">
	<h3>삭제에 실패하였습니다.</h3>
	</c:if>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>

</body>
</html>