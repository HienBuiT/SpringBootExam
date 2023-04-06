<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Product</title>
</head>
<body>
	<ul>
		<c:forEach var="prod" items="${product}">
			<li>
				<p>${prod.name} [ <a href="/cart/add/${prod.id}"><button>Add to Cart</button></a> ]</p>
				<p>Quantity: ${prod.quantity}</p>
				<p>Price: <fmt:formatNumber type="number" value="${prod.price}" /> VND </p>
				
			</li>
		</c:forEach>
	</ul>
	<div>
		<a href="/cart/view"><button>Go to cart</button></a>
	</div>
	${message}
</body>
</html>