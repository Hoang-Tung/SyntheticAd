package com.kenshin.SyntheticAd.database;

import java.sql.Connection;
import java.sql.DriverManager;

import com.google.appengine.api.rdbms.AppEngineDriver;
import com.google.appengine.api.utils.SystemProperty;

public class Database {
	String url = null;

	Connection con = null;

	public Connection getConnect() {

		try {
			if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
				// Load the class that provides the new "jdbc:google:mysql://"
				// prefix.
				Class.forName("com.mysql.jdbc.GoogleDriver");
				url = "jdbc:google:mysql://even-envoy-89503:testcraighslist/testcraighslist";
			} else {
				// Local MySQL instance to use during development.
				DriverManager.registerDriver(new AppEngineDriver());
				url = "jdbc:google:rdbms://127.0.0.1:3306/testcraighslist";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println(url);
		
		try {
			con = DriverManager.getConnection(url, "root", "ruletheworld");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
