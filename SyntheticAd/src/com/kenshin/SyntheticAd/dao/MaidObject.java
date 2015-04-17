package com.kenshin.SyntheticAd.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.kenshin.SyntheticAd.dto.Maid;
import com.kenshin.SyntheticAd.dto.Service;

public class MaidObject extends ServiceObject {

	public ArrayList<Maid> getByCategoryAndLocation(Connection connection,
			String category_id, String location_id, String type, String offset) throws Exception{
		ArrayList<Maid> datas = new ArrayList<Maid>();
		
		return datas;
	}
}
