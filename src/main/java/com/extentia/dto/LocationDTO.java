package com.extentia.dto;

public class LocationDTO {
	
	private String address;
	private String lat;
	private String lng;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	@Override
	public String toString() {
		return "LocationDTO [address=" + address + ", lat=" + lat + ", lng=" + lng + "]";
	}

}
