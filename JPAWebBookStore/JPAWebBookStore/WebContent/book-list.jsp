<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
	div#container	{
	width:850px;
	margin:auto;
	padding:10px;
	background-color:powderblue;	
	border:thin solid black;
</style>
</head>
<body>
<div id="container">
	<form method="post" action ="navigationServlet">
	<table><h4 style="background-color:tomato" align="center"> Welcome to Paul Thairu online Book Store</h4>
	<p> Please make sure you check the book you want to EDIT or DELETE</p>
	<c:forEach items="${requestScope.allBooks}" var="currentbook">
		<tr>
			<td><input type="radio" name="id" value="${currentbook.id}"></td>
			<td>${currentbook.ISBN}</td>
			<td>${currentbook.bookAuthor}</td>
			<td>${currentbook.bookTitle}</td>
			<td>${currentbook.price}</td>
		</tr>
	</c:forEach>	
	</table>
	<p></p>
	<p></p>
	<input type = "submit" value = "edit" name="doThisToBook">
	<input type = "submit" value = "delete" name="doThisToBook">
	<input type = "submit" value = "add" name="doThisToBook">
	</form>
	<p> Click the below link to go to home page again</p>
	<p>
		<a href = ""/index.html"> Go to home page</a>
	</p>
</div>
</body>
</html>