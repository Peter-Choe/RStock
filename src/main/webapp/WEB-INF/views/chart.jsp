<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
	<script>

google.load('visualization','1',{
    'packages' : ['corechart']
});

    google.setOnLoadCallback(drawChart); //라이브러리를 불러오는 작업이 완료되었으면 drawChart작업을 실행
    function drawChart() {
        var jsonData = $.ajax({ //비동기 방식으로 호출
            url : "${path}/gchart/amountList",
            dataType : "json",
            async : false
        }).responseText; //JSON 파일을 text파일로 읽어들인다
        console.log(jsonData);
        
        var data
        = new google.visualization.DataTable(jsonData);
       
        
        var chart
         = new google.visualization.LineChart(
                document.getElementById('chart_div')); //선 그래프 
           
                chart.draw(data, {
                    title : "종목별 총 수량",
                    curveType : "function", //curveType는 차트의 모양이 곡선으로 바뀐다
                    width : 1000,
                    height : 600
                });
    }
 
</script>
</head>
<body>
	<div id="chart_div"></div>
    
    
</body>
</html>
