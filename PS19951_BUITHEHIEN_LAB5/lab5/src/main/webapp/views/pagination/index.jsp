<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Page</title>
</head>

<body>
	<h3>PAGINATION</h3>
	
	<div>
		<table>
			<thead>
				<tr>
					<th scope="col"><a href="/product/sort?field=id">ID</a></th>
					<th scope="col"><a href="/product/sort?field=name">NAME</a></th>
					<th scope="col"><a href="/product/sort?field=price">PRICE</a></th>
					<th scope="col"><a href="/product/sort?field=createDate">DATE</a></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${page.content }" varStatus="loop">
					<tr>
						<th scope="row">${item.id }</th>
						<td>${item.name }</td>
						<td>${item.price }</td>
						<td>${item.createDate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
				<a href="/product/page?page=0">First</a>
				<a href="/product/page?page=${page.number -1 }">Previous</a>
				<a href="/product/page?page=${page.number +1 }">Next</a>
				<a href="/product/page?page=${page.totalPages -1 }">Last</a>
		<ul>
			<li>Số thực thể hiện tại: ${page.numberOfElements }</li>
			<li>Trang số: ${page.number }</li>
			<li>Kích thước trang: ${page.size }</li>
			<li>Tổng số thực thể: ${page.totalElements }</li>
			<li>Tổng số trang: ${page.totalPages }</li>
		</ul>
	</div>
</body>
</html>