package com.kenshin.SyntheticAd.dto;

public class TeacherSubject {
	private int id;
	private String subject_name;
	
	public int getId() {
		return id;
	}
	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
}
