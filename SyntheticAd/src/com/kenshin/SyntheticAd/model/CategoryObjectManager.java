package com.kenshin.SyntheticAd.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.kenshin.SyntheticAd.dao.CategoryObject;
import com.kenshin.SyntheticAd.database.Database;
import com.kenshin.SyntheticAd.dto.Category;

@Api(name="category",version="v1")
public class CategoryObjectManager {
	@ApiMethod(name="categories")
	public ArrayList<Category> getAll() throws Exception{
		ArrayList<Category> datas = null;
		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			CategoryObject object = new CategoryObject();
			datas = object.getAll(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return datas;
	}
	
	@ApiMethod(name="category")
	public Category getCategory(@Named("id") String id) throws Exception{
		Category cat = null;
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			CategoryObject object = new CategoryObject();
			cat = object.getCategory(con, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cat;
	}
	
	@ApiMethod(name="createCategory")
	public Category insertCategory(Category cat) throws Exception{
		Category nCategory = new Category();
		System.out.println(cat.getCategory_name());
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			CategoryObject object = new CategoryObject();
			nCategory = object.insertCategory(con, cat.getCategory_name());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nCategory;
	}
}
