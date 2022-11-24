<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var onMessageData = 0;
var socket = null;
var alarmCount = 0;
$(document).ready(function(){
   console.log("document ready ..");
   
   sock = new SockJS("/chart");
   socket = sock;
   setTimeout(() => { sock.send("send"); }, 300);
   //setInterval("autoScript()", 5000); // 5초마다 데이터 가져오기

   Highcharts.chart('container', {
      
       chart: {
           type: 'spline',
           animation: Highcharts.svg, // don't animate in old IE
           marginRight: 10,
           events: {
               load: function () {
                   // set up the updating of the chart each second
                   var series = this.series[0];
                   sock.onmessage = function(evt){
	                    var CPUdata = evt.data;
	                    onMessageData = CPUdata;
	                    console.log("recieve Data : "+ onMessageData + "\n");
               	  }   
                   setInterval(function () {
                      autoScript();
                      
                       var x = (new Date()).getTime(), // current time
                           y = parseFloat(onMessageData);;
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
           text: 'CPU data'
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
           tickPixelInterval: 150
       },

       yAxis: {
           title: {
               text: 'Value'
           },
           max:100,
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
           name: 'CPU data',
           data: (function () {
               // generate an array of random data
               console.log("확인2 : "+ onMessageData);
               var data = [],
                   time = (new Date()).getTime(),
                   onMessageData;
			   
               for (i = -18; i <= 0; i += 1) {
                   data.push({
                       x: time,
                       y: onMessageData
                   });
               }
               return data;
           }())
       }]
   });
                 
   
});
	
	function autoScript(){
		console.log("autoScript start");
		socket.send("send");
	}
	
	              
</script>


</head>
<body>
	<div id="container"></div>
</body>
</html>