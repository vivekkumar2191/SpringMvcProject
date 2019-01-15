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
	<link rel="stylesheet" type="text/css" href="./resources/css/other.css" />
<![endif]-->

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>SDIP</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.css">




</head>
<body>

<div class="header_container">
		<span class=logo><a id="manral" href="./">Secure Digital Identity System </a></span>

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
		<label class="admin_label7"><span id="tag">Secure Digital Identity Platform</span></label>

	</div>

	<div class="dummy"></div>



	<div class="homeclass">
		<span id="hm">NAF Provisioning</span>
	</div>
	<div class="sidebar">
		<ul class="demo_ul">
			<li id="has-sub" class="demo_li home"><a id="noti1"
				class="hrefa" href="./sample"><i id="icon_fa" class="fa fa-file-text"></i><span
					class="selected">Route Configuration</span></a></li>
			<li id="has-sub" class="demo_li notification"><a id="noti"
				class="hrefa" href="./peer"><i id="icon_fa" class="fa fa-file-text"></i>Peer Configuration</a></li>

			<li id="has-sub" class="demo_li"><a id="sample" class="hrefa"
				href="./bac"><i id="icon_fa" class="fa fa-file-text"></i>BSF Application Configuration </a></li>

			<li id="has-sub" class="demo_li"><a id="text" class="hrefa"
				href="./bsfusage"><i id="icon_fa" class="fa fa-file-text"></i>BSF Usage Configuration</a></li>


			<li id="has-sub" class="demo_li"><a id="events" class="hrefa"
				href="./naf"><i id="icon_fa" class="fa fa-file-text"></i>NAF Provisioning Configuration </a></li>
			<li id="has-sub" class="demo_li"><a id="plan" class="hrefa"
				href=""><i id="icon_fa" class="fa fa-file-text"></i>Counter Data</a></li>
			<li id="has-sub" class="demo_li"><a id="logout" class="hrefa"
				href=""><i id="icon_fa" class="fa fa-rotate-left"></i>Logout</a></li>


		</ul>

	</div>
	<div class="ct">
		<div class="seconddiv">
			<span class="namename">NAF Provisioning</span>
			<a class="anotherhref"
				href="./addnaf"><span class="create">Add NAF Configuration</span></a>
		</div>


		<form method="get" action="searchnafprovisioning">

			<input class="sr" type="text" pattern="[0-9]+"
				title="Searchnafprovisioning  ID should only contain numeric digit. e.g. 123"
				name="id" placeholder="SEARCH ID" id="search" required />

		</form>
<div class="col-sm-12" id="tbl">
		<table class="table table-striped table-bordered" >
		<!--<table id="customers">-->
			<thead>
				<tr>
					<th>Domain Name</th>
					<th>Ua Security ProtocolId</th>
                    <th>IMPI Send Flag</th>
					<th>IP address</th>
					<th>Action</th>
				</tr>
			</thead>
			 <tbody>
				<c:forEach var="Naf" items="${list}">
					<tr>
						<td>${Naf.domain_name}</td>
						<td>${Naf.ua_security_protocol_id}</td>
						<td>${Naf.impi_send_flag}</td>
						<td>${Naf.ip_address}</td>
						<td><select id="sh"  class="form-control"
							onchange="window.location.href=this.value;">
								<option value="" style="display: none" disabled selected>Select</option>
								<option id="a" value="./editnaf/${Naf.domain_name}">Modify</option>
								

						</select></td>

					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
	<script src="./resources/js/jquery.paginate.js" type="text/javascript"></script>


	<script>
          $(document).ready(function () {
        	    $('table').paginate({
        	        'elemsPerPage': 10,
        	            'maxButtons': 6
        	    });
        	});
          
          var _gaq = _gaq || [];
          _gaq.push(['_setAccount', 'UA-36251023-1']);
          _gaq.push(['_setDomainName', 'jqueryscript.net']);
          _gaq.push(['_trackPageview']);

          (function() {
            var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
            ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
            var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
          })();

          
        </script>


	<script>
$(document).on('input', 'select', function(e){
    var msg = $(this).children('option:selected').data('confirm');
    if(msg != undefined && !confirm(msg)){
        $(this)[0].selectedIndex = 0;
    }
});

</script>
	
	

</body>
</html>