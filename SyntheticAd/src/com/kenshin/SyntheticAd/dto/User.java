package com.kenshin.SyntheticAd.dto;

import java.text.DateFormat;

public class User {
	private int id;
	private String email;
	private String password;
	private String phone;
	private DateFormat created_at;
	private int point;
	public int getId() {
		return id;
	}
	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public DateFormat getCreated_at() {
		return created_at;
	}
	public void setCreated_at(DateFormat created_at) {
		this.created_at = created_at;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = Integer.parseInt(point);
	}
}
