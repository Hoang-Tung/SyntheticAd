package com.kenshin.SyntheticAd.dto;

public class Title {
	private int id;
	private int category_id;
	private int post_id;
	private String title;
	private int user_id;
	private int location_id;
	private int type;
	
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
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(String post_id) {
		this.post_id = Integer.parseInt(post_id);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getType() {
		return type;
	}
	public void setType(String type) {
		this.type = Integer.parseInt(type);
	}
}
