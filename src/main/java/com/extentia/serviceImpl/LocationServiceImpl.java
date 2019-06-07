package com.extentia.serviceImpl;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.extentia.service.LocationService;

@Component
public class LocationServiceImpl implements LocationService {

	@Override
	public String findPlaceTypeUsingLatLong(String lat, String lon, String type) {

		final String uri = "https://api.foursquare.com/v2/venues/explore?client_id=0YVQDFWAG0YWCWLZ4MA3W1RPIY2Q2D5PTN5TFJWO2SW3XBTF&client_secret=Y145GNSOSFTGOPCZH2GT0AEBKFY2YWM2DVMZBPD2YXUSCS5U&v=20190605&limit=1&ll="+lat+","+lon+"&query="
				+ type;

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		return result;
	}

}
