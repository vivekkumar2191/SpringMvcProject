<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="../resources/css/main.css" type="text/css"></link>

<title>Edit Text is loading</title>



</head>
<body>
	<%@include file="header.jsp"%>

	<div class="title1">
		<label class="admin_label7"> Add Text</label>
	</div>

	<form:form method="POST" action="/NeuroneEditor3/savetext">
		<label class="txt_lbl1">Text ID:</label>
		<form:input path="fieldid" type="text" class="txt_txt1" />

		<label class="txt_lbl2">Language:</label>
		<form:select path="languageid" class="txt_txt2">
			<option value="1">English</option>
			<option value="0">Spanish</option>
		</form:select>
		<label class="txt_lbl3">Description:</label>
		<form:input path="shortdesc" type="text" class="txt_txt3" />
		<label class="txt_lbl4">Text:</label>
		<form:input path="longdesctext" type="text" class="txt_txt4" />
		<input type="submit" value="Save" class="txt_new" />

	</form:form>

</body>
</html>
