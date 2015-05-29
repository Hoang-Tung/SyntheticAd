package com.kenshin.SyntheticAd.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.kenshin.SyntheticAd.dao.ServiceObject;
import com.kenshin.SyntheticAd.dao.VehicleObject;
import com.kenshin.SyntheticAd.database.Database;
import com.kenshin.SyntheticAd.dto.Maid;
import com.kenshin.SyntheticAd.dto.Service;
import com.kenshin.SyntheticAd.dto.Vehicle;

@Api(name = "service", version = "v1")
public class ServiceObjectManager {

	@ApiMethod(name = "getservice")
	public ArrayList<Service> getServiceLocationAndCategory(
			@Named("category_id") String category_id,
			@Named("location_id") String location_id,
			@Named("type") String type, @Named("offset") @Nullable String offset)
			throws Exception {
		ArrayList<Service> datas = new ArrayList<Service>();

		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			ServiceObject object = new ServiceObject();
			datas = object.getServiceByCategoryAndLocation(connection,
					category_id, location_id, type, offset);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return datas;
	}

	@ApiMethod(name="getservicebyid")
	public Service getService(@Named("id") String id) throws Exception{
		Service n_Service = new Service();
		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			ServiceObject object = new ServiceObject();
			n_Service = object.getService(connection, id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return n_Service;
	}
	
	@ApiMethod(name = "servicecreate", path="service")
	public Service createService(Service service,
			@Named("password") @Nullable String password) throws Exception {
		Service n_Service = new Service();

		Database database = new Database();
		try {
			Connection con = database.getConnect();
			ServiceObject object = new ServiceObject();
			n_Service = object.createService(con, service, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return n_Service;
	}
	
	@ApiMethod(name="servicedelete")
	public void deleteService(@Named("id") String id){
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			ServiceObject object = new ServiceObject();
			object.deleteService(con, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	@ApiMethod(name="updateservice")
	public Service updateService(Service service){
		Service n_Service = new Service();

		Database database = new Database();
		try {
			Connection con = database.getConnect();
			ServiceObject object = new ServiceObject();
			n_Service = object.updateService(con, service);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return n_Service;
	}
	
	@ApiMethod(name = "increaseCareNum", path="serviceInCreaseCareNum")
	public Service inCreaseCareNum(@Named("category_id") String category_id,
			@Named("id") String id, @Named("user_id") @Nullable String user_id,
			@Named("password") @Nullable String password) {
		Database database = new Database();
		Service n_Service = new Service();
		try {
			Connection con = database.getConnect();
			ServiceObject object = new ServiceObject();
			n_Service.setCare_num("" + object.increaseCareNum(con, category_id, id, user_id, password));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_Service;
	}

	@ApiMethod(name = "decreaseCareNum", path="serviceDeCreaseCareNum")
	public Service deCreaseCareNum(@Named("category_id") String category_id,
			@Named("id") String id, @Named("user_id") @Nullable String user_id,
			@Named("password") @Nullable String password) {
		Database database = new Database();
		Service n_Service = new Service();
		System.out.println(user_id + " pp" + password);
		try {
			Connection con = database.getConnect();
			ServiceObject object = new ServiceObject();
			n_Service.setCare_num("" + object.decreaseCareNum(con, category_id, id, user_id, password));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_Service;
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
