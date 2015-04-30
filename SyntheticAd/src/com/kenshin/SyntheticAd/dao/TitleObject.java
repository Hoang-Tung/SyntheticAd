package com.kenshin.SyntheticAd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mortbay.log.Log;

import com.kenshin.SyntheticAd.dto.Title;

public class TitleObject {
	
	public boolean insertTitle(int category_id, int post_id, String title,
			int user_id) {
		return true;
	}
	
	public ArrayList<Title> getTitleByUser(Connection connection, String user_id) throws Exception{
		ArrayList<Title> datas = new ArrayList<Title>();
		
		try {
			
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM testcraighslist.title WHERE title.user_id = ?");
			ps.setString(1, user_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Title t = new Title();
				t.setCategory_id(rs.getString("category_id"));
				t.setPost_id(rs.getString("post_id"));
				t.setTitle(rs.getString("title"));
				if (rs.getString("user_id") != null)
					t.setUser_id(rs.getString("user_id"));
				t.setLocation_id(rs.getString("location_id"));
				t.setType(rs.getString("type"));
				datas.add(t);
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
	
	public ArrayList<Title> getTitleByKeyWord(Connection connection,
			String keyword, String location_id, String type) throws Exception {
		ArrayList<Title> titles = new ArrayList<Title>();

		ArrayList<String> list = new ArrayList<String>();
		
		String temp = Normalizer.normalize(keyword, Normalizer.Form.NFD);
		Pattern pattern1 = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		String temp1 = pattern1.matcher(temp).replaceAll("");
		
		Pattern pattern = Pattern.compile("\\w+");
		Matcher matcher = pattern.matcher(temp1);
		while (matcher.find()) {
			list.add(matcher.group());
			System.out.println(matcher.group());
		}

		try {
			String query = "SELECT * FROM testcraighslist.title WHERE ";
			StringBuilder builder = new StringBuilder(query);
			for (int i = 0; i < list.size(); i++) {
				if (i == list.size() - 1) {
					builder.append("title.title LIKE '%" + list.get(i) + "%'");
					break;
				}
				
				builder.append("title.title LIKE '%" + list.get(i) + "%'"
						+ "OR ");
				
			}
			
			if(location_id != null)
				builder.append(" AND title.location_id = " + location_id);
			if(type != null)
				builder.append(" AND title.type = " + type);
			
			query = builder.toString();
			System.out.println(query);
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Title t = new Title();
				t.setCategory_id(rs.getString("category_id"));
				t.setPost_id(rs.getString("post_id"));
				t.setTitle(rs.getString("title"));
				if (rs.getString("user_id") != null)
					t.setUser_id(rs.getString("user_id"));
				t.setLocation_id(rs.getString("location_id"));
				t.setType(rs.getString("type"));
				titles.add(t);
			}
			
			return titles;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			if (connection != null)
				connection.close();
		}
	}
}
