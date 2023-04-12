<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<base href="/"/>

<body>
	<form action="/product2/save" method="post">
		<input name="name" value="${productEdit.name}"/>
		<input name="price" value="${productEdit.price}" />
		<button>save</button>
	</form>
	${message}
	<ul>
		<li>${product1.name}</li>
		<li>${product1.price}</li>
	</ul>
	<ul>
		<li>${product2.name}</li>
		<li>${product2.price}</li>
	</ul>
	<table>
		<tr>
			<td>Name</td>
			<td>Price</td>
			<td></td>
		</tr>
		<c:forEach var="item" items="${item}">
			<tr>
				<td>${item.name}</td>
				<td>${item.price}</td>
				<td>
					<a href="product2/edit/${item.name}">edit</a>
					<a>view</a>
					<a>delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>