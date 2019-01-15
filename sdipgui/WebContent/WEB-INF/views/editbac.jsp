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
<link rel="stylesheet" href="../resources/css/main.css" type="text/css"></link>
<link rel="stylesheet" href="../resources/css/bootstrap.css" type="text/css"/>
<!--[if IE]>
	<link rel="stylesheet" type="text/css" href="../resources/css/other.css" />
<![endif]-->

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>SDIP</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.css">

<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>


</head>
<body>
<div class="bgopacity" id="bgopacity"></div>
	<div class="header_container">
		<span class=logo><a id="manral" href="../">Secure Digital
				Identity Platform</a></span>

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
		<label class="admin_label7"><span id="tag">BSF Application Configuration</span></label>

	</div>

	<div class="dummy"></div>



	<div class="homeclass">
		<span id="hm">Modify BSF Application Configuration</span>
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
				href="../bac"><i id="icon_fa" class="fa fa-file-text"></i>BSF
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
			<span class="namename">BSF Application Configuration</span>
		</div>



		<div id="main1">
			<div id="div1">
				<button id="close">X</button>

				<button id="yes">YES</button>
				<button id="no">NO</button>
				<label id="erlabel1">do you want to modify</label>

			</div>
		</div>
		<div class="col-sm-3"></div>
		<div class="col-sm-6" id="tbl">
		<form:form method="POST" class="peerform" name="peerform"
			action=".././editsavebac" modelAttribute="Bac" style="border: 1px solid #eee;">
			<table class="table table-striped" >
				<c:forEach var="bac" items="${list}">
				<tr><td><span class="RC">BSF Server Name</span></td>
				<td><form:input path="bsf_server_name" value="${bac.bsf_server_name}" class="form-control" ></form:input></td>
				</tr>	
			<tr><td><span class="RC">Destination Host</span></td>
				<td><form:input path="destination_host" value="${bac.destination_host}" class="form-control"></form:input></td>
			</tr>
				<tr><td><span class="RC">Zn SOAP URL</span></td>
				<td><form:input path="zn_soap_url" value="${bac.zn_soap_url}" class="form-control"></form:input></td>
				
				</tr>
				<tr>					
				<td><span class="RC">GBA Type</span></td>
				<td><form:input path="gba_type" value="${bac.gba_type}" class="form-control"></form:input></td>
				</tr>
				<tr>
				<td><span class="RC">Ub Session Time</span></td>
				<td><form:input path="ub_session_time" value="${bac.ub_session_time}" class="form-control"></form:input></td>
				</tr>
				<tr>
				<td><span class="RC">Ub Authentication domain</span></td>
				<td><form:input path="ub_authentication_domain" value="${bac.ub_authentication_domain}" class="form-control"></form:input></td>
				</tr>
				<tr>
				<td><span class="RC">GBA Digest</span></td>
				<td><form:input path="gba_Digest" value="${bac.gba_Digest}" class="form-control"></form:input></td>
				</tr>
				<tr>
				<td><span class="RC">B-TID lifetime</span></td>
				<td><form:input path="b_tid_lifetime" value="${bac.b_tid_lifetime}" class="form-control"></form:input></td>
				</tr>
				<tr>
				<td><span class="RC">GUSS Time Stamp</span></td>
				<td><form:input path="guss_timestamp" value="${bac.guss_timestamp}" class="form-control"></form:input></td>
				</tr>
				<tr>
				<td><span class="RC">SLF</span></td>
				<td><form:input path="slf" value="${bac.slf}" class="form-control"></form:input></td>
				</tr>
				<tr>
				<td><span class="RC">Ua Security Protocol ID</span></td>
				<td><form:input path="ua_security_protocol_id" value="${bac.ua_security_protocol_id}" class="form-control"></form:input></td>
				</tr>
				<tr>
				<td><span class="RC">MaxNAFAllowed</span></td>
				<td><form:input path="maxNAFAllowed" value="${bac.maxNAFAllowed}" class="form-control"></form:input></td>
				</tr>
				<tr>
				<td><span class="RC">CDR Logging</span></td>
				<td><form:input path="cdr_logging" value="${bac.cdr_logging}" class="form-control"></form:input></td>
				</tr>
				<tr>
				<td><span class="RC">CDR Transfer Server</span></td>
				<td><form:input path="cdr_transfer_server" value="${bac.cdr_transfer_server}" class="form-control"></form:input></td>
				</tr>
				<tr>
				<td><span class="RC">CDR Transfer Server Details</span></td>
				<td><form:input path="cdr_transfer_server_details" value="${bac.cdr_transfer_server_details}" class="form-control"></form:input></td>
				</tr>
			<tr><td colspan="2"><form:hidden path="Bsf_server_name" name="id" value="${bac.bsf_server_name}" class="form-control"/></td></tr>
			</c:forEach>
			<tr><td colspan="2"><input type="submit" class="submitPeerNaf" value="Submit" class="form-control"></td></tr>
    </table>
			</form:form>
	</div>
</div>

</body>
</html>