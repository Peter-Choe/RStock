<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>DB Table</title>
</head>
<body>
	<table border="1px solid">
		<tr>
	       	  <th></th>
	      <c:forEach var="userId" items="${id_list}">
	          <th>${userId }</th>
	      </c:forEach>
		      <th>총수량</th>
		      <th>현재가</th>
		      <th> </th>
	      </tr>
      <c:forEach var="totalAccount" items="${tacp_list }">
      <tr>
         <td> ${totalAccount.stockCode }</td>
         <c:forEach var="userId" items="${id_list }">
            <td>
            <c:forEach var="account" items="${list }">
            <c:choose>
              <c:when test="${account.stockCode eq totalAccount.stockCode and account.userId eq userId}">
                     ${account.notPaidAmount }
               </c:when>
               <c:otherwise>  </c:otherwise>
            </c:choose>
            </c:forEach>
            </td>
         </c:forEach>
         <td>${totalAccount.total_amount }</td>
         <td>${totalAccount.curPrice }</td>
         <td>${totalAccount.renewTime }</td>
      </tr>
      </c:forEach>
   
      </table>

</body>
</html>
