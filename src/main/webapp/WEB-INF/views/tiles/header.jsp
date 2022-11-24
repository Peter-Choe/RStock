<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<div class="Header" align="center">Header
<br><br><br>

<a href="${pageContext.request.contextPath}/tableList">DB 테이블</a> &nbsp;
<a href="${pageContext.request.contextPath}/hchart/aachart">하이차트</a>&nbsp;
<a href="${pageContext.request.contextPath}/hchart/rtchart">하이차트(실시간)</a>&nbsp;
<a href="${pageContext.request.contextPath}/gchart/dbchart">구글차트(DB연동)</a>&nbsp;
</div>

</body>
</html>
