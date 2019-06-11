
package com.extentia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.extentia.service.LocationTypeService;

@Controller
public class LocationTypeController {

	@Autowired
	LocationTypeService locationTypeService;

	@RequestMapping(value = "/Type", method = RequestMethod.POST)
	public @ResponseBody String getLocationType(@RequestParam String lat,

			@RequestParam String lng, @RequestParam String type) {
		System.out.println("request lat = " + lat + " lon = " + lng + " type = " + type);
		String result = locationTypeService.findLocationTypeUsingLatLng(lat, lng, type);
		System.out.println(result);

		return result;

	}

}
