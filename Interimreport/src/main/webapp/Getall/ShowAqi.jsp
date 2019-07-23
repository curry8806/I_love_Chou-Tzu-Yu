<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="aqiService" class="tw.nickchen.javaproject.getall.AqiService" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="subTitle" value="查詢各地AQI資料"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${subTitle}</title>
</head>
<body>
  <c:choose>
      <c:when test="${empty aqiService.allAqis}">
         目前尚未有任何會員資料<br>
      </c:when>
      <c:otherwise>
         資料如下:<br>
           <table border='1'>
             <tr>
               <th width='120'>監測地點</th>
               <th width='120'>監測縣市</th>
               <th width='140'>空氣品質指標(AQI)</th>
               <th width='360'>空氣品質狀態</th>
               <th width='130'>二氧化硫濃度(SO2)</th>
               <th width='150'>二氧化硫平均濃度(SO2_AVG)</th>
              </tr>
              <c:forEach var="aBean" items="${aqiService.allAqis}">
                <tr>
                  <td>${aBean.sitename}</td>
                  <td>${aBean.country}</td>
                  <td>${aBean.aqi}</td>
                  <td>${aBean.status}</td>
                  <td>${aBean.so2}</td>
                  <td>${aBean.so2_avg}</td>
                </tr>
              </c:forEach> 
           </table>
           
      </c:otherwise>
  </c:choose>
       <br>
       <a href="GetAllAqiForm.jsp">回首頁</a>

</body>
</html>