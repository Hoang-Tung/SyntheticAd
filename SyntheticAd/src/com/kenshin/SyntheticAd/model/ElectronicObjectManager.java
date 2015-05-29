package com.kenshin.SyntheticAd.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.kenshin.SyntheticAd.database.Database;
import com.kenshin.SyntheticAd.dao.CategoryObject;
import com.kenshin.SyntheticAd.dao.ElectronicObject;
import com.kenshin.SyntheticAd.dao.ElectronicObject;
import com.kenshin.SyntheticAd.dto.Category;
import com.kenshin.SyntheticAd.dto.Electronic;
import com.kenshin.SyntheticAd.dto.Electronic;

@Api(name = "electronic", version = "v1")
public class ElectronicObjectManager {
//	@ApiMethod(name = "electronics")
//	public ArrayList<Electronic> getAll(@Named("offset") String offset)
//			throws Exception {
//		ArrayList<Electronic> datas = null;
//		try {
//			Database database = new Database();
//			Connection connection = database.getConnect();
//			ElectronicObject object = new ElectronicObject();
//			datas = object.getAll(connection, offset);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return datas;
//	}

	@ApiMethod(name = "electronic")
	public Electronic getElectronic(@Named("id") String id) throws Exception {
		Electronic electronic = null;
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			ElectronicObject object = new ElectronicObject();
			electronic = object.getElectronic(con, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return electronic;
	}

	@ApiMethod(name = "electronicByCategoryAndLocation")
	public ArrayList<Electronic> getVihicleByCategoryAndLocation(
			@Named("category_id") String category_id,
			@Named("location_id") String location_id,
			@Named("type") String type, @Named("offset") @Nullable String offset)
			throws Exception {
		ArrayList<Electronic> datas = null;
		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			ElectronicObject object = new ElectronicObject();
			datas = object.getByLocationAndCategory(connection, category_id,
					location_id, type, offset);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return datas;
	}

	@ApiMethod(name = "electronicByDistance")
	public ArrayList<Electronic> getElectronicByDistance(
			@Named("category_id") @Nullable String category_id,
			@Named("distance") @Nullable Double distance,
			@Named("offset") @Nullable int offset,
			@Named("lat") @Nullable Double lat,
			@Named("lon") @Nullable Double lon) throws Exception {
		ArrayList<Electronic> datas = null;
		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			ElectronicObject object = new ElectronicObject();
			datas = object.getByDistance(connection, category_id, lat, lon,
					distance, offset);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return datas;
	}

	@ApiMethod(name = "electroniccreate")
	public Electronic insertElectronic(Electronic electronic,
			@Named("password") @Nullable String password) throws Exception {
		Electronic nElectronic = new Electronic();
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			ElectronicObject object = new ElectronicObject();
			nElectronic = object.insertElectronic(con, electronic, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nElectronic;
	}

	@ApiMethod(name = "electronicupdate")
	public Electronic updateViElectronic(Electronic electronic) throws Exception {
		Electronic nElectronic = new Electronic();
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			ElectronicObject object = new ElectronicObject();
			nElectronic = object.updateElectronic(con, electronic);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nElectronic;
	}

	@ApiMethod(name = "electronicdelete")
	public void deleteElectronic(@Named("id") String id) throws Exception {
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			ElectronicObject object = new ElectronicObject();
			object.deleteElectronic(con, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@ApiMethod(name = "increaseCareNum", path="electronicInCreaseCareNum")
	public Electronic inCreaseCareNum(@Named("category_id") String category_id,
			@Named("id") String id, @Named("user_id") @Nullable String user_id,
			@Named("password") @Nullable String password) {
		Database database = new Database();
		Electronic n_Electronic = new Electronic();
		try {
			Connection con = database.getConnect();
			ElectronicObject object = new ElectronicObject();
			n_Electronic.setCare_num("" + object.increaseCareNum(con, category_id, id, user_id, password));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_Electronic;
	}

	@ApiMethod(name = "decreaseCareNum", path="electronicDeCreaseCareNum")
	public Electronic deCreaseCareNum(@Named("category_id") String category_id,
			@Named("id") String id, @Named("user_id") @Nullable String user_id,
			@Named("password") @Nullable String password) {
		Database database = new Database();
		Electronic n_Electronic = new Electronic();
		System.out.println(user_id + " pp" + password);
		try {
			Connection con = database.getConnect();
			ElectronicObject object = new ElectronicObject();
			n_Electronic.setCare_num("" + object.decreaseCareNum(con, category_id, id, user_id, password));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_Electronic;
	}
	
	@ApiMethod(name = "electronicByKeyword")
	public ArrayList<Electronic> getElectronicByKeyword(@Named("category_id") String category_id,
			@Named("keyword") @Nullable String keyword,
			@Named("location_id") @Nullable String location_id,
			@Named("type") @Nullable String type) {
		ArrayList<Electronic> datas = new ArrayList<Electronic>();

		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			ElectronicObject object = new ElectronicObject();
			datas = object.getElectronicByKeyWord(connection, category_id, keyword, location_id,
					type);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return datas;
	}
}
