<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="login.css">
</head>
<body>
	<div class="container">
    	<h1>Login Here</h1>
		<form action="login" method="post">
			<label for="fullname">Full Name</label>
       		<input type="text" name="name" placeholder="Enter ID"><br>
       		
       		<label for="password">Password</label>
      		<input type="password" name="pass" placeholder="Enter Password"><br>
      		
       		<input type="submit" value="Login"><br>
   		</form>
  	</div>
</body>
</html>