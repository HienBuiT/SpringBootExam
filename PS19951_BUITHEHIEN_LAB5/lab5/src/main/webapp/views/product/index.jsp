<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
</head>

<body>
	<h3>SORT PRODUCT BY ${field }</h3>
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
				<c:forEach var="item" items="${products}" varStatus="loop">
					<tr>
						<th scope="row">${item.id }</th>
						<td>${item.name }</td>
						<td>${item.price }</td>
						<td>${item.createDate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>