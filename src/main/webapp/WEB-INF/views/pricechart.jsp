<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.highcharts.com/stock/highstock.js"></script>
<script src="https://code.highcharts.com/stock/modules/data.js"></script>
<script src="https://code.highcharts.com/stock/modules/exporting.js"></script>
<script src="https://code.highcharts.com/stock/modules/accessibility.js"></script>
<script type="text/javascript">
	var priceData = JSON.parse('${priceJA}');

	
	window.onload = 
	/* Highcharts.getJSON('https://demo-live-data.highcharts.com/aapl-ohlc.json',
			function(data) {  */
			function() {
				// create the chart
				Highcharts.stockChart('chart', {
					rangeSelector : {
						selected : 1
					},

					title : {
						text : '일별 주가'
					},

					series : [ {
						type : 'candlestick',
						name : '',
						data : priceData,
						dataGrouping : {
							units : [ [ 'week', // unit name
							[ 1 ] // allowed multiples
							], [ 'month', [ 1, 2, 3, 4, 6 ] ] ]
						}
					} ]
				});
			 };
	
</script>
<body>
	<div style="border: 1px solid red; margin: 10px;">
		<div id="chart"></div>
	</div>
	



</body>
</html>