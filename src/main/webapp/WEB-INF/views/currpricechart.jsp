<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- <script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script> -->
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<!-- <script src="https://code.highcharts.com/modules/accessibility.js"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<body>
<div style="border: 1px solid blue; margin: 10px;">
<!-- <figure class="highcharts-figure" style="height: 90%">
    <div id="chart2"></div>
</figure> -->

<div id="chart2"></div>

<script type="text/javascript">
var currPrice = null;

function getCurrPrice() {
	$.ajax({
		type: 'GET',
		url: 'data',
		async:false,
		dataType: 'text',
		success: function(data) {
			
			currPrice = data;
		}
	})
	
	
	return Number(currPrice);
}



	Highcharts
			.chart(
					'chart2',
					{
						chart : {
							type : 'line',
							animation : Highcharts.svg, // don't animate in old IE
							marginRight : 10,
							events : {
								load : function() {

									// set up the updating of the chart each second
									var series = this.series[0];
									setInterval(function() {
										var x = (new Date()).getTime(), // current time
										y = getCurrPrice()
										series.addPoint([ x, y ], true, true);
									}, 1500);
								}
							}
						},

						time : {
							useUTC : false
						}, 

						title : {
							text : '실시간 현재가 차트'
						},

						accessibility : {
							announceNewData : {
								enabled : true,
								minAnnounceInterval : 15000,
								announcementFormatter : function(allSeries,
										newSeries, newPoint) {
									if (newPoint) {
										return 'New point added. Value: '
												+ newPoint.y;
									}
									return false;
								}
							}
						},

						xAxis : {
							type : 'datetime',
							tickPixelInterval : 150
						},
						
						
						yAxis : {
							title : {
								text : 'Value'
							},
							plotLines : [ {
								value : 0,
								width : 1,
								color : '#808080'
							} ]
						},

						tooltip : {
							headerFormat : '<b>{series.name}</b><br/>',
							pointFormat : '{point.x:%Y-%m-%d %H:%M:%S}<br/>{point.y:.2f}'
						},

						legend : {
							enabled : false
						},

						exporting : {
							enabled : false
						},

						series : [ {
							name : '',
							data : (function() {
								// generate an array of random data
								var data = [], time = (new Date()).getTime(), i;

								for (i = -19; i <= 0; i += 1) {
									data.push({
										x : time + i * 1000,
										y : null
									});
								}
								
								return data;
							}())
						} ],
						plotOptions: {
					        series: {
					            dataLabels: {
					                enabled: true
					            }
					        }
					    },

						
					});
	
	
</script>
</div>
</body>
</html>