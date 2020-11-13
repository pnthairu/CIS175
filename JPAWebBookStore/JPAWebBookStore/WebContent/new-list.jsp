<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Customer List</title>
<style>
div#container	{
	width:850px;
	height: 350px;
	margin:auto;
	padding:10px;
	background-color:powderblue;	
	border:thin solid black;
	font-color: blue;
	}
</style>
</head>
<body>
<div id="container">
<form action = "createNewListServlet" method="post">
<p style="background-color:tomato" align="center"> Welcome to Paul Thairu Online book Library add new CUSTOMER LIST OF BOOK(S) </p>
List Name: <input type ="text" name = "listName"><br />
<p></p>
Rent date: <input type ="text" name = "month" placeholder="mm" size="4"> <input type ="text" name = "day" placeholder="dd" size="4">, <input type ="text" name = "year" placeholder="yyyy" size="4">

Customer Name: <input type = "text" name = "customerName"><br />

<p style="background-color:tomato" align="center">Available Book: </p><br />

<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allBooks}" var="currentitem">
   <option value = "${currentitem.id}">${currentitem.ISBN} | ${currentitem.bookAuthor}| ${currentitem.bookTitle}| ${currentitem.price}</option>
</c:forEach>
</select>
<br />
<p></p>
<input type = "submit" value="Create List and Add Items">
</form>
<p><a href = "index.html">Go add new items instead.</a></p>
</div>
</body>
</html>