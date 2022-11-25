<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>

<script src="https://code.highcharts.com/stock/highstock.js"></script>
<script src="https://code.highcharts.com/stock/modules/data.js"></script>
<script src="https://code.highcharts.com/stock/modules/exporting.js"></script>
<script src="https://code.highcharts.com/stock/modules/accessibility.js"></script>
<script src="https://code.highcharts.com/stock/modules/hollowcandlestick.js"></script>
  
<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
		url:'/stock/data',
		type:'get',
		success:function(res){
		    Highcharts.stockChart('stockchart', {
		    	 xAxis: {
		             type: 'datetime',
		             tickInterval: 'month'
		    		 },
		        rangeSelector: {
		        	 
		              selected: 1,
		              inputEnabled: false
		   
		        },

		        title: {
		            text: 'stock chart'
		        },

		        series: [{
                    type: 'hollowcandlestick',
                    name: 'Stock Price',
                    data: res,
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
<div id="stockchart"></div>
</body>
</html>