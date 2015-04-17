package com.kenshin.SyntheticAd.dto;

public class Location {
	private int id;
	private String city;
	private String district;
	private float lon;
	private float lat;
	public int getId() {
		return id;
	}
	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public float getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = Float.parseFloat(lon);
	}
	public float getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = Float.parseFloat(lat);
	}
	
}
