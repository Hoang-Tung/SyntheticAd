package com.kenshin.SyntheticAd.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.kenshin.SyntheticAd.database.Database;
import com.kenshin.SyntheticAd.dao.CategoryObject;
import com.kenshin.SyntheticAd.dao.CommunityObject;
import com.kenshin.SyntheticAd.dao.CommunityObject;
import com.kenshin.SyntheticAd.dto.Category;
import com.kenshin.SyntheticAd.dto.Community;
import com.kenshin.SyntheticAd.dto.Community;

@Api(name = "community", version = "v1")
public class CommunityObjectManager {
//	@ApiMethod(name = "communitys")
//	public ArrayList<Community> getAll(@Named("offset") String offset)
//			throws Exception {
//		ArrayList<Community> datas = null;
//		try {
//			Database database = new Database();
//			Connection connection = database.getConnect();
//			CommunityObject object = new CommunityObject();
//			datas = object.getAll(connection, offset);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return datas;
//	}

	@ApiMethod(name = "community")
	public Community getCommunity(@Named("id") String id) throws Exception {
		Community community = null;
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			CommunityObject object = new CommunityObject();
			community = object.getCommunity(con, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return community;
	}

	@ApiMethod(name = "communityByCategoryAndLocation")
	public ArrayList<Community> getVihicleByCategoryAndLocation(
			@Named("category_id") String category_id,
			@Named("location_id") String location_id,
			@Named("type") String type, @Named("offset") @Nullable String offset)
			throws Exception {
		ArrayList<Community> datas = null;
		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			CommunityObject object = new CommunityObject();
			datas = object.getByLocationAndCategory(connection, category_id,
					location_id, type, offset);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return datas;
	}

	@ApiMethod(name = "communityByDistance")
	public ArrayList<Community> getCommunityByDistance(
			@Named("category_id") @Nullable String category_id,
			@Named("distance") @Nullable Double distance,
			@Named("offset") @Nullable int offset,
			@Named("lat") @Nullable Double lat,
			@Named("lon") @Nullable Double lon) throws Exception {
		ArrayList<Community> datas = null;
		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			CommunityObject object = new CommunityObject();
			datas = object.getByDistance(connection, category_id, lat, lon,
					distance, offset);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return datas;
	}

	@ApiMethod(name = "communitycreate")
	public Community insertCommunity(Community community,
			@Named("password") @Nullable String password) throws Exception {
		Community nCommunity = new Community();
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			CommunityObject object = new CommunityObject();
			nCommunity = object.insertCommunity(con, community, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nCommunity;
	}

	@ApiMethod(name = "communityupdate")
	public Community updateViCommunity(Community community) throws Exception {
		Community nCommunity = new Community();
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			CommunityObject object = new CommunityObject();
			nCommunity = object.updateCommunity(con, community);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nCommunity;
	}

	@ApiMethod(name = "communitydelete")
	public void deleteCommunity(@Named("id") String id) throws Exception {
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			CommunityObject object = new CommunityObject();
			object.deleteCommunity(con, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@ApiMethod(name = "increaseCareNum", path="communityInCreaseCareNum")
	public Community inCreaseCareNum(@Named("category_id") String category_id,
			@Named("id") String id, @Named("user_id") @Nullable String user_id,
			@Named("password") @Nullable String password) {
		Database database = new Database();
		Community n_Community = new Community();
		try {
			Connection con = database.getConnect();
			CommunityObject object = new CommunityObject();
			n_Community.setCare_num("" + object.increaseCareNum(con, category_id, id, user_id, password));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_Community;
	}

	@ApiMethod(name = "decreaseCareNum", path="communityDeCreaseCareNum")
	public Community deCreaseCareNum(@Named("category_id") String category_id,
			@Named("id") String id, @Named("user_id") @Nullable String user_id,
			@Named("password") @Nullable String password) {
		Database database = new Database();
		Community n_Community = new Community();
		System.out.println(user_id + " pp" + password);
		try {
			Connection con = database.getConnect();
			CommunityObject object = new CommunityObject();
			n_Community.setCare_num("" + object.decreaseCareNum(con, category_id, id, user_id, password));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_Community;
	}
	
	@ApiMethod(name = "communityByKeyword")
	public ArrayList<Community> getCommunityByKeyword(@Named("category_id") String category_id,
			@Named("keyword") @Nullable String keyword,
			@Named("location_id") @Nullable String location_id,
			@Named("type") @Nullable String type) {
		ArrayList<Community> datas = new ArrayList<Community>();

		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			CommunityObject object = new CommunityObject();
			datas = object.getCommunityByKeyWord(connection, category_id, keyword, location_id,
					type);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return datas;
	}
}
