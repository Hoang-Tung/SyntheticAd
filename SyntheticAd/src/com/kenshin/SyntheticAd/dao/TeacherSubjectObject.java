package com.kenshin.SyntheticAd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kenshin.SyntheticAd.dto.TeacherSubject;

public class TeacherSubjectObject {
	public ArrayList<TeacherSubject> getAll(Connection connection) throws Exception{
		ArrayList<TeacherSubject> catDatas = new ArrayList<TeacherSubject>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM testcraighslist.teacher_subject ");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				TeacherSubject c = new TeacherSubject();
				c.setId(rs.getString("id"));
				c.setSubject_name(rs.getString("subject_name"));
				catDatas.add(c);
			}
			connection.close();
			return catDatas;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			if (connection != null) connection.close();
		}
	}
}
