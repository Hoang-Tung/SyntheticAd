package com.kenshin.SyntheticAd.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.kenshin.SyntheticAd.dao.MaidObject;
import com.kenshin.SyntheticAd.dao.ServiceObject;
import com.kenshin.SyntheticAd.database.Database;
import com.kenshin.SyntheticAd.dto.Maid;

@Api(name="maid", version="v1")
public class MaidObjectManager {
	
	@ApiMethod(name="getMaid")
	public ArrayList<Maid> getMaidLocationAndCategory(@Named("category_id") String category_id,
			@Named("location_id") String location_id, @Named("type") String type,
			@Named("offset") String offset) throws Exception{
		ArrayList<Maid> datas = new ArrayList<Maid>();
		
		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			MaidObject object = new MaidObject();
			datas = object.getMaidByCategoryAndLocation(connection, category_id, location_id, type, offset);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return datas;
	}
	
	@ApiMethod(name="createMaid")
	public Maid createMaid(Maid maid) throws Exception{
		Maid n_maid = new Maid();
		
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			MaidObject object = new MaidObject();
			n_maid = object.createMaid(con, maid);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		n_maid = maid;
		return n_maid;
	}
	
}
