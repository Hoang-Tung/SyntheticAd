package com.kenshin.SyntheticAd;

import com.google.apphosting.api.DatastorePb.GetResponse.Entity;

public class Test extends Entity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String category_name;
	private String subcategory_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
}
