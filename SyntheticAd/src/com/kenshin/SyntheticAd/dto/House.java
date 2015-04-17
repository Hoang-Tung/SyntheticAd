package com.kenshin.SyntheticAd.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class House {
	private int id;
	private int category_id;
	private String title;
	private String description;
	private float price;
	private int condition;
	private int user_id;
	private int location_id;
	private float lat;
	private float lon;
	private int extend_type;
	private int care_num;
	private Date created_at;
	private Date updated_at;
	private float size;
	private String pass;
	private String imageUrl;
	private int type;
	private String address;
	private String phone_num;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	
	public int getId() {
		return id;
	}
	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = Integer.parseInt(category_id);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = Float.parseFloat(price);
	}
	public int getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = Integer.parseInt(condition);
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = Integer.parseInt(user_id);
	}
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(String location_id) {
		this.location_id = Integer.parseInt(location_id);
	}
	public float getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = Float.parseFloat(lat);
	}
	public float getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = Float.parseFloat(lon);
	}
	public int getExtend_type() {
		return extend_type;
	}
	public void setExtend_type(String extend_type) {
		this.extend_type = Integer.parseInt(extend_type);
	}
	public int getCare_num() {
		return care_num;
	}
	public void setCare_num(String care_num) {
		this.care_num = Integer.parseInt(care_num);
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
			System.out.println("exception found");
			e.printStackTrace();
		}
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
	public float getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = Float.parseFloat(size);
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getType() {
		return type;
	}
	public void setType(String type) {
		this.type = Integer.parseInt(type);
	}
}
