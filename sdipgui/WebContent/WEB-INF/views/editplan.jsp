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
<script src="../../resources/js/jquery-3.3.1.js" type="text/javascript"></script>
<link rel="stylesheet" href="../resources/css/main.css" type="text/css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.css">




</head>
<body>

	<div class="header_container">
		<span class=logo><a id="manral" href="../">Notification
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
		<span id="hm">Edit Plan</span>
	</div>
	<div class="sidebar">
		<ul class="demo_ul">
			<li id="has-sub" class="demo_li home"><a id="noti1"
				class="hrefa" href="../sample"><i id="icon_fa"
					class="fa fa-file-text"></i><span class="selected">Route
						Configuration</span></a></li>
			<li id="has-sub" class="demo_li notification"><a id="noti"
				class="hrefa" href="../peer"><i id="icon_fa"
					class="fa fa-file-text"></i>Peer Configuration</a></li>

			<li id="has-sub" class="demo_li"><a id="sample" class="hrefa"
				href=""><i id="icon_fa" class="fa fa-file-text"></i>BSF
					Application Configuration </a></li>

			<li id="has-sub" class="demo_li"><a id="text" class="hrefa"
				href="../bsfusage"><i id="icon_fa" class="fa fa-file-text"></i>BSF Usage
					Configuration</a></li>


			<li id="has-sub" class="demo_li"><a id="events" class="hrefa"
				href="../naf"><i id="icon_fa" class="fa fa-file-text"></i>NAF
					Provisioning Configuration </a></li>
			<li id="has-sub" class="demo_li"><a id="plan" class="hrefa"
				href=""><i id="icon_fa" class="fa fa-file-text"></i>Counter Data</a></li>
			<li id="has-sub" class="demo_li"><a id="logout" class="hrefa"
				href=""><i id="icon_fa" class="fa fa-rotate-left"></i>Logout</a></li>


		</ul>

	</div>

	<div class="ct">
		<div class="seconddiv">
			<span class="namename">PLAN</span>
		</div>


		<form:form method="POST" action="../editsaveplan"
			modelAttribute="Plan">
			<c:forEach var="Plan" items="${list}">
				<form:label path="name" class="smpl_lbl1">Plan Name</form:label>
				<form:input path="name" value="${Plan.name}" readonly="true"
					class="smpl_txt1" />
				<form:label path="namesample" class="smpl_lbl2">Name Sample</form:label>
				<form:input path="namesample" value="${Plan.namesample}"
					class="smpl_txt2" />

				<form:label path="precallsample" class="smpl_lbl4">Pre CallSample</form:label>
				<form:input path="precallsample" value="${Plan.precallsample}"
					class="smpl_txt5" />
				<form:label path="firstcallsample" class="smpl_lbl5">First CallSample</form:label>
				<form:input path="firstcallsample" value="${Plan.firstcallsample}"
					class="smpl_txt4" />



			</c:forEach>
			<input onclick="javascript:return ShowMessage();" type="submit"
				class="smpl_new2" value="Submit" />

		</form:form>

	</div>
	<script>
            function ShowMessage() {
                var result = confirm("Do your want to submit form?");
                if (result) {
                    return true;
                } else {
                    return false;
                }
            }
        </script>
	<!--                       
 <script type="text/javascript">
            function show_alert(){
                alert(" successfully updated plan ")
            }
        </script>
 -->
</body>
</html>
