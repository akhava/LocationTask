<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	
	<script>
	
	function getLocation(){
		var location = document.getElementById("location").value;
		
	    $("#typeResult").html("");
		
		$.ajax({
			method : "POST",
			url : "/Location/Address",
			data : "location="+location,
			success : function(response){
				
				$("#typeResult").html(response);
			} ,
			error : function(e){
				alert("error");
			}
			
		});  
		
	}
	
	function getLocationType(){
		var latitude = document.getElementById("latitude").value;
		var longitude = document.getElementById("longitude").value;
		var selectedValue = $("#dropdown option:selected").text();
		
		if(selectedValue == 'Other'){
			selectedValue = document.getElementById("other-search").value;
		}
		
	    $("#locationResult").html("");
		
		$.ajax({
			method : "POST",
			url : "/Location/Type",
			data : "lat="+latitude+"&lng="+longitude+"&type="+selectedValue,
			success : function(response){
				
				$("#locationResult").html(response);
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
	<h2 align="center">Search for any Location</h2>
	
	<table>
	<tr>
	<td style="column-count: 10"></td>
	<td>Location : </td>
	<td>
	<input type="text" placeholder="Enter place" id="location" value="">
	</td>
	<td></td>
	<td style="column-count: 18"></td>
	
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
	
	<td></td>
	<td><input type="text" placeholder="Please provide specification" id="other-search" value=""></td>
	
	
	</tr>
	<tr>
	
	<td></td>
	<td><button id="searchLocation" type="button" onclick="getLocation()">Search</button></td>
	<td></td>
	<td></td>
	<td></td>
	<td><button id="searchLocationType" type="button" onclick="getLocationType()">Search</button></td>
	</tr>
	<tr>
	</table>
	
	<br>
	<br>
	
	<div id="locationResult"></div>
	<div id="latitude" style="display: none;">18.5244584</div>
	<div id="longitude" style="display: none;">73.7786739</div>
	<br>
	<br>
	<div id="typeResult"></div>
	
	<br>
	

</body>

</html>




