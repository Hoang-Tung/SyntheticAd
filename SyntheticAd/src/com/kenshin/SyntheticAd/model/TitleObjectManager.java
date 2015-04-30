package com.kenshin.SyntheticAd.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.kenshin.SyntheticAd.dao.TitleObject;
import com.kenshin.SyntheticAd.dao.VehicleObject;
import com.kenshin.SyntheticAd.database.Database;
import com.kenshin.SyntheticAd.dto.Title;
import com.kenshin.SyntheticAd.dto.Vehicle;

@Api(name = "title", version = "v1")
public class TitleObjectManager {

	@ApiMethod(name = "titleByKeyword")
	public ArrayList<Title> getTitleByKeyword(
			@Named("keyword") @Nullable String keyword,
			@Named("location_id") @Nullable String location_id,
			@Named("type") @Nullable String type) {
		ArrayList<Title> datas = new ArrayList<Title>();

		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			TitleObject object = new TitleObject();
			datas = object.getTitleByKeyWord(connection, keyword, location_id,
					type);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return datas;
	}
}
