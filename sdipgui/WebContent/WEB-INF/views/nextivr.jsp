<%-- 
    Document   : nextivr
    Created on : Mar 23, 2018, 12:32:38 PM
    Author     : JITENDER
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="../../resources/js/jquery-3.3.1.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="//fonts.googleapis.com/css?family=Open+Sans" />
<link rel="stylesheet" href="../resources/css/main.css" type="text/css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>IVR is loading</title>
<style>
p {
	margin: 0 28px 0px 0px;
	display: inline-block;
}

#customers1 {
	font-family: inherit;
	border-collapse: collapse;
	width: 70%;
	position: relative;
	margin-left: 62px;
	margin-top: 400px;
	text-align: justify;
}

#customers1 td, #customers1 th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers1 tr:hover {
	background-color: #ddd;
}

#customers1 th {
	padding-top: 12px;
	padding-bottom: 12px;
	background-color: #c8c7cc;
	color: white;
}
</style>
</head>
<body>
	<table class="customers1" id="customers1">
		<tr>
			<th>Order</th>
			<th>Type</th>
			<th>Id</th>
			<th>Credit</th>
			<th>Counter</th>
			<th>Description</th>
		</tr>
		<c:forEach var="list4" items="${list4}">
			<tr>

				<td></td>
				<td></td>
				<td class="myDiv"><c:out value="${list4.fieldid}" /></td>
				<td><c:out value="${list4.shortdesc}" /></td>
				<td></td>
				<td></td>

			</tr>
		</c:forEach>
		<c:forEach var="list5" items="${list5}">
			<tr>

				<td></td>
				<td></td>

				<td><c:out value="${list5.fieldid}" /></td>
				<td></td>
				<td></td>
				<td><c:out value="${list5.shortdesc}" /></td>


			</tr>
		</c:forEach>

	</table>


</body>
</html>




