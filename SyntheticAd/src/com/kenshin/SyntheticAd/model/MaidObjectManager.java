package com.kenshin.SyntheticAd.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.kenshin.SyntheticAd.dao.MaidObject;
import com.kenshin.SyntheticAd.dao.ServiceObject;
import com.kenshin.SyntheticAd.dao.VehicleObject;
import com.kenshin.SyntheticAd.database.Database;
import com.kenshin.SyntheticAd.dto.Maid;
import com.kenshin.SyntheticAd.dto.Vehicle;

@Api(name = "maid", version = "v1")
public class MaidObjectManager {

	@ApiMethod(name = "getmaidbylocationandcategory")
	public ArrayList<Maid> getMaidLocationAndCategory(
			@Named("category_id") String category_id,
			@Named("location_id") String location_id,
			@Named("type") String type, @Named("offset") String offset)
			throws Exception {
		ArrayList<Maid> datas = new ArrayList<Maid>();

		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			MaidObject object = new MaidObject();
			datas = object.getMaidByCategoryAndLocation(connection,
					category_id, location_id, type, offset);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return datas;
	}

	@ApiMethod(name = "maidcreate")
	public Maid insertMaid(Maid maid,
			@Named("password") @Nullable String password) throws Exception {
		Maid n_maid = new Maid();

		Database database = new Database();
		try {
			Connection con = database.getConnect();
			MaidObject object = new MaidObject();
			n_maid = object.createMaid(con, maid, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_maid;
	}
	
	@ApiMethod(name="maidupdate")
	public Maid updateMaid(Maid maid){
		Maid nMaid = new Maid();
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			MaidObject object = new MaidObject();
			nMaid = object.updateMaid(con, maid);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nMaid;
	}
	
	@ApiMethod(name="maiddelete")
	public void deleteMaid(@Named("id") String id){
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			MaidObject object = new MaidObject();
			object.deleteMaid(con, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
