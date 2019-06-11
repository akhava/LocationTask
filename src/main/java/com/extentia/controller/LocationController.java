package com.extentia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.extentia.dto.LocationDTO;
import com.extentia.service.LocationService;

@Controller
public class LocationController {

	@Autowired
	LocationService locationService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getPages() {

		ModelAndView model = new ModelAndView("search");
		return model;

	}

	@RequestMapping(value = "Address", method = RequestMethod.POST)
	public @ResponseBody LocationDTO getLocationAddress(@RequestParam String location) {
		System.out.println("search location = " + location);
		LocationDTO locationDTO = locationService.findLocationAddress(location);
		return locationDTO;
	}

}
