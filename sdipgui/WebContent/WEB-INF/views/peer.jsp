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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.min.js">
	
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
		<span id="hm">Peer Configuration</span>
	</div>

	<%@include file="sidebar.jsp"%>

	<c:out value="${value}"></c:out>
	<div class="ct">
		<div class="seconddiv">
			<span class="namename">Peer Configuration</span> <a
				class="anotherhref" href="./addpeer"><span class="create">Add
					Peer Configuration</span></a>
		</div>


		<div id="main1">
			<div id="div1">
				<button id="close">X</button>

				<button id="yes">YES</button>
				<button id="no">NO</button>
				<label id="erlabel1">Are you sure you want Delete?</label>

			</div>
		</div>



		<form method="get" action="samplefilter">

			<input class="sr" type="text" placeholder="SEARCH" id="search"
				required />

		</form>

		<!-- <table id="customers">-->
		
		<div class="col-sm-12" id="tbl">
		<table class="table table-striped table-bordered" >
			<thead>
				<tr>
					<th>HostName</th>
					<th>Address</th>
					<th>Port</th>
					<th>Protocol</th>
					<th>Response Timeout</th>
					<th>WatchDog Timeout</th>
					<th>Action</th>


				</tr>
			</thead>
			<tbody>
				<c:forEach var="Sample" items="${list}">
					<tr>
						<td>${Sample.host_name}</td>
						<td>${Sample.address}</td>
						<td>${Sample.port}</td>
						<td>${Sample.protocol}</td>
						<td>${Sample.resp_timeout}</td>
						<td>${Sample.watch_timeout}</td>
						<td><select  id="sh" class="form-control">
								<option value="" style="display: none" disabled selected>Select</option>
								<option id="a" value="1">Modify</option>
								<option class="delete" value="2">Delete</option>

						</select></td>

<!-- <td><select id="sh"  class="form-control">
								<option value="" style="display: none" disabled selected>Select</option>
								<option id="a" value="1">Modify</option>
								<option class="delete" value="2">Delete</option>

						</select></td>-->
					</tr>

				</c:forEach>
			</tbody>
		</table>
		</div>
	</div>
	
	<script src="./resources/js/jquery.paginate.js" type="text/javascript"></script>


	<script src="./resources/js/pagenation.js" type="text/javascript"></script>


	<script>
	$(document).ready(function(){

	  $(document).on('change', '#sh',function(){
	
		var val=$("#sh").val() == "1";
		var sel_opt =   $(this).val();

	
		if (sel_opt==1)
	      {
		
			
			<c:forEach var="Sample" items="${list}">
			
  			window.location.href='./editpeer/${Sample.host_name}';
	          connsole.log(window.location.href);
  			console.log("failed1");
  			</c:forEach>
	      }
	      else if(sel_opt==2){
	    		//alert('else codition');		
				$("#main1,#bgopacity").show();
	    		
				      }
	      
	      
	});
});

	

 $(document).ready(function(){

$("#no").click(function(){
    $("#main1,#bgopacity").hide();
});
});

$(document).ready(function(){

 $("#close").click(function(){
    $("#main1,#bgopacity").hide();
});

});



 $(document).ready(function(){
 
 $("#yes").click(function(){

		
	<c:forEach var="Sample" items="${list}">
  			window.location='./deletepeer/${Sample.host_name}';
            </c:forEach>

});
});
</script>
</body>
</html>
