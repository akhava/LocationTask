<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	
	<script>
	
	function getLocation(){
		
		/* fetch('https://api.foursquare.com/v2/venues/explore?client_id=0YVQDFWAG0YWCWLZ4MA3W1RPIY2Q2D5PTN5TFJWO2SW3XBTF&client_secret=Y145GNSOSFTGOPCZH2GT0AEBKFY2YWM2DVMZBPD2YXUSCS5U&v=20190605&limit=1&ll=40.7243,-74.0018&query=coffee')
	    .then(function(response) {
	    	$("#result").html(response);
	    })
	    .catch(function() {
	    	alert("error");
	    }); */
		
		 var location = document.getElementById("input-search").value;
	    $("#result").html("");
		
		$.ajax({
			method : "POST",
			url : "/Location/place",
			data : "location="+location,
			success : function(response){
				
				$("#result").html(response);
			} ,
			error : function(e){
				alert("error");
			}
			
		}); 
		
	}
	
	function showMap(latitude,longitude) { 
		
		var googleLatandLong = new google.maps.LatLng(latitude,longitude);
		
		var mapOptions = { 
			zoom: 5,
			center: googleLatandLong,
			mapTypeId: google.maps.MapTypeId.ROADMAP 
		};
		
		var mapDiv = document.getElementById("map");
		map = new google.maps.Map(mapDiv, mapOptions);
			
		var title = "Server Location"; 
		addMarker(map, googleLatandLong, title, "");
			
	}
		
	function addMarker(map, latlong, title, content) { 
			
		var markerOptions = {
			position: latlong, 
			map: map,
			title: title, 
			clickable: true
		};
		var marker = new google.maps.Marker(markerOptions); 
	}
		
	
	</script>
</head>


<body>
	<h2>Search for any location</h2>

	<div>
		<input type="text" placeholder="" id="input-search" value="">
		<span>
			<button id="button-search" type="button" onclick="showMap('18.5047','73.7647')">Search</button>
		</span>
	</div>
	
	<br>
	<br>
	
	<div id="result"></div>
	
	<br>
	
	<div style="width:600px;height:400px" id="map"></div>

	
	<!-- <br/>
	<div id="result"></div>
	<br/>
	<div style="width:600px;height:400px" id="map"></div> -->

</body>
</html>




