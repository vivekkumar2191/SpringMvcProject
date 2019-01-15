<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="./resources/js/jquery-3.3.1.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="//fonts.googleapis.com/css?family=Open+Sans" />
<link rel="stylesheet" href="./resources/css/main.css" type="text/css"></link>
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
		<label class="admin_label7"><span id="tag">Text</span></label>

	</div>

	<div class="dummy"></div>


	<div class="homeclass">
		<span id="hm">Text</span>
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
			<span class="namename">TEXT</span>
		</div>
		<form:form method="get" action="textrecord">

			<input class="sr" type="text" pattern="[0-9]+"
				title="ID should only contain numeric digit. e.g. 123" name="id"
				placeholder="SEARCH ID" id="search" required />

		</form:form>
		<table id="customers">
			<thead>

				<tr>
					<th>ID</th>
					<th>Language</th>
					<th>Short Description</th>
					<th>Text</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="textrecord" items="${list}">
					<tr>
						<td>${textrecord.fieldid}</td>
						<td>${textrecord.languageid }</td>
						<td>${textrecord.shortdesc}</td>
						<td>${textrecord.longdesctext }</td>
						<td><select id="s" onchange="location = this.value;">
								<option value="" style="display: none" disabled selected value>Select</option>

								<option value="./edittext/${textrecord.fieldid}">Modify</option>
								<option class="confirm"
									data-confirm="Are you sure want to Delete?"
									value="./deletetext/${textrecord.fieldid}">Delete</option>
						</select></td>

					</tr>

				</c:forEach>
			</tbody>
		</table>


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