<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.btnAccount {
	
}

.btnTimeChart {
	
}

.btnStockChart {
	
}
</style>
</head>
<body>
	<div class="Header">
		header
		<div class="btnAccount">
			<input type="button" value="종목별 계좌 거래내역" class="account" onclick="location='/'">
		</div>
		<div class="btnTimeChart">
			<input type="button" value="실시간 CPU사용량조회" class="cpu" onclick="location='timeChart'">
		</div>
		<div class="btnStockChart">
			<input type="button" value="주가차트" class="stockChart" onclick="location='stockChart'">
		</div>
	</div>
</body>
</html>