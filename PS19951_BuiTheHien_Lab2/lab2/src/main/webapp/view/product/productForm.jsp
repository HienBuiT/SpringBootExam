<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/product/save" method="post">
		<input name="name"/>
		<input name="price"/>
		<button>Save</button>
	</form>
	<ul>
		<li>${product.name}</li>
		<li>${product.price}</li>
	</ul>
</body>
</html>