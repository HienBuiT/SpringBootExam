<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>seach - page</h3>
<form action="/product/search-page" method="get">
	<input name="keywords" value="${keywords}" placeholder="Keywords?">
	<button>Search</button></form>
<table border="1" style="width: 100%">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Price</th>
		<th>Date</th>
	</tr>
<c:forEach var="item" items="${page.content}">
	<tr>
		<td>${item.id}</td>
		<td>${item.name}</td>
		<td>${item.price}</td>
		<td>${item.createDate}</td>
	</tr>
</c:forEach></table>
<a href="/product/search-page?p=0">First</a>
<a href="/product/search-page?p= ${page.number-1}">Previous</a>
<a href="/product/search-page?p= ${page.number+1}">Next</a>
<a href="/product/search-page?p= ${page.totalPages-1}">Last</a>
<ul>
	<li>Số thực thể hiện tại: ${page.numberOfElements}</li>
	<li>Trang số: ${page.number}</li>
	<li>Kích thước trang: ${page.size}</li>
	<li>Tổng số thực thể: ${page.totalElements}</li>
	<li>Tổng số trang: ${page.totalPages}</li>
</ul>
	
</body>
</html>