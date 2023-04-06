<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Welcome</title>
</head>
<body>
	<h2>Hello ${sessionScope.username}</h2><br>
	[<a href="/account/logout"><button>Logout</button></a>]
</body>
</html>