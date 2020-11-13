<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
	table{
		heigh: 200px;
		width: 180px:
		border: 1px solid black;
	}
	div#container	{
	width:850px;
	height: 1000px;
	margin:auto;
	padding:10px;
	background-color:powderblue;	
	border:thin solid black;
	font-color: blue;
	}	
</style>
<title>Customer List</title>
</head>
<body>
<div id="container">
<p style="background-color:tomato" align="center"> Online Book Library list of customer books out on rent </p>
<form method = "post" action = "listNavigationServlet">
<table>
<c:forEach items="${requestScope.allLists}" var="currentlist">
<tr>
   <td><input type="radio" name="id" value="${currentlist.id}"></td>
   <td><h2>${currentlist.listName}</h2></td></tr>
   <tr><td colspan="3">Rent Date: ${currentlist.rentDate}</td></tr>
   <tr><td colspan="3">Customer: ${currentlist.customer.customerName}</td></tr>
   <c:forEach var = "listVal" items = "${currentlist.listOfBooks}">
            <tr><td></td><td colspan="3">
                ${listVal.ISBN}, ${listVal.bookAuthor}, ${listVal.bookTitle}, ${listVal.price}
                </td>
            </tr>
  </c:forEach>
</c:forEach>
</table>
<p></p>
<input type = "submit" value = "edit" name="doThisToList">
<input type = "submit" value = "delete" name="doThisToList">
<input type="submit" value = "add" name = "doThisToList">
</form>
<p>
<a href="index.html">GO TO HOME PAGE</a>
</p>
</div>
</body>
</html>