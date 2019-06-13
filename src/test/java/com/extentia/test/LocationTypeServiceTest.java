package com.extentia.test;

import com.extentia.service.LocationTypeService;
import com.extentia.serviceImpl.LocationTypeServiceImpl;

public class LocationTypeServiceTest {
	
	LocationTypeService locationTypeService = new LocationTypeServiceImpl();
	
	public String getLocationTypeTest(String lat, String lng, String type) {
		String result = locationTypeService.findLocationTypeUsingLatLng(lat, lng, type);
		return result;
	}

}
