<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cart</title>
</head>
<body>
	<table border="1" style="width:100%;">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Amount</th>
			<th></th>
		</tr>
		<c:forEach var="prod" items="${cart}">
			<form action="/cart/update/${prod.value.id}" method="post">
				<input type="hidden" name="id" value="${prod.value.id}">
				<tr>
					<td>${prod.value.id}</td>
					<td>${prod.value.name}</td>
					<td><fmt:formatNumber type="number" value="${prod.value.price}" /> VND</td>
					<td>
						<input name="quantity" value="${prod.value.quantity}" onblur="this.form.submit()" style="width:50px;">
					</td>
					<td>
						<fmt:formatNumber type="number" value="${prod.value.price * prod.value.quantity}" /> VND
					</td>
					<td><a href="/cart/remove/${prod.value.id}">Remove</a></td>
				</tr>
			</form>
		</c:forEach>
	</table>
	<a href="/cart/clear">Clear Cart</a>
	<a href="/product">Add More</a>
</body>
</html>