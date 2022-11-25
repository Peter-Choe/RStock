<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script> 
<script src="https://code.highcharts.com/highcharts.js"></script>

<script type="text/javascript">
var socket = null;
var alarmCount=0;
var cpudata=0;
$(document).ready(function(){
	
   sock = new SockJS("/chart");
   socket = sock;
   
  setTimeout(() => {sock.send("s");}, 300);

  Highcharts.chart('cpuchart', {
	    chart: {
	        type: 'spline',
	        animation: Highcharts.svg, // don't animate in old IE
	        marginRight: 10,
	        events: {
	            load: function () {
	                   // set up the updating of the chart each second
	                   var series = this.series[0];
	                   sock.onmessage = function(evt){
	                        cpudata = evt.data;
	                       
	                    }  
	                   
	                   setInterval(function () {
	                	   sock.send("sss");
	                       var x = (new Date()).getTime(), // current time
	                           y = parseFloat(cpudata);;
	                         console.log("y : "+y);
	                         
	                       series.addPoint([x, y], true, true);
	                   }, 1000);
	               }
	           }
	    },

	    time: {
	        useUTC: false
	    },

	    title: {
	        text: 'cpuchart'
	    },

	    accessibility: {
	        announceNewData: {
	            enabled: true,
	            minAnnounceInterval: 10000,
	            announcementFormatter: function (allSeries, newSeries, newPoint) {
	                if (newPoint) {
	                    return 'New point added. Value: ' + newPoint.y;
	                }
	                return false;
	            }
	        }
	    },

	    xAxis: {
	        type: 'datetime',
	        tickPixelInterval: 60
	    },

	    yAxis: {
	        title: {
	            text: ''
	        },
	        max : 100,
	        plotLines: [{
	            value: 0,
	            width: 1,
	            color: '#808080'
	        }]
	    },

	    tooltip: {
	        headerFormat: '<b>{series.name}</b><br/>',
	        pointFormat: '{point.x:%Y-%m-%d %H:%M:%S}<br/>{point.y:.2f}'
	    },

	    legend: {
	        enabled: false
	    },

	    exporting: {
	        enabled: false
	    },

	    series: [{
	        name: 'cpu사용량',
	        data: (function () {
	            // generate an array of random data
	            var data = [],
	                time = (new Date()).getTime(),
	                cpudata;
	            
	

	            for (i = -19; i <= 0;  i += 1) {
	                data.push({
	                    x: time-1,
	                    y: cpudata
	                });
	            }
	            return data;
	        }())
	    }]
	});



});





</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="cpuchart" ></div>
</body>
</html>