package com.kenshin.SyntheticAd.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Maid extends Service {
	private int id;
	private int category_id;
	private int post_id;
	private int area;
	private Date start_time;
	private Date end_time;
	private Date updated_at;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
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
	
	public Date getStart_time() {
		return start_time;
	}
	
	public void setStart_time(String start_time) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			this.updated_at = simpleDateFormat.parse(start_time);
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
			this.updated_at = simpleDateFormat.parse(end_time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
