<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editing List</title>
<style>
	div#container	{
	width:850px;
	height: 390px;
	margin:auto;
	padding:10px;
	background-color:powderblue;	
	border:thin solid black;
	font-color: blue;
	}	
	h4 {text-align: center;}
</style>
</head>
<body>
<div id="container">
<form action = "editListDetailsServlet" method="post">
<input type ="hidden" name = "id" value= "${listToEdit.id}">
<p style="background-color:tomato" align="center"> Welcome to edit book list Form </p>
List Name: <input type ="text" name = "listName" value=
"${listToEdit.listName}"><br />
<p></p>
	Rent date: <input type ="text" name = "month" placeholder="mm" size="4" value= "${month}"> 
				<input type ="text" name = "day" placeholder="dd" size="4" value= "${date}">, 
				<input type ="text" name = "year" placeholder="yyyy" size="4" value= "${year}">
	Customer Name: <input type = "text" name = "customerName" value="${listToEdit.customer.customerName}"><br />
	Available Items:<br />
<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allBooks}" var="currentitem">
 <option value = "${currentitem.id}">${currentitem.ISBN} | ${currentitem.bookAuthor} | ${currentitem.bookTitle} | ${currentitem.price}</option>
</c:forEach>
</select>
<br />
<p></p>
<input type = "submit" value="SAVE THE LIST">
</form>
<p></p>
<a href = "index.html">Go add new book instead.</a>
</div>
</body>
</html>