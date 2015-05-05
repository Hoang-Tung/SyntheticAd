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

@Api(name = "service", version = "v1")
public class ServiceObjectManager {

	@ApiMethod(name = "getservice")
	public ArrayList<Service> getServiceLocationAndCategory(
			@Named("category_id") String category_id,
			@Named("location_id") String location_id,
			@Named("type") String type, @Named("offset") String offset)
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

}
