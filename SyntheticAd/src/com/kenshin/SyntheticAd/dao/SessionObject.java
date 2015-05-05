package com.kenshin.SyntheticAd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kenshin.SyntheticAd.dto.User;

public class SessionObject {
	public User createSession(Connection con, User user) throws Exception {
		User data = new User();
		try {
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM testcraighslist.user WHERE user.email = ?;");
			System.out.println("email in " + user.getEmail());
			ps.setString(1, user.getEmail());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("email " + rs.getString("email"));
				data.setEmail(rs.getString("email"));
				if (user.getPassword().equals(rs.getString("password"))) {
					data.setId(rs.getString("id"));
					data.setPhone(rs.getString("phone"));
					data.setPoint(rs.getString("point"));
				}
			}

			ps.close();
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
