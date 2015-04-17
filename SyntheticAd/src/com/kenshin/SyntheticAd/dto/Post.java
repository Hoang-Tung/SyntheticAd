package com.kenshin.SyntheticAd.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {
	private int id;
	private int user_id;
	private int subcategory_id;
	private String info;
	private int type;
	private float price;
	private float lon;
	private float lat;
	private int location_id;
	private String image_url;
	private Date created_at;
	private Date updated_at;
	private int condition;
	
	public int getId() {
		return id;
	}
	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = Integer.parseInt(user_id);
	}
	public int getSubcategory_id() {
		return subcategory_id;
	}
	public void setSubcategory_id(String subcategory_id) {
		this.subcategory_id = Integer.parseInt(subcategory_id);
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getType() {
		return type;
	}
	public void setType(String type) {
		this.type = Integer.parseInt(type);
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = Float.parseFloat(price);
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
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(String location_id) {
		this.location_id = Integer.parseInt(location_id);
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			this.created_at = simpleDateFormat.parse(created_at);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = Integer.parseInt(condition);
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			this.updated_at = simpleDateFormat.parse(updated_at);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
