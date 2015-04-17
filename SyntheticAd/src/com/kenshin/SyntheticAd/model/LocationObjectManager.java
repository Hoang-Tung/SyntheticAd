package com.kenshin.SyntheticAd.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.kenshin.SyntheticAd.database.Database;
import com.kenshin.SyntheticAd.dao.LocationObject;
import com.kenshin.SyntheticAd.dto.Location;

@Api(name = "location", version="v1")
public class LocationObjectManager {
	@ApiMethod(name = "locations")
	public ArrayList<Location> getAll() throws Exception{
		ArrayList<Location> datas = null;
		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			LocationObject object = new LocationObject();
			datas = object.getAll(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return datas;
	}
}
