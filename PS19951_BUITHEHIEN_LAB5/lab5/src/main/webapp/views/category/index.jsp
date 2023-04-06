<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category</title>
</head>
<body>
	<h3>Category Manager</h3>
	<table border=1>
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">NAME</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${categories }" varStatus="loop">
				<tr>
					<th scope="row">${item.id }</th>
					<td>${item.name }</td>
					<td><a href="/category/edit/${item.id }" role="button"
						style="color: orange;">Edit</a> <a
						href="/category/delete/${item.id }" role="button"
						style="color: red;">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h4>EDIT CATEGORY</h4>
	<form:form action="/category/index" modelAttribute="category"
		method="post">
		<div>
			<form:label path="id">Category Id:</form:label>
			<form:input path="id" class="form-control" />
		</div>
		<div>
			<form:label path="name">Category Name:</form:label>
			<form:input path="name" />
		</div>
		<button formaction="/category/create" formmethod="post">CREATE</button>
		<button formaction="/category/update" formmethod="post">UPDATE</button>
		<a href="/category/index"><i class="fas fa-times-circle mr-2"></i>RESET</a>
	</form:form>
</body>
</html>