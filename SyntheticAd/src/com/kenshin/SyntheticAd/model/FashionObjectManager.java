package com.kenshin.SyntheticAd.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.kenshin.SyntheticAd.database.Database;
import com.kenshin.SyntheticAd.dao.CategoryObject;
import com.kenshin.SyntheticAd.dao.FashionObject;
import com.kenshin.SyntheticAd.dao.FashionObject;
import com.kenshin.SyntheticAd.dto.Category;
import com.kenshin.SyntheticAd.dto.Fashion;
import com.kenshin.SyntheticAd.dto.Fashion;

@Api(name = "fashion", version = "v1")
public class FashionObjectManager {
//	@ApiMethod(name = "fashions")
//	public ArrayList<Fashion> getAll(@Named("offset") String offset)
//			throws Exception {
//		ArrayList<Fashion> datas = null;
//		try {
//			Database database = new Database();
//			Connection connection = database.getConnect();
//			FashionObject object = new FashionObject();
//			datas = object.getAll(connection, offset);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return datas;
//	}

	@ApiMethod(name = "fashion")
	public Fashion getFashion(@Named("id") String id) throws Exception {
		Fashion fashion = null;
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			FashionObject object = new FashionObject();
			fashion = object.getFashion(con, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return fashion;
	}

	@ApiMethod(name = "fashionByCategoryAndLocation")
	public ArrayList<Fashion> getVihicleByCategoryAndLocation(
			@Named("category_id") String category_id,
			@Named("location_id") String location_id,
			@Named("type") String type, @Named("offset") @Nullable String offset)
			throws Exception {
		ArrayList<Fashion> datas = null;
		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			FashionObject object = new FashionObject();
			datas = object.getByLocationAndCategory(connection, category_id,
					location_id, type, offset);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return datas;
	}

	@ApiMethod(name = "fashionByDistance")
	public ArrayList<Fashion> getFashionByDistance(
			@Named("category_id") @Nullable String category_id,
			@Named("distance") @Nullable Double distance,
			@Named("offset") @Nullable int offset,
			@Named("lat") @Nullable Double lat,
			@Named("lon") @Nullable Double lon) throws Exception {
		ArrayList<Fashion> datas = null;
		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			FashionObject object = new FashionObject();
			datas = object.getByDistance(connection, category_id, lat, lon,
					distance, offset);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return datas;
	}

	@ApiMethod(name = "fashioncreate")
	public Fashion insertFashion(Fashion fashion,
			@Named("password") @Nullable String password) throws Exception {
		Fashion nFashion = new Fashion();
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			FashionObject object = new FashionObject();
			nFashion = object.insertFashion(con, fashion, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nFashion;
	}

	@ApiMethod(name = "fashionupdate")
	public Fashion updateViFashion(Fashion fashion) throws Exception {
		Fashion nFashion = new Fashion();
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			FashionObject object = new FashionObject();
			nFashion = object.updateFashion(con, fashion);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nFashion;
	}

	@ApiMethod(name = "fashiondelete")
	public void deleteFashion(@Named("id") String id) throws Exception {
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			FashionObject object = new FashionObject();
			object.deleteFashion(con, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@ApiMethod(name = "increaseCareNum", path="fashionInCreaseCareNum")
	public Fashion inCreaseCareNum(@Named("category_id") String category_id,
			@Named("id") String id, @Named("user_id") @Nullable String user_id,
			@Named("password") @Nullable String password) {
		Database database = new Database();
		Fashion n_Fashion = new Fashion();
		try {
			Connection con = database.getConnect();
			FashionObject object = new FashionObject();
			n_Fashion.setCare_num("" + object.increaseCareNum(con, category_id, id, user_id, password));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_Fashion;
	}

	@ApiMethod(name = "decreaseCareNum", path="fashionDeCreaseCareNum")
	public Fashion deCreaseCareNum(@Named("category_id") String category_id,
			@Named("id") String id, @Named("user_id") @Nullable String user_id,
			@Named("password") @Nullable String password) {
		Database database = new Database();
		Fashion n_Fashion = new Fashion();
		System.out.println(user_id + " pp" + password);
		try {
			Connection con = database.getConnect();
			FashionObject object = new FashionObject();
			n_Fashion.setCare_num("" + object.decreaseCareNum(con, category_id, id, user_id, password));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_Fashion;
	}
	
	@ApiMethod(name = "fashionByKeyword")
	public ArrayList<Fashion> getFashionByKeyword(@Named("category_id") String category_id,
			@Named("keyword") @Nullable String keyword,
			@Named("location_id") @Nullable String location_id,
			@Named("type") @Nullable String type) {
		ArrayList<Fashion> datas = new ArrayList<Fashion>();

		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			FashionObject object = new FashionObject();
			datas = object.getFashionByKeyWord(connection, category_id, keyword, location_id,
					type);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return datas;
	}
}
