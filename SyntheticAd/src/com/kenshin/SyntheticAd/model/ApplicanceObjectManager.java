package com.kenshin.SyntheticAd.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.kenshin.SyntheticAd.database.Database;
import com.kenshin.SyntheticAd.dao.CategoryObject;
import com.kenshin.SyntheticAd.dao.ApplicanceObject;
import com.kenshin.SyntheticAd.dao.ApplicanceObject;
import com.kenshin.SyntheticAd.dto.Category;
import com.kenshin.SyntheticAd.dto.Applicance;
import com.kenshin.SyntheticAd.dto.Applicance;

@Api(name = "applicance", version = "v1")
public class ApplicanceObjectManager {
//	@ApiMethod(name = "applicances")
//	public ArrayList<Applicance> getAll(@Named("offset") String offset)
//			throws Exception {
//		ArrayList<Applicance> datas = null;
//		try {
//			Database database = new Database();
//			Connection connection = database.getConnect();
//			ApplicanceObject object = new ApplicanceObject();
//			datas = object.getAll(connection, offset);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return datas;
//	}

	@ApiMethod(name = "applicance")
	public Applicance getApplicance(@Named("id") String id) throws Exception {
		Applicance applicance = null;
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			ApplicanceObject object = new ApplicanceObject();
			applicance = object.getApplicance(con, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return applicance;
	}

	@ApiMethod(name = "applicanceByCategoryAndLocation")
	public ArrayList<Applicance> getVihicleByCategoryAndLocation(
			@Named("category_id") String category_id,
			@Named("location_id") String location_id,
			@Named("type") String type, @Named("offset") @Nullable String offset)
			throws Exception {
		ArrayList<Applicance> datas = null;
		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			ApplicanceObject object = new ApplicanceObject();
			datas = object.getByLocationAndCategory(connection, category_id,
					location_id, type, offset);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return datas;
	}

	@ApiMethod(name = "applicanceByDistance")
	public ArrayList<Applicance> getApplicanceByDistance(
			@Named("category_id") @Nullable String category_id,
			@Named("distance") @Nullable Double distance,
			@Named("offset") @Nullable int offset,
			@Named("lat") @Nullable Double lat,
			@Named("lon") @Nullable Double lon) throws Exception {
		ArrayList<Applicance> datas = null;
		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			ApplicanceObject object = new ApplicanceObject();
			datas = object.getByDistance(connection, category_id, lat, lon,
					distance, offset);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return datas;
	}

	@ApiMethod(name = "applicancecreate")
	public Applicance insertApplicance(Applicance applicance,
			@Named("password") @Nullable String password) throws Exception {
		Applicance nApplicance = new Applicance();
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			ApplicanceObject object = new ApplicanceObject();
			nApplicance = object.insertApplicance(con, applicance, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nApplicance;
	}

	@ApiMethod(name = "applicanceupdate")
	public Applicance updateViApplicance(Applicance applicance) throws Exception {
		Applicance nApplicance = new Applicance();
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			ApplicanceObject object = new ApplicanceObject();
			nApplicance = object.updateApplicance(con, applicance);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nApplicance;
	}

	@ApiMethod(name = "applicancedelete")
	public void deleteApplicance(@Named("id") String id) throws Exception {
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			ApplicanceObject object = new ApplicanceObject();
			object.deleteApplicance(con, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@ApiMethod(name = "increaseCareNum", path="applicanceInCreaseCareNum")
	public Applicance inCreaseCareNum(@Named("category_id") String category_id,
			@Named("id") String id, @Named("user_id") @Nullable String user_id,
			@Named("password") @Nullable String password) {
		Database database = new Database();
		Applicance n_Applicance = new Applicance();
		try {
			Connection con = database.getConnect();
			ApplicanceObject object = new ApplicanceObject();
			n_Applicance.setCare_num("" + object.increaseCareNum(con, category_id, id, user_id, password));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_Applicance;
	}

	@ApiMethod(name = "decreaseCareNum", path="applicanceDeCreaseCareNum")
	public Applicance deCreaseCareNum(@Named("category_id") String category_id,
			@Named("id") String id, @Named("user_id") @Nullable String user_id,
			@Named("password") @Nullable String password) {
		Database database = new Database();
		Applicance n_Applicance = new Applicance();
		System.out.println(user_id + " pp" + password);
		try {
			Connection con = database.getConnect();
			ApplicanceObject object = new ApplicanceObject();
			n_Applicance.setCare_num("" + object.decreaseCareNum(con, category_id, id, user_id, password));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_Applicance;
	}
	
	@ApiMethod(name = "applicanceByKeyword")
	public ArrayList<Applicance> getApplicanceByKeyword(@Named("category_id") String category_id,
			@Named("keyword") @Nullable String keyword,
			@Named("location_id") @Nullable String location_id,
			@Named("type") @Nullable String type) {
		ArrayList<Applicance> datas = new ArrayList<Applicance>();

		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			ApplicanceObject object = new ApplicanceObject();
			datas = object.getApplicanceByKeyWord(connection, category_id, keyword, location_id,
					type);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return datas;
	}
}
