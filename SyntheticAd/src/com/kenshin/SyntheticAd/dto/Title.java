package com.kenshin.SyntheticAd.dto;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Title extends Post {
	private int id;
	private int category_id;
	private int post_id;
	private String title;
	private int user_id;
	private int location_id;
	private int type;
	private Date created_at;
	private Date updated_at;
	
	@Override
	public int getId() {
		return this.id;
	}
	@Override
	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}
	@Override
	public int getCategory_id() {
		return category_id;
	}
	@Override
	public void setCategory_id(String category_id) {
		this.category_id = Integer.parseInt(category_id);
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(String post_id) {
		this.post_id = Integer.parseInt(post_id);
	}
	
	@Override
	public String getTitle() {
		return title;
	}
	
	@Override
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public int getUser_id() {
		return user_id;
	}
	@Override
	public void setUser_id(String user_id) {
		this.user_id = Integer.parseInt(user_id);
	}
	@Override
	public int getLocation_id() {
		return location_id;
	}
	@Override
	public void setLocation_id(String location_id) {
		this.location_id = Integer.parseInt(location_id);
	}
	@Override
	public int getType() {
		return type;
	}
	@Override
	public void setType(String type) {
		this.type = Integer.parseInt(type);
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
	
}
