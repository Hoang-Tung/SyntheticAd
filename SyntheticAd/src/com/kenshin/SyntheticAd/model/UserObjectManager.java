package com.kenshin.SyntheticAd.model;

import java.sql.Connection;
import java.util.ArrayList;

import sun.misc.BASE64Decoder;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.kenshin.SyntheticAd.dao.UserObject;
import com.kenshin.SyntheticAd.dao.VehicleObject;
import com.kenshin.SyntheticAd.database.Database;
import com.kenshin.SyntheticAd.dto.Title;
import com.kenshin.SyntheticAd.dto.User;
import com.kenshin.SyntheticAd.dto.Vehicle;

@Api(name="user",version="v1")
public class UserObjectManager {
	
	@ApiMethod(name="createUser")
	public User createUser(User user) throws Exception{
		User n_User = new User();
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			UserObject object = new UserObject();
			n_User = object.insertUser(con, user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_User;
	}
	
	public User getUser(@Named("email")String email){
		User n_User = new User();
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			UserObject object = new UserObject();
			n_User = object.getUser(con, email);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_User;
	}
}
