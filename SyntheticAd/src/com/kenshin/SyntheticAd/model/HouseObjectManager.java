package com.kenshin.SyntheticAd.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.kenshin.SyntheticAd.database.Database;
import com.kenshin.SyntheticAd.dao.CategoryObject;
import com.kenshin.SyntheticAd.dao.HouseObject;
import com.kenshin.SyntheticAd.dao.HouseObject;
import com.kenshin.SyntheticAd.dto.Category;
import com.kenshin.SyntheticAd.dto.House;
import com.kenshin.SyntheticAd.dto.House;

@Api(name = "house", version = "v1")
public class HouseObjectManager {
//	@ApiMethod(name = "houses")
//	public ArrayList<House> getAll(@Named("offset") String offset)
//			throws Exception {
//		ArrayList<House> datas = null;
//		try {
//			Database database = new Database();
//			Connection connection = database.getConnect();
//			HouseObject object = new HouseObject();
//			datas = object.getAll(connection, offset);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return datas;
//	}

	@ApiMethod(name = "house")
	public House getHouse(@Named("id") String id) throws Exception {
		House house = null;
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			HouseObject object = new HouseObject();
			house = object.getHouse(con, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return house;
	}

	@ApiMethod(name = "houseByCategoryAndLocation")
	public ArrayList<House> getVihicleByCategoryAndLocation(
			@Named("category_id") String category_id,
			@Named("location_id") String location_id,
			@Named("type") String type, @Named("offset") @Nullable String offset)
			throws Exception {
		ArrayList<House> datas = null;
		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			HouseObject object = new HouseObject();
			datas = object.getByLocationAndCategory(connection, category_id,
					location_id, type, offset);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return datas;
	}

	@ApiMethod(name = "houseByDistance")
	public ArrayList<House> getHouseByDistance(
			@Named("category_id") @Nullable String category_id,
			@Named("distance") @Nullable Double distance,
			@Named("offset") @Nullable int offset,
			@Named("lat") @Nullable Double lat,
			@Named("lon") @Nullable Double lon) throws Exception {
		ArrayList<House> datas = null;
		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			HouseObject object = new HouseObject();
			datas = object.getByDistance(connection, category_id, lat, lon,
					distance, offset);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return datas;
	}

	@ApiMethod(name = "housecreate")
	public House insertHouse(House house,
			@Named("password") @Nullable String password) throws Exception {
		House nHouse = new House();
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			HouseObject object = new HouseObject();
			nHouse = object.insertHouse(con, house, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nHouse;
	}

	@ApiMethod(name = "houseupdate")
	public House updateViHouse(House house) throws Exception {
		House nHouse = new House();
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			HouseObject object = new HouseObject();
			nHouse = object.updateHouse(con, house);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nHouse;
	}

	@ApiMethod(name = "housedelete")
	public void deleteHouse(@Named("id") String id) throws Exception {
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			HouseObject object = new HouseObject();
			object.deleteHouse(con, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@ApiMethod(name = "increaseCareNum", path="houseInCreaseCareNum")
	public House inCreaseCareNum(@Named("category_id") String category_id,
			@Named("id") String id, @Named("user_id") @Nullable String user_id,
			@Named("password") @Nullable String password) {
		Database database = new Database();
		House n_House = new House();
		try {
			Connection con = database.getConnect();
			HouseObject object = new HouseObject();
			n_House.setCare_num("" + object.increaseCareNum(con, category_id, id, user_id, password));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_House;
	}

	@ApiMethod(name = "decreaseCareNum", path="houseDeCreaseCareNum")
	public House deCreaseCareNum(@Named("category_id") String category_id,
			@Named("id") String id, @Named("user_id") @Nullable String user_id,
			@Named("password") @Nullable String password) {
		Database database = new Database();
		House n_House = new House();
		System.out.println(user_id + " pp" + password);
		try {
			Connection con = database.getConnect();
			HouseObject object = new HouseObject();
			n_House.setCare_num("" + object.decreaseCareNum(con, category_id, id, user_id, password));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_House;
	}
	
	@ApiMethod(name = "houseByKeyword")
	public ArrayList<House> getHouseByKeyword(@Named("category_id") String category_id,
			@Named("keyword") @Nullable String keyword,
			@Named("location_id") @Nullable String location_id,
			@Named("type") @Nullable String type) {
		ArrayList<House> datas = new ArrayList<House>();

		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			HouseObject object = new HouseObject();
			datas = object.getHouseByKeyWord(connection, category_id, keyword, location_id,
					type);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return datas;
	}
}
