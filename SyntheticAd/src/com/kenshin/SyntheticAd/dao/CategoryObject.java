package com.kenshin.SyntheticAd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kenshin.SyntheticAd.dto.Category;


public class CategoryObject {
	public ArrayList<Category> getAll(Connection connection) throws Exception{
		ArrayList<Category> catDatas = new ArrayList<Category>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM testcraighslist.category ");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Category c = new Category();
				c.setId(rs.getString("id"));
				c.setCategory_name(rs.getString("category_name"));
				c.setSubcategory_name(rs.getString("subcategory_name"));
				c.setCategory_uri(rs.getString("category_uri"));
				catDatas.add(c);
			}
			return catDatas;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			if (connection != null) connection.close();
		}
	}

	public Category getCategory(Connection connection, String id) throws Exception {
		// TODO Auto-generated method stub
		Category cat = new Category();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM testcraighslist.category WHERE category.id = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Category c = new Category();
				c.setId(rs.getString("id"));
				c.setCategory_name(rs.getString("category_name"));
				c.setSubcategory_name(rs.getString("subcategory_name"));
				c.setCategory_uri(rs.getString("category_uri"));
				cat = c;
			}
			return cat;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			if (connection != null) connection.close();
		}
	}
	
	public Category insertCategory(Connection connection, String query) throws Exception{
		Category nCategory = new Category();
		System.out.println("Đồ chơi");
		return nCategory;
	}
}
