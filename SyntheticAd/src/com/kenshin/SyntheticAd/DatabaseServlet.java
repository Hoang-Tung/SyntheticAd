package com.kenshin.SyntheticAd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import com.google.appengine.api.rdbms.AppEngineDriver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.appengine.api.utils.SystemProperty;

import com.kenshin.SyntheticAd.dao.CategoryObject;
import com.kenshin.SyntheticAd.dto.Category;
import com.kenshin.SyntheticAd.model.CategoryObjectManager;

public class DatabaseServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4208595877822554005L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;
		try {
			if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
				// Load the class that provides the new "jdbc:google:mysql://"
				// prefix.
				Class.forName("com.mysql.jdbc.GoogleDriver");
				url = "jdbc:google:mysql://even-envoy-89503:testcraighslist/testcraighslist";
			} else {
				// Local MySQL instance to use during development.
				// Class.forName("com.mysql.jdbc.Driver");
				DriverManager.registerDriver(new AppEngineDriver());
				url = "jdbc:google:rdbms://127.0.0.1:3306/testcraighslist";

				// Alternatively, connect to a Google Cloud SQL instance using:
				// jdbc:mysql://ip-address-of-google-cloud-sql-instance:3306/guestbook?user=root
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		try {
			Connection con = DriverManager.getConnection(url, "root",
					"ruletheworld");
			if (con != null) {

				resp.setContentType("text/json; charset=utf-8");
				resp.getWriter().println(getAllcategory());
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setContentType("text/plain; charset=utf-8");
			resp.getWriter().println("try harder. almost is never enough");
		}

	}

	public String getAllcategory() {
		String categories = null;
		try {
			ArrayList<Category> categoryData = null;
			CategoryObjectManager manager = new CategoryObjectManager();
			categoryData = manager.getAll();
			Gson gson = new Gson();
			categories = gson.toJson(categoryData);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return categories;
	}

}
