<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查詢單筆資料</title>
</head>
<body>
<h1>資料查詢成功</h1>
監測地點: ${Aqi.sitename}<br>
監測縣市: ${Aqi.country}<br>
空氣品質指標: ${Aqi.aqi}<br>
空氣品質狀態: ${Aqi.status}<br>
二氧化硫濃度: ${Aqi.so2}<br>
二氧化硫平均濃度: ${Aqi.so2_avg}<br>
<br>
       <a href="GetAqiForm.jsp">回前頁</a>
</body>
</html>