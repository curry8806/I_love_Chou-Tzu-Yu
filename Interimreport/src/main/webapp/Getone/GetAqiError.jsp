<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查詢</title>
</head>
<body>
	<h1>資料查詢失敗</h1>
	<!-- 如果識別字串 ErrorMsg 所對應的屬性物件不是空的 -->
	<c:if test="${not empty ErrorMsg}">
		<font color='red'> 請修改下列錯誤:
			<ul>
				<!-- 將識別字串 ErrorMsg 所對應的屬性物件之內的物件『依序取出』， 放入變數 aMsg中 -->
				<c:forEach var="aMsg" items="${ErrorMsg}">
					<!-- 將變數 aMsg 的內含值顯示出來 -->
					<li>${aMsg}</li>
				</c:forEach>
			</ul>
		</font>
	</c:if>
	<br>
       <a href="GetAqiForm.jsp">回前頁</a>
</body>
</html>