<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="/NotificationEditor/resources/js/jquery-3.3.1.js"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="//fonts.googleapis.com/css?family=Open+Sans" />
<link rel="stylesheet" href="/NotificationEditor/resources/css/main.css"
	type="text/css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>SMS is loading</title>
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
		<label class="admin_label7"><span id="tag">SMS</span></label>

	</div>
	<div class="dummy"></div>



	<div class="homeclass">
		<span id="hm">SMS</span>
	</div>
	<div class="sidebar">
		<ul class="demo_ul">
			<li id="has-sub" class="demo_li"><a id="noti1" class="hrefa"
				href="../../"><i id="icon_fa" class="fa fa-list"></i><span
					class="selected">Home</span></a></li>
			<li id="has-sub" class="demo_li"><a id="noti" class="hrefa"
				href="../../notify"><i id="icon_fa" class="fa fa-bell"></i>Notification</a></li>

			<li id="has-sub" class="demo_li"><a id="sample" class="hrefa"
				href="../.././sample"><i id="icon_fa" class="fa fa-list"></i>Sample</a></li>

			<li id="has-sub" class="demo_li"><a id="text" class="hrefa"
				href="../.././text"><i id="icon_fa" class="fa fa-file-text"></i>Text</a></li>


			<li id="has-sub" class="demo_li"><a id="events" class="hrefa"
				href="../.././events"><i id="icon_fa" class="fa fa-unlink"></i>Events</a></li>
			<li id="has-sub" class="demo_li"><a id="plan" class="hrefa"
				href="../.././plan"><i id="icon_fa" class="fa fa-th"></i>Plan</a></li>
			<li id="has-sub" class="demo_li"><a id="logout" class="hrefa"
				href="../.././logout"><i id="icon_fa" class="fa fa-rotate-left"></i>Logout</a></li>


		</ul>


	</div>

	<div class="ct">
		<div class="seconddiv">
			<span class="namename">SMS</span>
		</div>



		<div class="t1">

			<label class="noti_lbl7">Language</label> <select class="lang"
				name="language_sel" onchange="setLanguage(this.value)">

				<option disabled selected value>Choose Language</option>
				<c:forEach var="listLang" items="${listLang}">
					<option id="lang" value="${listLang.lang_id}">${listLang.lang_desc}</option>

				</c:forEach>

			</select> <label class="noti_lbl8">Text</label>
			<div class="noti_div1">

				<input type="hidden" name="language" id="language" val=''>

				<table class="noti_tbl2 textL" id="customers" frame="border">

					<tr>
						<th class="noti_th1">ID</th>
						<th class="noti_th1">Description</th>


					</tr>
					<tbody id="smstbody">

						<c:forEach var="user" items="${list1}">
							<tr class="clickToAdd">
								<td id="fi" class="noti_td1 fieldid">${user.fieldid}</td>
								<td id="sd" class="noti_td1 shortdesc">${user.shortdesc}</td>
							</tr>
						</c:forEach>
					</tbody>

				</table>

			</div>

			<button items="${notif} " class="addsamp" onClick="addleftAllItems()"
				value="${Notif.notitemplateid}">Add Sample</button>

			<label class="noti_lbl9">System text</label>
			<div class="noti_div2">
				<table class="noti_tbl2 systemtext" id="customers" frame="border">
					<thead>

						<tr>
							<th class="noti_th1">ID</th>
							<th class="noti_th1">Description</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="Sample" items="${list2}">
							<tr class="clickToAdd">
								<td id="t" class="noti_td1 fieldid">${Sample.fieldid}</td>
								<td class="noti_td1 shortdesc">${Sample.shortdesc}</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<button items="${notif}" class="addfix" onClick="addAllItems()"
				value="${Notif.notitemplateid}">Add Fixed</button>
		</div>


		<table class="customers1" id="customers1">
			<thead>
				<tr>
					<th>Order</th>
					<th>Type</th>
					<th onClick="sortBy('fieldidSort')">Id</th>
					<th>Credit</th>
					<th>Counter</th>
					<th>Description</th>
					<th>Select</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="smsList" items="${smsList}">
					<tr>
						<td>${smsList.orderid}</td>
						<td>${smsList.typesdesc}</td>
						<td>${smsList.fieldid}</td>
						<c:if test="${smsList.fieldtypeid==3}">
							<td>${smsList.shortdesc}</td>
						</c:if>
						<td></td>
						<td></td>
						<c:if test="${smsList.fieldtypeid==4}">
							<td>${smsList.shortdesc}</td>
						</c:if>
						<td><a class="deleteIvr"
							href="<c:url value="/deletefieldid/${smsList.fieldid}" />">Delete</a></td>

					</tr>
				</c:forEach>
			</tbody>



		</table>
		<button class="deleteRowBtn">Delete</button>
		<button class="postData" value="/sms/saveinfo">Save</button>
		<button class="moveDown">Move down</button>
		<button class="moveUp">Move up</button>

		<script>


function selectClick(fieldid,shortdesc){

        var element=document.querySelector("#customers1 tbody");
        var row=element.insertRow(element.rows.length);
        var cell1=row.insertCell(0);
        cell1.innerHTML="<span class='serialNumber'>" + (element.rows.length) + "</span>";
          var cell2=row.insertCell(1);
            cell2.innerHTML="Text";
            var cell3=row.insertCell(2);
              cell3.innerHTML=fieldid;
              var cell4=row.insertCell(3);
            cell4.innerHTML=shortdesc;
                var cell5=row.insertCell(4);
                  var cell6=row.insertCell(5);
                      var cell7=row.insertCell(6);  
                      cell7.innerHTML="<input type='checkbox' value='delete' class='deleteInput'>";
        
        
}

function rightClick(fieldid,shortdesc){

        var element=document.querySelector("#customers1 tbody");
        var row=element.insertRow(element.rows.length);
        var cell1=row.insertCell(0);
        cell1.innerHTML="<span class='serialNumber'>" + (element.rows.length) + "</span>";
          var cell2=row.insertCell(1);
           cell2.innerHTML="System Text";
            var cell3=row.insertCell(2);
              cell3.innerHTML=fieldid;
              var cell4=row.insertCell(3);
           
                var cell5=row.insertCell(4);
                  var cell6=row.insertCell(5);
                   cell6.innerHTML=shortdesc;
                  
                var cell7=row.insertCell(6);  
                      cell7.innerHTML="<input type='checkbox' value='delete' class='deleteInput'>";
                      
        
        
}

function setLanguage(val){
	
	//var postDataArr=[];
	document.getElementById("language").setAttribute('value',val);
	var lang=document.getElementById("language").value;
	var obj = {
            lang:lang
	};
	//postDataArr.push(obj);
	console.log(obj);

	$.ajax({
        url: 'http://localhost:8080/NotificationEditor/sms',
        type: 'POST',
        data: JSON.stringify(obj),
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        },
        dataType: 'json',
        success: function (data) {
        	  console.log(data[0].shortdesc);
        	  //$data = data.map.data;
        	  
				var html = '';
				for(var i=0; i<data.length;i++){
					html += '<tr class="clickToAdd">'; 
					html += '<td id="fi" class="noti_td1 fieldid">' + data[i].fieldid + '</td>';
					html += '<td id="sd" class="noti_td1 shortdesc">' + data[i].shortdesc + '</td>';
					html += '</tr>'; 
				}
				//console.log(html);
				$("#smstbody").html(html);
         
        }
    });
	
}

$(".deleteRowBtn").on("click", function() {
    var isDelete = false;
    $(".customers1 tbody .deleteInput:checked").each(function(){
       $(this).parent().parent().remove();
       isDelete = true;
    });
    
    if(isDelete) {
        reorderSerialNumber();
    }
})

function reorderSerialNumber() {
    $(".customers1 tbody .serialNumber").each(function(index){
       $(this).html((index + 1));
    });
}

$("body").on('click', '.clickToAdd',function() {
    if($(this).hasClass("clickToAddActive")) {
        $(this).removeClass("clickToAddActive");
    } else {
        $(this).addClass("clickToAddActive");}
});
        
function addAllItems() {
    $(".systemtext .clickToAddActive").each(function(index) {
        var shortdesc = $(this).children(".shortdesc").html();
        var fieldid = $(this).children(".fieldid").html();
        rightClick(fieldid, shortdesc);
        $(this).removeClass('clickToAddActive');
      /* 
        $(this).remove(); */
    });
}
function addleftAllItems() {
    $(".textL .clickToAddActive").each(function(index) {
        var shortdesc = $(this).children(".shortdesc").html();
        var fieldid = $(this).children(".fieldid").html();
       
        selectClick(fieldid,shortdesc);
        $(this).removeClass('clickToAddActive');
       /*  $(this).remove(); */
    });
}




function sortBy(predicate) {

    var arr  = []; 
    $(".customers1 tbody tr").each(function(index){
        var superElem = parseInt($(this).children(predicate).html());arr.push({from: index, elem : superElem, to: index});
    });

    for(var i=0; i < arr.length; i++) {

        for(var j = i; j < arr.length; j++) {
            if(arr[i].elem > arr[j].elem) {
                var temp = arr[i];
                arr[i] = arr[j];
                arr[i].to = i;
                arr[j] = temp;
                arr[j].to = j;
            }
        }

    }


    var sortedHtml = "";
    for(var i=0; i < arr.length; i++) {
        var elem = $(".customers1 tbody tr")[arr[i].from];
        sortedHtml += elem.outerHTML;
    }
    $(".customers1 tbody").html(sortedHtml);
}

/* $(".postData").on("click", function(e){
    var postDataArr = [];
    var language = $("[name=language_sel]").val();
    if( language == null || language == 'null' ){
    	alert("Please select language.");
    	e.preventDefault();
    	return false;
    }
    
    var lang=document.getElementById("language").value;
     */
     $(".postData").on("click", function(e){
    	    var postDataArr = [];
    	    var language = $("[name=language_sel]").val();
    	    if( language == null || language == 'null' ){
    	    	alert("Please select language.");
    	    	e.preventDefault();
    	    	return false;
    	    }
    	    
    	    var lang=document.getElementById("language").value;





/*

$(".postData").on("click", function(){
    var postDataArr = [];
    var lang=document.getElementById("language").value;
    */
    
    $(".customers1 .selected").each(function(){
        var obj = {
            orderid: null,
     	lang_id:lang,
            fieldtypeid: null,
            fieldid: null,
            credit: null,
            counter: null,
            desc: null,
     	notitemplateid: ${Notif.notitemplateid},
      		serviceid: -1,
            counterid: -1,
            typeid: 2,
            condid: 0
        
     };
    
        
       $(this).children("td").each(function(index){
    	 
           switch(index) {
               case 0:
                   obj.orderid = $(this).children("span").html();
                   break;
               case 1:
                   obj.fieldtypeid = $(this).html();
                   break;
                case 2:
                   obj.fieldid = $(this).html();
                   break;
               case 3:
                   obj.credit = $(this).html();
                   break;
               case 4:
                   obj.counter = $(this).html();
                   break;
               case 5:
                   obj.desc = $(this).html();
                   break;
           
            
           }
       });
       postDataArr.push(obj);
    });
    
    console.log("postDataArr", postDataArr);
 
    function getvalue() {
    	   console.log(event.target.value);
    	}
  
    function ShowMessage() {
        var result = confirm("Successfully updated");
        if (result) {
            return true;
        } else {
            return false;
        }
    }
    
    console.log("DAta=======>",JSON.stringify(postDataArr));
    $.ajax({
        url: 'http://localhost:8080/NotificationEditor/sms/saveinfo',
        type: 'POST',
        data: JSON.stringify(postDataArr),
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        },
        dataType: 'json',
        success: function(result){
        	//console.log(result.map.success);
        	if(result.map.success){
        		alert('Success');
        	}
        },
        error: function () {
        	//console.log('error occured');
        	alert("Error Occured");
        },
        complete: function (data) {
          console.log('On complete call');
          
        
        }
    });

});
     function getvalue() {
  	   console.log(event.target.value);
  }
  
  

  function ShowMessage() {
      var result = confirm("Successfully updated");
      if (result) {
          return true;
      } else {
          return false;
      }
  }

  
$(document).ready(function(){
	
	$('body').on('change', '.deleteInput', function() {
		console.log("Hello Data input");
  	if ($(this).is(':checked')) {
  		$(this).parent().parent().addClass('selected');
  	} else {
  		$(this).parent().parent().removeClass('selected');
  	}
		console.log("Log 2");
	});	
	
	
	
  $('.moveUp').on('click', function () {
		$('tr.selected').each(function () {
  		if ($(this).prev() && $(this).prevAll(':not(.selected)').length) {
  			console.log($(this).prev());
  			console.log($(this).prevAll(':not(.selected)').length);
  			$(this).insertBefore($(this).prev());   
  		}
  	});
  	reArange();
  });
  $('.moveDown').on('click', function () {
		console.log("Log 5");
  	$($('tr.selected').get().reverse()).each(function () {
  		console.log($(this).nextAll(':not(.selected)').length);
  		if ($(this).next() && $(this).nextAll(':not(.selected)').length) {
  			$(this).insertAfter($(this).next());			
  		}
  	});
  	reArange();
  });
  
  
  
  function reArange(){
  	$count = 1;
  	$('#customers1 > tbody  > tr').each(function() {
				$(this).find('td:first-child').text($count++);
  	});
  }
  
 });











</script>


	</div>
</body>
</html>



