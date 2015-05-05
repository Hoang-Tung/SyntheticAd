package com.kenshin.SyntheticAd.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.kenshin.SyntheticAd.database.Database;
import com.kenshin.SyntheticAd.dao.CategoryObject;
import com.kenshin.SyntheticAd.dao.VehicleObject;
import com.kenshin.SyntheticAd.dto.Category;
import com.kenshin.SyntheticAd.dto.Vehicle;

@Api(name = "vehicle", version = "v1")
public class VehicleObjectManager {
	@ApiMethod(name = "vehicles")
	public ArrayList<Vehicle> getAll(@Named("offset") String offset)
			throws Exception {
		ArrayList<Vehicle> datas = null;
		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			VehicleObject object = new VehicleObject();
			datas = object.getAll(connection, offset);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return datas;
	}

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
}
