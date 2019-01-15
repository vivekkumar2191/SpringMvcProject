<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css"
	href="//fonts.googleapis.com/css?family=Open+Sans" />

<link rel="stylesheet" href="./resources/css/main.css" type="text/css"></link>
<link rel="stylesheet" href="./resources/css/bootstrap.css" type="text/css"/>
<!--[if IE]>
	<link rel="stylesheet" type="text/css" href="./resources/css/other.css" />
<![endif]-->


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>SDIP</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.css">
<link rel="stylesheet" href="../resources/css/style2.css"
	type="text/css" />

<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>

<script>
 
  
 jQuery.validator.setDefaults({
            debug: false,      //Avoids form submit. Comment when in production.
            success: "valid",
            submitHandler: function() {
            
            	
            $("#bgopacity,#main1").show();	
       		 $("#no").click(function(){
       		    $("#main1,#bgopacity").hide();
       		 window.location.href='./naf';
       		});

       		 $("#close").click(function(){
       		    $("#main1,#bgopacity").hide();
       		});

       		$("#yes").click(function(){
       			//	$("#main1").show();	
       		$('.peerform').get(0).submit();
       	//	$("form[name='route_form2']").submit();
           //    $('form[name="route_form2"]').submit();
       		//  $('#myform2').submit();
       		});
                
            }
         });
 
 
 $(document).ready(function() {
 
	 jQuery.validator.addMethod('validIP', function(value) {
		    var split = value.split('.');
		    if (split.length != 4) 
		        return false;
		            
		    for (var i=0; i<split.length; i++) {
		        var s = split[i];
		        if (s.length==0 || isNaN(s) || s<0 || s>255)
		            return false;
		    }
		    return true;
		}, ' Invalid IP Address');

	 
	 // validate signup form on keyup and submit
         $('form[name="peerform"]').validate({
            rules: {
            	domain_name: {
                  required: true,
                  lettersonly:true,
                  
			//	  url:true
		//	range: [1, 100]
		
               },
               ua_security_protocol_id: {
                  required: true,
               
               },
              

               impi_send_flag: {
                   required: true,
                
                },
                ip_address: {
                    required: true,
                   
                 },

                 
           },
            messages: {
            	domain_name: {
                  required: "domain_name required",
   //               minlength: usernameMsg,
     //             maxlength: usernameMsg
               },
 
 
               ua_security_protocol_id: {
                  required: "ua_security_protocol_id  required",
       //           minlength: passwordMsg,
         //         maxlength: passwordMsg
               },
               
               
               impi_send_flag: {
                   required: "impi_send_flag  required",
        //           minlength: passwordMsg,
          //         maxlength: passwordMsg
                },
               
                ip_address: {
                    required: "ip_address  required",
                    //           minlength: passwordMsg,
                      //         maxlength: passwordMsg
                            },
 
               

 			}
         });
      });
	  </script>

</head>
<body>

	<div class="bgopacity" id="bgopacity"></div>
	<div class="header_container">
		<span class=logo><a id="manral" href="./">Secure Digital Identity Platform </a></span>

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
		<label class="admin_label7"><span id="tag">NAF Provisioning</span></label>

	</div>

	<div class="dummy"></div>



	<div class="homeclass">
		<span id="hm">New  NAF Configuration</span>
	</div>
	<div id="main1">
			<div id="div1">
				<button id="close">X</button>

				<button id="yes">YES</button>
				<button id="no">NO</button>
				<label id="erlabel1">do you want to save</label>

			</div>
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
				href="./logout"><i id="icon_fa" class="fa fa-file-text"></i>Logout</a></li>


		</ul>

	</div>
	<div class="ct">
		<div class="seconddiv">
			<span class="namename">NAF Provisioning</span>
		</div>
		
		
<div class="col-sm-3"></div>
		<div class="col-sm-6" id="tbl">
		<form:form class="peerform" name="peerform" method="POST"
			action="savenaf">
	
 			<table class="table table-striped">
			<tr><td><span class="RC">Domain Name</span></td>
			<td><form:input class="form-control" path="domain_name" required="required"/></td>
			</tr>
		
			<tr><td><span class="RC">Ua Security ProtocolId</span></td>
			<td><form:input class="form-control" path="ua_security_protocol_id" required="required" /></td>
			</tr>
		
				<tr><td><span class="RC">IMPI Send Flag</span></td>
				<td><form:input class="form-control" path="impi_send_flag" 
					required="required" /></td>
					</tr>
				
			
			<tr>
				<td><span class="RC"> IP Address</span></td>
				<td><form:input path="ip_address" 
					required="required" class="form-control"/></td>
				</tr>
				
			<tr>
		<td colspan="2"><input class="stm1" type="Submit" value="Submit"  class="form-control"/></td>
		</tr>
		</table>
	</form:form>
</div>
</div>


</body>
</html>