package com.kenshin.SyntheticAd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kenshin.SyntheticAd.dto.Location;

public class LocationObject {
	public ArrayList<Location> getAll(Connection connection) throws Exception {
		ArrayList<Location> feedsData = new ArrayList<Location>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM testcraighslist.location");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Location c = new Location();
				c.setId(rs.getString("id"));
				System.out.println(rs.getString("id"));
				c.setCity(rs.getString("city"));
				System.out.println(rs.getString("city"));
				c.setDistrict(rs.getString("district"));
				System.out.println(rs.getString("district"));
				c.setLat(rs.getString("lat"));
				System.out.println(rs.getString("lat"));
				c.setLon(rs.getString("long"));
				System.out.println(rs.getString("long"));
				feedsData.add(c);
			}
			return feedsData;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			if (connection != null) connection.close();
		}
	}
}
