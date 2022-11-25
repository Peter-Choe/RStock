<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>



계좌종합
<table border="1"  style="margin: 10px;">
	<tr>
		<th></th>
		<c:forEach var="accNumList" items="${ accNumList }">
			<th>${ accNumList }</th>
		</c:forEach>
		<th>총수량</th>
		<th>현재가</th>
	</tr>
	<c:forEach var="itemList" items="${ itemList }">
		<tr>
			<th>${ itemList.itemCd }</th>
			<c:forEach var="accNumList" items="${ accNumList }">
				<td>
					<c:forEach var="accountList" items="${ accountList }">
						<c:choose>
							<c:when test="${ itemList.itemCd eq accountList.itemCd and accountList.accNum eq accNumList }">
								${accountList.amount }
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
					</c:forEach>
				</td>
			</c:forEach>
			<td>${ itemList.sumAmount }</td>
			<td>${ itemList.currPrice }</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>