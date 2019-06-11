package com.extentia.serviceImpl;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.extentia.dto.LocationDTO;
import com.extentia.service.LocationService;
import com.extentia.utils.Constants;

@Component
public class LocationServiceImpl implements LocationService {

	@Override
	public LocationDTO findLocationAddress(String location) {

		final String uri = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=" + location + "&key="
				+ Constants.googleApiKey;

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		System.out.println("search result = " + result);
		LocationDTO locationDTO = new LocationDTO();
		JSONParser parser = new JSONParser();
		JSONObject obj;
		String address = null;
		Double lat = null;
		Double lng = null;
		try {
			obj = (JSONObject) parser.parse(result);
			JSONArray array = (JSONArray) obj.get("results");
			for (int i = 0; i < array.size();) {
				JSONObject obj2 = (JSONObject) array.get(i);
				address = (String) obj2.get("formatted_address");
				JSONObject obj3 = (JSONObject) obj2.get("geometry");
				JSONObject obj4 = (JSONObject) obj3.get("location");
				lat = (Double) obj4.get("lat");
				lng = (Double) obj4.get("lng");
				System.out.println("address = " + address + ", lat = " + lat + ", lng = " + lng);
				break;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (address != null && !address.isEmpty()) {
			locationDTO.setAddress(address);
		} else {
			locationDTO.setAddress("Address not found");
		}
		if (lat != null) {
			locationDTO.setLat(lat.toString());
		} else {
			locationDTO.setLat("");
		}
		if (lng != null) {
			locationDTO.setLng(lng.toString());
		} else {
			locationDTO.setLng("");
		}

		return locationDTO;
	}

}
