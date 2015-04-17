package com.kenshin.SyntheticAd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kenshin.SyntheticAd.dto.Post;
import com.kenshin.SyntheticAd.dto.Service;
import com.kenshin.SyntheticAd.dto.Vehicle;

public class ServiceObject {
	
	public ArrayList<Service> getAll(Connection connection) throws Exception {
		ArrayList<Service> datas = new ArrayList<Service>();
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM testcraighslist.service");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Service c = new Service();
				c.setId(rs.getString("id"));
				System.out.println(rs.getString("id"));

				c.setUser_id(rs.getString("user_id"));
				System.out.println(rs.getString("user_id"));

				c.setTitle(rs.getString("title"));
				System.out.println(rs.getString("title"));

				c.setCategory_id(rs.getString("category_id"));
				System.out.println(rs.getString("category_id"));

				c.setDescription(rs.getString("description"));
				System.out.println(rs.getString("description"));

				c.setType(rs.getString("type"));
				System.out.println(rs.getString("type"));

				c.setPrice(rs.getString("price"));
				System.out.println(rs.getString("price"));

				if (rs.getString("lon") != null) {
					c.setLon(rs.getString("lon"));
					System.out.println("lon " + rs.getString("lon"));
				}

				if (rs.getString("lat") != null) {
					c.setLat(rs.getString("lat"));
					System.out.println("lat " + rs.getString("lat"));
				}
				c.setLocation_id(rs.getString("location_id"));
				System.out.println(rs.getString("location_id"));

				if (rs.getString("image_url") != null) {
					c.setImageUrl(rs.getString("image_url"));
					System.out.println(rs.getString("image_url"));
				}

				if (rs.getString("condition") != null) {
					c.setCondition(rs.getString("condition"));
					System.out.println(rs.getString("condition"));
				}

				if (rs.getString("extend_type") != null) {
					c.setExtend_type(rs.getString("extend_type"));
				}

				c.setCare_num(rs.getString("care_num"));

				if (rs.getString("size") != null)
					c.setSize(rs.getString("size"));

				c.setCreated_at(rs.getString("created_at"));
				System.out.println(rs.getString("created_at"));

				c.setUpdated_at(rs.getString("updated_at"));
				System.out.println(rs.getString("updated_at"));
				
				if (rs.getString("pass") != null) {
					c.setPass(rs.getString("pass"));
				}
				
				c.setAddress(rs.getString("address"));
				if (rs.getString("phone_num") != null)
					c.setPhone_num(rs.getString("phone_num"));
				
				datas.add(c);
			}
			return datas;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			if (connection != null)
				connection.close();
		}

	}

	
}
