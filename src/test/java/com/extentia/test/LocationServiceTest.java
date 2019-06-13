package com.extentia.test;

import com.extentia.dto.LocationDTO;
import com.extentia.service.LocationService;
import com.extentia.serviceImpl.LocationServiceImpl;

public class LocationServiceTest {
	
	LocationService locationService = new LocationServiceImpl();
	
	public LocationDTO getLocationAddressTest(String location) {
		LocationDTO locationDTO = locationService.findLocationAddress(location);
		return locationDTO;
	}

}
