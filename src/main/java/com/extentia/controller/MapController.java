package com.extentia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.extentia.service.LocationService;

@Controller
public class MapController {
	
	@Autowired
	LocationService locationService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getPages() {

		ModelAndView model = new ModelAndView("search");
		return model;

	}
	
	@RequestMapping(value = "/place", method = RequestMethod.POST)
	public @ResponseBody String getLocation(@RequestParam String lat, 
			@RequestParam String lon, @RequestParam String type) {
		System.out.println("request lat = "+lat+" lon = "+lon+" type = "+type);
		String result = locationService.findPlaceTypeUsingLatLong(lat, lon, type);
		System.out.println(result);
	    
	    return result;
		
	}
	
}
