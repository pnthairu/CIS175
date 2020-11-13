<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Paul Thairu Online Book Store</title>
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
	<form action = "editBookServlet" method = "post">
	<p style="background-color:tomato" align="center"> Welcome to book editing page </p>
	ISBN: <input type = "text" name = "ISBN" value = "${bookToEdit.ISBN}">
	Author: <input type = "text" name = "bookAuthor" value = "${bookToEdit.bookAuthor}">
	Title: <input type = "text" name = "bookTitle" value = "${bookToEdit.bookTitle}">
	Price: <input type = "text" name = "price" value = "${bookToEdit.price}">
	<input type = "hidden" name = "id" value ="${bookToEdit.id}">
	<p></p>
	<input type = "submit" value= "Save Edited Book">
 	</form>
</div>
</body>
</html>