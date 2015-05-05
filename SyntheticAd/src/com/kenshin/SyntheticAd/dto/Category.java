package com.kenshin.SyntheticAd.dto;

public class Category {
	private int id;
	private String category_name;
	private String subcategory_name;
	private String category_uri;
	
	public int getId() {
		return id;
	}
	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getSubcategory_name() {
		return subcategory_name;
	}
	public void setSubcategory_name(String subcategory_name) {
		this.subcategory_name = subcategory_name;
	}
	public String getCategory_uri() {
		return category_uri;
	}
	public void setCategory_uri(String category_uri) {
		this.category_uri = category_uri;
	}
}
