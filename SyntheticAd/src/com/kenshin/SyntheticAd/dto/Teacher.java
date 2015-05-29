package com.kenshin.SyntheticAd.dto;

import java.util.Date;

public class Teacher extends Job {
	private int teacher_id;
	private int post_id;
	private int category_id;
	private int subject_id;
	private int grade_type;
	
	public Teacher() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = Integer.parseInt(teacher_id);
	}
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(String subject_id) {
		this.subject_id = Integer.parseInt(subject_id);
	}
	public int getGrade() {
		return grade_type;
	}
	public void setGrade(String gradeType) {
		this.grade_type = Integer.parseInt(gradeType);
	}
	
	public Job createJob(){
		Job n_Job = new Job();
		
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

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = Integer.parseInt(category_id);
	}
	
	public void setUpdated_at(Date updated_at2) {
		// TODO Auto-generated method stub
		this.updated_at = updated_at2;
	}

	public void setCreated_at(Date created_at) {
		// TODO Auto-generated method stub
		this.created_at = created_at;
	}
	
	
	public void setMaid(Job datas){
		this.setId("" +datas.getId());
		this.setTitle(datas.getTitle());
		this.setDescription(datas.getDescription());
		this.setPrice("" + datas.getPrice());
		this.setCategory_id("" + datas.getCategory_id());
		this.setAddress(datas.getAddress());
		this.setPass(datas.getPass());
		this.setPhone_num(datas.getPhone_num());
		this.setLocation_id("" + datas.getLocation_id());
		this.setImageUrl(datas.getImageUrl());
		this.setLat("" + datas.getLat());
		this.setLon("" + datas.getLon());
		this.setUpdated_at(datas.getUpdated_at());
		this.setCreated_at(datas.getCreated_at());
		this.setCondition("" + datas.getCondition());
		this.setType("" + datas.getType());
		this.setUser_id("" + datas.getUser_id());
		this.setCare_num("" + datas.getCare_num());
	}
}
