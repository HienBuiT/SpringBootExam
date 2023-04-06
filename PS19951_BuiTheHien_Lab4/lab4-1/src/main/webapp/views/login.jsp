<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
</head>
<body>
	<h2>Login</h2>
	<form action="/account/login" method="post">
		<input type="text" name="username" value="${cookie.username.value}" placeholder="Username"/> 
		<br>
		<input type="password" name="password" value="${cookie.password.value}" placeholder="Password"/> 
		<br>
		Remember me ? <input type="checkbox" name="remember" value="true"> 
		<br>
		<button>Login</button>
	</form>
</body>
</html>