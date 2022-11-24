<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script src="http://code.highcharts.com/highcharts.js"></script>
	<script src="http://code.highcharts.com/modules/series-label.js"></script>
	<script src="http://code.highcharts.com/modules/exporting.js"></script>
	<script src="http://code.highcharts.com/modules/export-data.js"></script>
<script>
var chart;
function requestData(){
	$.ajax({
		url : '${path}/hchart/live_resource',
		success : function(point){
			console.log(point)
			
			var series = chart.series[0],
				shift = series.data.length > 20;
				
				 chart.series[0].addPoint(point , true, shift);  
				
				setTimeout(requestData, 1000);
			
		},
		cache : false
	});
}




$(document).ready(function(){
	chart = new Highcharts.Chart({
		chart : {
			renderTo : 'container',
			defaultSeriesType : 'spline',
			events : {
				load: requestData
			}
		},
		title : {
			text : 'Realtime Resource'
		},
		xAxis : {
			type : 'datetime',
			tickPixelInterval : 150,
			maxZoom : 20 * 1000
			
		},
		yAxis : {
			minPadding : 0.2,
			maxPadding : 0.2,
			title : {
				text : 'percent',
				margin : 80
			}
		},
		series : [{
			data:[]
		}]
	});
});

 
</script>
</head>
<body>
		<figure>
			<div id="container"></div>
		</figure>
		

</body>
</html>
