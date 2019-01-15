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
	
	<script src=http://code.jquery.com/jquery-1.11.1.min.js></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.16.0/dist/jquery.validate.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.16.0/dist/additional-methods.min.js"></script>
<!-- <script>

jQuery.validator.setDefaults({
    debug: false,      //Avoids form submit. Comment when in production.
    success: "valid",
    submitHandler: function() {
    
  $("#bgopacity,#main1").show();	
		 $("#no").click(function(){
		    $("#main1,#bgopacity").hide();
		 window.location.href='./';
		});

		 $("#close").click(function(){
		    $("#main1,#bgopacity").hide();
		});

		$("#yes").click(function(){
			//	$("#main1").show();	
		$('.table table-striped table-bordered').get(0).submit();
	//	$("form[name='route_form2']").submit();
   //    $('form[name="route_form2"]').submit();
		// $('#myform2').submit();
		});
        
    } 
 });
 
</script>
 --></head>
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
		<span id="hm">BSF Application Configuration</span>
	</div>

	<%@include file="sidebar.jsp"%>

	<c:out value="${value}"></c:out>
	<div class="ct">
		<div class="seconddiv">
			<span class="namename">BSF APPLICATION CONFIGURATION</span> 
<!--  				<a class="anotherhref" href="./addBac"><span class="create">Add BSF Configuration</span></a>  -->
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

		<input class="sr" type="text" placeholder="SEARCH" id="search" required />

		</form> 
	<div style="overflow:auto">
		<div class="row" id="tbl">
		 <div class="col-sm-2"></div>
		 
		 <div class="col-sm-8">
		 <table class="table table-striped table-bordered"> 
	
			<tbody>
		
		<c:forEach var="bac" items="${list}">
		<tr>
		<tr><th id="th1">BSF Server Name</th><td style="width:50%;">${bac.bsf_server_name}</td></tr>
	
		<tr><th id="th2">Destination Host</th><td>${bac.destination_host}</td></tr>
		<tr><th id="th3">Zn SOAP URL</th><td>${bac.zn_soap_url}</td></tr>
		<tr><th id="th4">GBA Type</th><td>${bac.gba_type}</td></tr>
		<tr><th id="th5">Ub Session Time</th><td>${bac.ub_session_time}</td></tr> 
		<tr><th id="th6">Ub Authentication domain</th><td>${bac.ub_authentication_domain}</td></tr>	
		<tr><th id="th7">GBA Digest</th><td>${bac.gba_Digest}</td></tr>	
		<tr><th id="th8">B-TID lifetime</th><td>${bac.b_tid_lifetime}</td></tr>
		<tr><th id="th9">GUSS Timestamp</th><td>${bac.guss_timestamp}</td></tr>	
		<tr><th id="th10">SLF</th><td>${bac.slf}</td></tr>	
		<tr><th id="th11">Ua Security Protocol ID</th><td>${bac.ua_security_protocol_id}</td></tr>	
		<tr><th id="th12">MaxNAFAllowed</th><td>${bac.maxNAFAllowed}</td></tr>	
		<tr><th id="th13">CDR Logging</th><td>${bac.cdr_logging}</td></tr>
		<tr><th id="th14">CDR Transfer Server</th><td>${bac.cdr_transfer_server}</td></tr>	
		<tr><th id="th15">CDR Transfer Server Details</th><td>${bac.cdr_transfer_server_details}</td></tr>	

	</c:forEach>
			
			</tbody>

</table>
		 
		 </div>
		 
		 <!-- <div class="col-sm-2" style="position:right;"><select  id="sh" class="form-control" onchange="window.location.href=this.value;">
								<option value="" style="display: none" disabled selected>Select</option>
								<option id="a" value="./editbac/${bac.bsf_server_name}">Modify</option>
								
    </select>
	</div>-->
	<div class="col-sm-2"><button type="button" class="btn btn-primary" id="btn" onclick="abc()">Modify</button>
	<div class="col-sm-8"><button type="button" class="btn btn-primary" id="btn1"  style="display:none;" onclick="save()">Save</button>
   </div>	
</div>
</div>
</div>
<!--<script>
(function () {

    function revert() {
        $("#tabledata .editfield").each(function () {
            var $td = $(this).closest('td');
            $td.empty();
            $td.text($td.data('oldText'));
            $td.data('editing', false);

            // canceled            
            console.log('Edit canceled.');
        });
    }

    function save($input) {
        var val = $input.val();
        var $td = $input.closest('td');
        $td.empty();
        $td.text(val);
        $td.data('editing', false);

        // send json or whatever
        console.log('Value changed');
    }


    $('#tabledata td').on('keyup', 'input.editfield', function (e) {
        if (e.which == 13) {
            // save
            $input = $(e.target);
            save($input);
        } else if (e.which == 27) {
            // revert
            revert();
        }
    });

    $("#tabledata td").click(function (e) {

        // consuem event
        e.preventDefault();
        e.stopImmediatePropagation();

        $td = $(this);

        // if already editing, do nothing.
        if ($td.data('editing')) return;
        // mark as editing
        $td.data('editing', true);

        // get old text
        var txt = $td.text();

        // store old text
        $td.data('oldText', txt);

        // make input
        var $input = $('<input type="text" class="editfield">');
        $input.val(txt);

        // clean td and add the input
        $td.empty();
        $td.append($input);
    });


    $(document).click(function (e) {
        revert();
    });
});

</script>-->
 <script>
 
function abc() { 
	
	$(".btn").hide();
	   
	 $("#btn1").show();
		
 var i = 1;
	$("td").each(function (){ 
		
		var OriginalContent = $(this).text();
		var name = $("#th"+i).text();
		var name = name.replace(new RegExp(' ', 'g'), '_');
 		//alert("name  "+name +"  content "+OriginalContent);
		$(this).addClass("cellEditing"); 
		$(this).html("<input type='text' name='"+name+"' value='" + OriginalContent + "' />"); 
		$(this).children().first().focus(); 
		
		
		//$(this).children().first().keypress(function (e) { 
			/* if (e.which == 13) { 
				var newContent = $(this).val(); 
				$(this).parent().text(newContent); 
				$(this).parent().removeClass("cellEditing");
				}
			}); 
		$(this).children().first().blur(function(){ 
			$(this).parent().text(OriginalContent); 
			$(this).parent().removeClass("cellEditing"); 
			}); */ 
			i++;
		}); 
	
	
}
function save(){
	 $("#btn1").show("",function(){
		 alert("Are you sure u want to modify");
		 
		/*  window.location = "./bac/${bac.bsf_server_name }" + id;
console.log("hi"); */
	 });
	
}

/* $(".bsf_app_parameter .selected").each(function(){
    var obj = {
        bsf_server_name: ${bac.bsf_server_name},
 	    destination_host: null,
        zn_soap_url: null,
        gba_type: null,
        ub_authentication_domain: null,
        gba_Digest: null,
        guss_timestamp: null,
        slf: null,
        ua_security_protocol_id: null,
        cdr_logging: null,
        cdr_transfer_server: null,
        cdr_transfer_server_details: null,
        ub_session_time: null,
        b_tid_lifetime: null,
        maxNAFAllowed:null,
        
 };
    
  $(this).children("td").each(function(index){
   	 
        switch(index) {
            case 0:
                obj.bsf_server_name = $(this).children("span").html();
                break;
            case 1:
                obj.destination_host = $(this).html();
                break;
             case 2:
                obj.zn_soap_url = $(this).html();
                break;
            case 3:
                obj.gba_type = $(this).html();
                break;
            case 4:
                obj.ub_authentication_domain = $(this).html();
                break;
            case 5:
                obj.gba_Digest = $(this).html();
                break;
            case 6:
            	obj.guss_timestamp= $(this).html();
            	break;
            	
            case 7:
            	obj.slf= $(this).html();
            	break;
            case 8:
            	obj.ua_security_protocol_id= $(this).html();
            	break;
            case 9:
            	obj.cdr_logging= $(this).html();
            	break;
            case 10:
            	obj.cdr_transfer_server=$(this).html();
            break;
            case 11:
            	obj.cdr_transfer_server_details=$(this).html();
            	break;
            case 12:
            	obj.ub_session_time=$(this).html();
            	break;
            case 13:
            	obj.b_tid_lifetime=$(this).html();
      break;
         console.log(obj);
        }
    });
    postDataArr.push(obj);
    console.log("DAta=======>",postDataArr);
 });

$.ajax({
url: 'http://localhost:8081/sdpigui/bac',
type: 'POST',
crossDomain:true,
data: JSON.stringify(obj),
headers: {
'Content-Type': 'application/json',
'Accept': 'application/json'
},
dataType: 'json',

});
 *//* jQuery.validator.setDefaults({
    debug: false,      //Avoids form submit. Comment when in production.
    success: "valid",
    submitHandler: function() {
    
  $("#bgopacity,#main1").show();	
		 $("#no").click(function(){
		    $("#main1,#bgopacity").hide();
		 window.location.href='./';
		});

		 $("#close").click(function(){
		    $("#main1,#bgopacity").hide();
		});

		$("#yes").click(function(){
			//	$("#main1").show();	
		$("#btn1").get(0).submit();
	//	$("form[name='route_form2']").submit();
   //    $('form[name="route_form2"]').submit();
		// $('#myform2').submit();
		});
        
    } 
 });
 */
</script>
<!-- <script>
jQuery(document).ready(function() {

	  $('#btn').click(function () {

	      var currentTD = $(this).closest('tr');

	      if ($(this).html() == 'Modify') {                  

	         $(currentTD).find('.inputDisabled').prop("disabled",false);   

	      } else {

	         $(currentTD).find('.inputDisabled').prop("disabled",true);   

	      }

	      $(this).html($(this).html() == 'Modify' ? 'Save' : 'Modify')

	  });
});
</script>-->
<!--<script>
$(document).ready(function(){ 
$('#button5').click(function(){ 
$('.disabledCheckboxes').prop("disabled", false);

});
});
</script>-->
                 
      

</body>
</html>