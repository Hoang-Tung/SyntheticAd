package com.kenshin.SyntheticAd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;

import com.kenshin.SyntheticAd.dto.User;


public class UserObject {
	public User insertUser(Connection con, User user) throws Exception {
		
		User n_User = new User();
		
		String query = "INSERT INTO `testcraighslist`.`user` (`email`, `password`, `phone`) VALUES (?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getPhone());
			ps.executeUpdate();
			
			try {
				ResultSet rss = ps.getGeneratedKeys();
				
				if(rss.next()){
					PreparedStatement pss = con.prepareStatement("SELECT * FROM testcraighslist.user WHERE user.id = ?");
					//pss.setLong(1, rss.getLong(1));
					pss.setString(1, rss.getString(1));
					ResultSet rs1 = pss.executeQuery();
					
					if(rs1.next()){
						n_User.setId(rs1.getString("id"));
						n_User.setEmail(rs1.getString("email"));
						n_User.setPassword(rs1.getString("password"));
						n_User.setPhone(rs1.getString("phone"));
						n_User.setPoint(rs1.getString("point"));
					}
					pss.close();
					rs1.close();
				}
				rss.close();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			ps.close();
			con.close();
			return n_User;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			if (con != null) con.close();
		}
	}
	
	public User getUser(Connection con, String email) throws Exception{
		User data = new User();
		
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM testcraighslist.user WHERE user.email = ? ");
			
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				System.out.println("email " + rs.getString("email"));
				data.setEmail(rs.getString("email"));
				data.setPhone(rs.getString("phone"));
				data.setPoint(rs.getString("point"));
			}
			
			ps.close();
			return data;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			if (con != null) con.close();
		}
	}
}
