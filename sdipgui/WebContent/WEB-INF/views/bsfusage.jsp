<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="./resources/js/jquery-3.3.1.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="//fonts.googleapis.com/css?family=Open+Sans" />
<link rel="stylesheet" href="./resources/css/main.css" type="text/css" />
<link rel="stylesheet" href="./resources/css/bootstrap.css" type="text/css"/>
<!--[if IE]>
	<link rel="stylesheet" type="text/css" href="../resources/css/other.css" />
<![endif]-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>SDIP</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.css">
</head>
<body>
	<div class="bgopacity" id="bgopacity"></div>

	<div class="header_container">
		<span class=logo><a id="manral" href="./">Secure Digital
				Identity System </a></span>

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
		<label class="admin_label7"><span id="tag">Secure
				Digital Identity Platform</span></label>

	</div>

	<div class="dummy"></div>



	<div class="homeclass">
		<span id="hm">BSF Usage Configuration</span>
	</div>


	<%@ include file="sidebar.jsp"%>

	<div class="ct">
		<div class="seconddiv">
			<span class="namename">BSF Usage Configuration</span> 
		</div>



		<form method="get" action="samplefilter">

			<input class="sr" type="text" placeholder="SEARCH" id="search"
				required />

		</form>


		<div id="main1">
			<div id="div1">
				<button id="close">X</button>

				<button id="yes">YES</button>
				<button id="no">NO</button>
				<label id="erlabel1">Are you sure you want Delete?</label>

			</div>
		</div>
		<!-- <table id="customers">-->
		<div class="col-sm-12" id="tbl1">
		<table class="table table-striped table-bordered" style=" width: 50%; margin: auto;">
		
			<thead>
							<c:forEach var="Bsfusage" items="${list}">
			
				<tr>
				
					<!--<th align="center" width="35%">High Usage Warning</th>
						<td align="center">${Bsfusage.high_usage_warning}</td>
     <td><select id="sh" class="sh" onchange="window.location.href=this.value;">
								<option  style="display: none" disabled selected>Select</option>
								<option id="a" value="./editusagewarning/${Bsfusage.high_usage_warning}">Modify</option>


						</select></td>-->

					<th align="left" style="width: 278px;">High Usage Warning</th>
						<td align="center" style="width:225px;">${Bsfusage.high_usage_warning}</td>
     <td style="width: 135px;"><select id="sh" class="form-control" onchange="window.location.href=this.value;">
								<option  style="display: none" disabled selected>Select</option>
								<option id="a" value="./editusagewarning/${Bsfusage.high_usage_warning}">Modify</option>


						</select></td>



				</tr>
       <tr>
					<!--<th width="30%">Level</th>
						<td align="center"> ${Bsfusage.level}</td>
                          <td><select id="sh" class="sh" onchange="window.location.href=this.value;">
								<option value="0" style="display: none" disabled selected>Select</option>
								<option id="a" value="./editlevel/${Bsfusage.level}">Modify</option>



						</select></td>-->
						<th>Level</th>
						<td align="center"> ${Bsfusage.level}</td>
      <td><select id="sh" class="form-control" onchange="window.location.href=this.value;">
								<option value="0" style="display: none" disabled selected>Select</option>
								<option id="a" value="./editlevel/${Bsfusage.level}">Modify</option>



						</select></td>
   </tr>


         </c:forEach>
			</thead>
		</table>
		</div>
	</div>
	<script src="./resources/js/jquery.paginate.js" type="text/javascript"></script>
	<script src="./resources/js/pagenation.js" type="text/javascript"></script>


</body>
</html>
