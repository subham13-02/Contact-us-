<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
<style>
	th, td {
	  padding: 1rem;
	}
</style>
</head>
<body>
	<%
		response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
		if(session.getAttribute("username")==null){
			response.sendRedirect("login.jsp");
		}
	%>
	<sql:setDataSource var="db" driver="org.postgresql.Driver" url="jdbc:postgresql://localhost:5432/contact-us?characterEncoding=utf8" user="postgres" password="postgres" />
    <sql:query var="active" dataSource="${db}">select * from usersData where status=true</sql:query>
    <sql:query var="archived" dataSource="${db}">select * from usersData where status=false</sql:query>
    
    <h1>Admin Page</h1>
    <h2>Active</h2>
    <table border="1" style="border-collapse: collapse;">
        <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Message</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
         <tbody>
		     <c:forEach items="${active.rows }" var="data">
		     	<tr>
			    	<td><c:out value="${data.name}"></c:out></td>
			        <td><c:out value="${data.email}"></c:out> </td>
			        <td> <c:out value="${data.message}"></c:out></td>
			        <td><c:out value="${data.status ? 'Active' : 'Archived'}"></c:out></td>
			        <td>
			        	<form action="changeStatus" method="post">
			              <input type="hidden" name="id" value="${data.id}">
			              <input type="hidden" name="status" value="${data.status}">
			              <input type="submit" value="${data.status ? 'Archived' : 'Active'}">
			        	</form>
			    	</td>
		     	</tr>
		     </c:forEach>
     	</tbody>
     </table>
    <h2>Archived</h2>
    <table border="1" style="border-collapse: collapse;">
        <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Message</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
         <tbody>
		     <c:forEach items="${archived.rows }" var="data">
		     	<tr>
			    	<td><c:out value="${data.name}"></c:out></td>
			        <td><c:out value="${data.email}"></c:out> </td>
			        <td> <c:out value="${data.message}"></c:out></td>
			        <td><c:out value="${data.status ? 'Active' : 'Archived'}"></c:out></td>
			        <td>
			        	<form action="changeStatus" method="post">
			              <input type="hidden" name="id" value="${data.id}">
			              <input type="hidden" name="status" value="${data.status}">
			              <input type="submit" value="${data.status ? 'Archived' : 'Active'}">
			        	</form>
			    	</td>
		     	</tr>
		     </c:forEach>
     	</tbody>
     </table>
     <form action="logout" method="post">
			<input type="submit" value="Logout">
	</form>
</body>
</html>