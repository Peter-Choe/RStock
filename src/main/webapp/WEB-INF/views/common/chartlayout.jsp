<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="margin: 10px;">
		<!-- <select>
			<option>종목코드</option>
			<option>종목코드</option>
		</select> -->
		종목별 주요 차트
	</div>
	<div id="container">
		<div id="content">
			<tiles:insertAttribute name="chart1" />
		</div>
		
		<div id="content2">
			<tiles:insertAttribute name="chart2" />
		</div>
		
	</div>
</body>
</html>