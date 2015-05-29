package com.kenshin.SyntheticAd.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.kenshin.SyntheticAd.dao.TeacherSubjectObject;
import com.kenshin.SyntheticAd.database.Database;
import com.kenshin.SyntheticAd.dto.TeacherSubject;

@Api(name="teachersubject",version="v1")
public class TeacherSubjectObjectManager {
	@ApiMethod(name="teachersubjects")
	public ArrayList<TeacherSubject> getAll() throws Exception{
		ArrayList<TeacherSubject> datas = null;
		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			TeacherSubjectObject object = new TeacherSubjectObject();
			datas = object.getAll(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return datas;
	}
}
