package com.kenshin.SyntheticAd.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.kenshin.SyntheticAd.database.Database;
import com.kenshin.SyntheticAd.dao.CategoryObject;
import com.kenshin.SyntheticAd.dao.VehicleObject;
import com.kenshin.SyntheticAd.dto.Category;
import com.kenshin.SyntheticAd.dto.Vehicle;
import com.kenshin.SyntheticAd.dto.Vehicle;

@Api(name = "vehicle", version = "v1")
public class VehicleObjectManager {
//	@ApiMethod(name = "vehicles")
//	public ArrayList<Vehicle> getAll(@Named("category_id") String category_id ,@Named("offset") @Nullable String offset)
//			throws Exception {
//		ArrayList<Vehicle> datas = null;
//		try {
//			Database database = new Database();
//			Connection connection = database.getConnect();
//			VehicleObject object = new VehicleObject();
//			datas = object.getAll(connection, offset);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return datas;
//	}

	@ApiMethod(name = "vehicle")
	public Vehicle getVehicle(@Named("id") String id) throws Exception {
		Vehicle vehicle = null;
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			VehicleObject object = new VehicleObject();
			vehicle = object.getVehicle(con, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return vehicle;
	}

	@ApiMethod(name = "vehicleByCategoryAndLocation")
	public ArrayList<Vehicle> getVihicleByCategoryAndLocation(
			@Named("category_id") String category_id,
			@Named("location_id") String location_id,
			@Named("type") String type, @Named("offset") @Nullable String offset)
			throws Exception {
		ArrayList<Vehicle> datas = null;
		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			VehicleObject object = new VehicleObject();
			datas = object.getByLocationAndCategory(connection, category_id,
					location_id, type, offset);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return datas;
	}

	@ApiMethod(name = "vehicleByDistance")
	public ArrayList<Vehicle> getVehicleByDistance(
			@Named("category_id") @Nullable String category_id,
			@Named("distance") @Nullable Double distance,
			@Named("offset") @Nullable int offset,
			@Named("lat") @Nullable Double lat,
			@Named("lon") @Nullable Double lon) throws Exception {
		ArrayList<Vehicle> datas = null;
		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			VehicleObject object = new VehicleObject();
			datas = object.getByDistance(connection, category_id, lat, lon,
					distance, offset);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return datas;
	}

	@ApiMethod(name = "vehiclecreate")
	public Vehicle insertVehicle(Vehicle vehicle,
			@Named("password") @Nullable String password) throws Exception {
		Vehicle nVehicle = new Vehicle();
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			VehicleObject object = new VehicleObject();
			nVehicle = object.insertVehicle(con, vehicle, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nVehicle;
	}

	@ApiMethod(name = "vehicleupdate")
	public Vehicle updateViVehicle(Vehicle vehicle) throws Exception {
		Vehicle nVehicle = new Vehicle();
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			VehicleObject object = new VehicleObject();
			nVehicle = object.updateVehicle(con, vehicle);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nVehicle;
	}

	@ApiMethod(name = "vehicledelete")
	public void deleteVehicle(@Named("id") String id) throws Exception {
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			VehicleObject object = new VehicleObject();
			object.deleteVehicle(con, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@ApiMethod(name = "increaseCareNum", path="vehicleInCreaseCareNum")
	public Vehicle inCreaseCareNum(@Named("category_id") String category_id,
			@Named("id") String id, @Named("user_id") @Nullable String user_id,
			@Named("password") @Nullable String password) {
		Database database = new Database();
		Vehicle n_Vehicle = new Vehicle();
		try {
			Connection con = database.getConnect();
			VehicleObject object = new VehicleObject();
			n_Vehicle.setCare_num("" + object.increaseCareNum(con, category_id, id, user_id, password));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_Vehicle;
	}

	@ApiMethod(name = "decreaseCareNum", path="vehicleDeCreaseCareNum")
	public Vehicle deCreaseCareNum(@Named("category_id") String category_id,
			@Named("id") String id, @Named("user_id") @Nullable String user_id,
			@Named("password") @Nullable String password) {
		Database database = new Database();
		Vehicle n_Vehicle = new Vehicle();
		System.out.println(user_id + " pp" + password);
		try {
			Connection con = database.getConnect();
			VehicleObject object = new VehicleObject();
			n_Vehicle.setCare_num("" + object.decreaseCareNum(con, category_id, id, user_id, password));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_Vehicle;
	}
	
	@ApiMethod(name = "vehicleByKeyword")
	public ArrayList<Vehicle> getVehicleByKeyword(@Named("category_id") String category_id,
			@Named("keyword") @Nullable String keyword,
			@Named("location_id") @Nullable String location_id,
			@Named("type") @Nullable String type) {
		ArrayList<Vehicle> datas = new ArrayList<Vehicle>();

		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			VehicleObject object = new VehicleObject();
			datas = object.getVehicleByKeyWord(connection, category_id, keyword, location_id,
					type);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return datas;
	}
}
