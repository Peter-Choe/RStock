<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://code.highcharts.com/stock/highstock.js"></script>
<script src="https://code.highcharts.com/stock/modules/data.js"></script>
<script src="https://code.highcharts.com/stock/modules/exporting.js"></script>
<script src="https://code.highcharts.com/stock/modules/hollowcandlestick.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

$(document).ready(function(){
	
	$.ajax({
			url: '/getChartData',
			type:'get',
			dataType:'json',
			success:function(data){
				 // create the chart
			    Highcharts.stockChart('container', {
			        rangeSelector: {
			            selected: 1
			        },

			        title: {
			            text: 'AAPL Stock Price'
			        },

			        series: [{
			            type: 'hollowcandlestick',
			            name: 'AAPL Stock Price',
			            data: data,
			            dataGrouping: {
			                units: [
			                    [
			                        'week', // unit name
			                        [1] // allowed multiples
			                    ], [
			                        'month',
			                        [1, 2, 3, 4, 6]
			                    ]
			                ]
			            }
			        }]
			    });
			}
	    })
	
})
       

</script>
</head>
<body>
<div id="container"></div>
</body>
</html>