package com.extentia.serviceImpl;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.extentia.service.LocationTypeService;
import com.extentia.utils.Constants;

@Component
public class LocationTypeServiceImpl implements LocationTypeService {

	@Override
	public String findLocationTypeUsingLatLng(String lat, String lng, String type) {

		final String uri = "https://api.foursquare.com/v2/venues/explore?client_id=" + Constants.foursquareClient_id
				+ "&client_secret=" + Constants.foursquareClient_secret + "&v=20190605&limit=1&ll=" + lat + "," + lng
				+ "&query=" + type;

		String result = "data not found";

		RestTemplate restTemplate = new RestTemplate();
		try {
			result = restTemplate.getForObject(uri, String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
