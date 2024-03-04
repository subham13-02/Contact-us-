<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="io.mountblue.contactus.model.Request" %>
<%@ page import="java.util.List" %>
<%@ page import="io.mountblue.contactus.dao.RequestDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<style>
	.container{
		text-align:center;
		display:flex;
		flex-direction:column;
		align-items:center;
		justify-content:center;
	}
	th, td {
	  padding:0.5rem 1rem;
	}
	th{
		background-color: #ff6e33;
	    color: white;
	}
	.btn{
	 	margin-top:2rem;
	    background-color: #ff6e33;
	    color: white;
	    padding: 10px 20px;
	    border: none;
	    border-radius: 5px;
	    cursor: pointer;
	    margin-bottom:1.5rem;
	}
</style>
</head>
<body>
	<%
		response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
		if(session.getAttribute("username")==null){
			response.sendRedirect("login");
		}
	%>  
	 <div class="container">
	 	<h1>Dashboard Page</h1>
	    <h2>Active Data</h2>
	    <table border="1" style="border-collapse: collapse;">
	        <thead>
	            <tr>
	                <th>Name</th>
	                <th>Email</th>
	                <th>Message</th>
	                <th>Status</th>
	            </tr>
	        </thead>
	         <tbody>
			     <c:forEach items="${activeRequest}" var="data">
			     	<tr>
				    	<td><c:out value="${data.getName()}"></c:out></td>
				        <td><c:out value="${data.getEmail()}"></c:out> </td>
				        <td> <c:out value="${data.getMessage()}"></c:out></td>
				        <td>
				        	<form action="dashboard" method="post">
				              <input type="hidden" name="id" value="${data.getId()}">
				              <input type="hidden" name="status" value="true">
				              <input type="submit" value="Change to ${data.getStatus() ? 'Archived' : 'Active'}">
				        	</form>
				    	</td>
			     	</tr>
			     </c:forEach>
	     	</tbody>
	     </table>
	    <h2>Archived Data</h2>
	    <table border="1" style="border-collapse: collapse;">
	        <thead>
	            <tr>
	                <th>Name</th>
	                <th>Email</th>
	                <th>Message</th>
	                <th>Status</th>
	            </tr>
	        </thead>
	         <tbody>
			     <c:forEach items="${archiveRequest}" var="data">
			     	<tr>
				    	<td><c:out value="${data.getName()}"></c:out></td>
				        <td><c:out value="${data.getEmail()}"></c:out> </td>
				        <td> <c:out value="${data.getMessage()}"></c:out></td>
				        <td>
				        	<form action="dashboard" method="post">
				              <input type="hidden" name="id" value="${data.getId()}">
				              <input type="hidden" name="status" value="false">
				              <input type="submit" value="Change to ${data.getStatus() ? 'Active' : 'Archived'}">
				        	</form>
				    	</td>
			     	</tr>
			     </c:forEach>
	     	</tbody>
	     </table>
	     <form action="logout" method="post" >
				<input type="submit" value="Logout" class="btn">
		</form>
	</div>  
</body>
</html>