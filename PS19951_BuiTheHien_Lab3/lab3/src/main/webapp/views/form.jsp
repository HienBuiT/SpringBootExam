<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Form</title>
<!-- Bootstrap CSS v5.2.1 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<form:form action="save" modelAttribute="student"
			enctype="multipart/form-data">
		Name:
		<form:input path="name" />
			<br>
			<form:errors path="name" class="text-danger" />
			<br>
		Email:
		<form:input path="email" />
			<br>
			<form:errors path="email" class="text-danger" />
			<br>
		Mark:
		<form:input path="marks" />
			<br>
			<form:errors path="marks" class="text-danger" />
			<br>
		Gender: 
		<form:radiobuttons items="${genders}" path="gender" />
			<br>
			<form:errors path="gender" class="text-danger" />
			<br>
		Faculty: 
		<form:select items="${faculties}" path="faculty" />
			<br>
			<form:errors path="faculty" class="text-danger" />
			<br>
		Hobbies: 
		<form:checkboxes items="${hobbies}" path="hobbies" />
			<br>
			<form:errors path="hobbies" class="text-danger" />
			<br>
		Image: 
		<input type="file" name="imageFile" accept="image/*" />
			<br>
			<button>Save</button>
		</form:form>
		<br>
		<h2>Student</h2>
		<br> Name: ${student.name} <br> Email: ${student.email} <br>
		Mark: ${student.marks} <br> Faculty: ${student.faculty} <br>
		Gender: ${student.gender} <br> Hobbies: ${student.hobbies} <br>
		Image: ${student.imageUrl} <img alt="" src="${student.imageUrl}" width="100">
	</div>


	<!-- Bootstrap JavaScript Libraries -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous">
		
	</script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
		integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
		crossorigin="anonymous">
		
	</script>
</body>
</html>