package com.kenshin.SyntheticAd.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Maid extends Job {
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
	
	public Maid(Job parrent){
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

	public void setLat(Double lat) {
		// TODO Auto-generated method stub
		this.lat = lat;
	}

	public void setLon(Double lon) {
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
	
	public Job createJob(){
		Job n_Job = new Job();
		n_Job.setId("" +this.getPost_id());
		n_Job.setAddress(this.getAddress());
		n_Job.setCare_num(String.valueOf(this.getCare_num()));
		n_Job.setCategory_id(String.valueOf(this.getCategory_id()));
		n_Job.setCondition(String.valueOf(this.getCondition()));
		n_Job.setDescription(this.getDescription());
		n_Job.setPrice(String.valueOf(this.getPrice()));
		n_Job.setPhone_num(this.getPhone_num());
		n_Job.setType(String.valueOf(this.getType()));
		n_Job.setTitle(this.getTitle());
		n_Job.setSize(String.valueOf(this.getSize()));
		
		return n_Job;
	}
	
	public void setMaid(Job datas){
		this.setId(datas.getId());
		this.setTitle(datas.getTitle());
		this.setDescription(datas.getDescription());
		this.setPrice(datas.getPrice());
		this.setCategory_id(datas.getCategory_id());
		this.setAddress(datas.getAddress());
		this.setPass(datas.getPass());
		this.setPhone_num(datas.getPhone_num());
		this.setLocation_id(datas.getLocation_id());
		this.setImageUrl(datas.getImageUrl());
		this.setLat(datas.getLat());
		this.setLon(datas.getLon());
		this.setUpdated_at(datas.getUpdated_at());
		this.setCreated_at(datas.getCreated_at());
		this.setCondition(datas.getCondition());
		this.setType(datas.getType());
		this.setUser_id(datas.getUser_id());
		this.setCare_num(datas.getCare_num());
	}
	
}
