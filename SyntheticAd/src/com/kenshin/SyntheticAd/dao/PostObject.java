package com.kenshin.SyntheticAd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kenshin.SyntheticAd.dto.Location;
import com.kenshin.SyntheticAd.dto.Post;

public class PostObject {
	public ArrayList<Post> getAll(Connection connection) throws Exception {
		ArrayList<Post> datas = new ArrayList<Post>();
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM testcraighslist.post");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Post c = new Post();
				c.setId(rs.getString("id"));
				System.out.println(rs.getString("id"));

				c.setUser_id(rs.getString("user_id"));
				System.out.println(rs.getString("user_id"));

				c.setSubcategory_id(rs.getString("subcategory_id"));
				System.out.println(rs.getString("subcategory_id"));

				c.setInfo(rs.getString("info"));
				System.out.println(rs.getString("info"));

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

				c.setImage_url(rs.getString("image"));
				System.out.println(rs.getString("image"));

				c.setCreated_at(rs.getString("created_at"));
				System.out.println(rs.getString("created_at"));

				c.setUpdated_at(rs.getString("updated_at"));
				System.out.println(rs.getString("updated_at"));
				
				if (rs.getString("condition") != null) {
					c.setCondition(rs.getString("condition"));
					System.out.println(rs.getString("condition"));
				}
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

	public ArrayList<Post> getPost(Connection con, String id) throws Exception {
		ArrayList<Post> data = new ArrayList<Post>();
		try {
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM testcraighslist.post WHERE post.id = ?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Post c = new Post();
				c.setId(rs.getString("id"));
				System.out.println(rs.getString("id"));

				c.setUser_id(rs.getString("user_id"));
				System.out.println(rs.getString("user_id"));

				c.setSubcategory_id(rs.getString("subcategory_id"));
				System.out.println(rs.getString("subcategory_id"));

				c.setInfo(rs.getString("info"));
				System.out.println(rs.getString("info"));

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

				c.setImage_url(rs.getString("image"));
				System.out.println(rs.getString("image"));

				c.setCreated_at(rs.getString("created_at"));
				System.out.println(rs.getString("created_at"));

				c.setUpdated_at(rs.getString("update_at"));
				System.out.println(rs.getString("update_at"));

				if (rs.getString("condition") != null) {
					c.setCondition(rs.getString("condition"));
					System.out.println(rs.getString("condition"));
				}
				data.add(c);
			}
			return data;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			if (con != null)
				con.close();
		}
	}
}
