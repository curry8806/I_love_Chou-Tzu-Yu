<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料修改</title>
</head>
<body>
<h1>資料成功</h1>
監測地點: ${ aqiBean.sitename}<br>
監測縣市: ${ aqiBean.country}<br>
空氣品質指標: ${ aqiBean.aqi}<br>
空氣品質狀態: ${ aqiBean.status}<br>
二氧化硫濃度: ${ aqiBean.so2}<br>
二氧化硫平均濃度: ${ aqiBean.so2_avg}<br>
<br>
       <a href="InsertAqiForm.jsp">回前頁</a>
</body>
</html>