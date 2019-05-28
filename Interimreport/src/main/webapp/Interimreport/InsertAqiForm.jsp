<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改資料</title>
<style>
form {
	margin: 0 auto;
	width: 600px;
}
</style>
</head>

<body onload="javascript:document.insertMemberFormA.mId.focus();">
	<form name="insertMemberFormA" action="aqi.do" method="POST">
		<table border="1">
			<thead>
				<tr bgcolor='tan'>
					<th height="60" colspan="2" align="center">修改資料</th>
				</tr>
			</thead>
			<tbody>
				<tr bgcolor='tan'>
					<td width="120" height="40">監測地點:</td>
					<td width="600" height="40" align="left"><input id='num'
						style="text-align: left" name="SiteName" type="text" size="14">
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">監測縣市:</td>
					<td width="600" height="40" align="left"><input id='num'
						style="text-align: left" name="country" type="text" size="14">
					</td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">空氣品質指標:(AQI)</td>
					<td width="600" height="40" align="left"><input name="AQI"
						type="text" size="20"></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">空氣品質狀態:</td>
					<td width="600" height="40" align="left"><input
						name="Status" type="text" size="14"></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">二氧化硫濃度:(SO2)</td>
					<td width="600" height="40" align="left"><input name="SO2"
						type="text" size="20"></td>
				</tr>
<!-- 				<tr bgcolor='tan'> -->
<!-- 					<td width="120" height="40">生日:</td> -->
<!-- 					<td width="600" height="40" align="left"><input -->
<!-- 						name="mBirthday" type="text" size="14"><font color='blue' -->
<!-- 						size="-1">&nbsp;&nbsp;格式為yyyy-MM-dd</font></td> -->
<!-- 				</tr> -->
				<tr bgcolor='tan'>
					<td width="120" height="40">二氧化硫平均濃度:(SO2_AVG)</td>
					<td width="600" height="40" align="left"><input name="SO2_AVG"
						type="text" size="14"></td>
				</tr>
				<tr bgcolor='tan'>
					<td height="50" colspan="2" align="center">
					<input type="submit" value="新增" name="action">
					<input type="submit" value="刪除" name="action">
					<input type="submit" value="修改" name="action">
					<input type="submit" value="查詢" name="action">
					</td>	
				</tr>

			</tbody>
		</table>
	</form>

</body>
</html>