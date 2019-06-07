<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	
	<script>
	
	function getLocation(){
		var latitude = document.getElementById("latitude").value;
		var longitude = document.getElementById("longitude").value;
		var selectedValue = $("#dropdown option:selected").text();
		
		if(selectedValue == 'Other'){
			selectedValue = document.getElementById("other-search").value;
		}
		
	    $("#result").html("");
		
		$.ajax({
			method : "POST",
			url : "/Location/place",
			data : "lat="+latitude+"&lon="+longitude+"&type="+selectedValue,
			success : function(response){
				
				$("#result").html(response);
			} ,
			error : function(e){
				alert("error");
			}
			
		});  
		
	}
	
	$(document).ready(function() {
		$('#other-search').hide();
			$('#dropdown').change(function() {
			    if( $(this).val() == "other") {
			        $('#other-search').show();
			    } else {       
			        $('#other-search').hide();
			    }
			});
			});
	
	</script>
</head>


<body>
	<h2 align="center">Search for any Type</h2>
	
	<table align = "center">
	<tr>
	<td>Latitude : </td>
	<td>
	<input type="text" placeholder="00.0000" id="latitude" value="">
	</td>
	</tr>
	<tr>
	<td>Longitude : </td>
	<td>
	<input type="text" placeholder="00.0000" id="longitude" value="">
	</td>
	</tr>
	<tr>
	<td>Filter : </td>
	<td><select id='dropdown' name="item" style="width: 173px">
	<option value="atm">ATM</option>
    <option value="bank">Bank</option>
	<option value="cinema">Cinema</option>
    <option value="coffee">Coffee</option>
    <option value="college">College</option>
    <option value="garden">Garden</option>
    <option value="hospital">Hospital</option>
    <option value="school">School</option>
    <option value="other">Other</option>
  </select>
  </td>
	</tr>
	<tr>
	<td></td>
	<td><input type="text" placeholder="Please provide specification" id="other-search" value=""></td>
	</tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr>
	<td></td>
	<td><button id="button-search" type="button" onclick="getLocation()">Search</button></td>
	</tr>
	</table>
	
	<br>
	<br>
	
	<div id="result"></div>
	
	<br>
	

</body>

</html>




