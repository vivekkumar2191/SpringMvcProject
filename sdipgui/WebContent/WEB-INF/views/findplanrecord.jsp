<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="//fonts.googleapis.com/css?family=Open+Sans" />
<link rel="stylesheet" href="./resources/css/main.css" type="text/css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.css">



</head>
<body>

	<div class="header_container">
		<span class=logo><a id="manral" href="./">Notification
				Editor </a></span>

		<div class="inner_first">

			<div id="adm_button" class="adm_button">
				<span id="admin">User</span> <i class="fa fa-chevron-down"
					id="arrow_down1"></i>
				<div class="inner_second">

					<a href="#" class="con_user1">Change Password </a>
					<form class="con_user" method="post" id="form1" action="">
						<a class="con_user" href="./logout"
							onClick="document.getElementById('form1').submit();" id="logout"
							name="logout">Logout</a>
					</form>
				</div>
			</div>

		</div>
	</div>
	<div class="title1">
		<label class="admin_label7"><span id="tag">Plan</span></label>

	</div>


	<div class="dummy"></div>



	<div class="homeclass">
		<span id="hm">Plan</span>
	</div>
	<div class="sidebar">
		<ul class="demo_ul">
			<li id="has-sub" class="demo_li"><a id="noti1" class="hrefa"
				href="./"><i id="icon_fa" class="fa fa-home"></i><span
					class="selected">Home</span></a></li>
			<li id="has-sub" class="demo_li"><a id="noti" class="hrefa"
				href="./notify"><i id="icon_fa" class="fa fa-bell"></i>Notification</a></li>

			<li id="has-sub" class="demo_li"><a id="sample" class="hrefa"
				href="./sample"><i id="icon_fa" class="fa fa-list"></i>Sample</a></li>

			<li id="has-sub" class="demo_li"><a id="text" class="hrefa"
				href="./text"><i id="icon_fa" class="fa fa-file-text"></i>Text</a></li>


			<li id="has-sub" class="demo_li"><a id="events" class="hrefa"
				href="./events"><i id="icon_fa" class="fa fa-unlink"></i>Events</a></li>
			<li id="has-sub" class="demo_li"><a id="plan" class="hrefa"
				href="./plan"><i id="icon_fa" class="fa fa-th"></i>Plan</a></li>
			<li id="has-sub" class="demo_li"><a id="logout" class="hrefa"
				href="./logout"><i id="icon_fa" class="fa fa-rotate-left"></i>Logout</a></li>


		</ul>


	</div>

	<div class="ct">
		<div class="seconddiv">
			<span class="namename">PLAN</span>
		</div>
		<form:form method="get" action="./getplanrecord">
			<input class="sr" type="text" name="name" id="search"
				placeholder="Search Plan Name..." />



		</form:form>

		<table id="customers">
			<tr>

				<th>Plan Name</th>
				<th>Name Sample</th>
				<th>PreCall Sample</th>
				<th>FirstCall Sample</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${list}" var="list">
				<tr>
					<td>${list.name}</td>
					<td>${list.namesample}</td>
					<td>${list.firstcallsample}</td>
					<td>${list.precallsample}</td>
					<td><select id="sh"
						onchange="window.location.href=this.value;">
							<option style="display: none" disabled selected>Select</option>
							<option value="./editplan/${list.name}">Modify</option>

					</select></td>



				</tr>

			</c:forEach>
		</table>
	</div>

</body>
</html>
