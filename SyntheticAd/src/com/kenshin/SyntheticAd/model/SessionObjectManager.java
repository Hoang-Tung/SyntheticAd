package com.kenshin.SyntheticAd.model;

import java.sql.Connection;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.kenshin.SyntheticAd.dao.SessionObject;
import com.kenshin.SyntheticAd.dao.UserObject;
import com.kenshin.SyntheticAd.database.Database;
import com.kenshin.SyntheticAd.dto.User;

@Api(name="session", version="v1")
public class SessionObjectManager {
	@ApiMethod(name="createSession")
	public User createSession(User user){
		User n_User = new User();
		Database database = new Database();
		System.out.println("api email " + user.getEmail());
		try {
			Connection con = database.getConnect();
			SessionObject object = new SessionObject();
			n_User = object.createSession(con, user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_User;
	}
}
