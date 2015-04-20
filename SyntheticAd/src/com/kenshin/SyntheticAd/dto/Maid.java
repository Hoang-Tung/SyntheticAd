package com.kenshin.SyntheticAd.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Maid extends Service {
	private int maid_id;
	private int category_id;
	private int post_id;
	private float area;
	private Date start_time;
	private Date end_time;
	
	public Maid() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Maid(Service parrent){
		super();
	}
	
	public int getId() {
		return id;
	}
	
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public float getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = Float.parseFloat(area);
	}
	
	public Date getStart_time() {
		return start_time;
	}
	
	public void setStart_time(String start_time) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			this.start_time = simpleDateFormat.parse(start_time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Date getEnd_time() {
		return end_time;
	}
	
	public void setEnd_time(String end_time) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			this.end_time = simpleDateFormat.parse(end_time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getMaid_id() {
		return maid_id;
	}
	
	public void setMaid_id(String maid_id) {
		this.maid_id = Integer.parseInt(maid_id);
	}

	public void setUser_id(int user_id) {
		// TODO Auto-generated method stub
		this.user_id = user_id;
	}

	public void setPrice(float price) {
		// TODO Auto-generated method stub
		this.price = price;
	}

	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	public void setLocation_id(int location_id) {
		// TODO Auto-generated method stub
		this.location_id = location_id;
	}

	public void setLat(float lat) {
		// TODO Auto-generated method stub
		this.lat = lat;
	}

	public void setLon(float lon) {
		// TODO Auto-generated method stub
		this.lon = lon;
	}

	public void setUpdated_at(Date updated_at2) {
		// TODO Auto-generated method stub
		this.updated_at = updated_at2;
	}

	public void setCreated_at(Date created_at) {
		// TODO Auto-generated method stub
		this.created_at = created_at;
	}

	public void setCondition(int condition) {
		// TODO Auto-generated method stub
		this.condition = condition;
	}

	public void setType(int type) {
		// TODO Auto-generated method stub
		this.type = type;
	}

	public void setCare_num(int care_num) {
		// TODO Auto-generated method stub
		this.care_num = care_num;
	}
	
	
	
}
