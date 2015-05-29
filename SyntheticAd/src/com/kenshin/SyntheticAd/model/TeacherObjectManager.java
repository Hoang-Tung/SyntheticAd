package com.kenshin.SyntheticAd.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.kenshin.SyntheticAd.dao.JobObject;
import com.kenshin.SyntheticAd.dao.TeacherObject;
import com.kenshin.SyntheticAd.database.Database;
import com.kenshin.SyntheticAd.dto.Teacher;

@Api(name = "teacher", version = "v1")
public class TeacherObjectManager {
	@ApiMethod(name="getteacherbyid")
	public Teacher getTeacherByID(@Named("post_id") String post_id) throws Exception {
		Teacher n_Teacher = new Teacher();
		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			TeacherObject object = new TeacherObject();
			n_Teacher = object.getTeacherById(connection, post_id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return n_Teacher;
	}
	
	@ApiMethod(name = "getteacherbylocationandcategory")
	public ArrayList<Teacher> getTeacherLocationAndCategory(
			@Named("category_id") String category_id,
			@Named("location_id") String location_id,
			@Named("type") String type, @Named("offset") @Nullable String offset)
			throws Exception {
		ArrayList<Teacher> datas = new ArrayList<Teacher>();

		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			TeacherObject object = new TeacherObject();
			datas = object.getTeacherByCategoryAndLocation(connection,
					category_id, location_id, type, offset);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return datas;
	}

	@ApiMethod(name = "teachercreate")
	public Teacher insertTeacher(Teacher teacher,
			@Named("password") @Nullable String password) throws Exception {
		Teacher n_teacher = new Teacher();

		Database database = new Database();
		try {
			Connection con = database.getConnect();
			TeacherObject object = new TeacherObject();
			n_teacher = object.createTeacher(con, teacher, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_teacher;
	}
	
	@ApiMethod(name="teacherupdate")
	public Teacher updateTeacher(Teacher teacher){
		Teacher nTeacher = new Teacher();
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			TeacherObject object = new TeacherObject();
			nTeacher = object.updateTeacher(con, teacher);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nTeacher;
	}
	
	@ApiMethod(name="teacherdelete")
	public void deleteTeacher(@Named("id") String id){
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			TeacherObject object = new TeacherObject();
			object.deleteTeacher(con, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@ApiMethod(name = "increaseCareNum", path="teacherInCreaseCareNum")
	public Teacher inCreaseCareNum(@Named("category_id") String category_id,
			@Named("id") String id, @Named("user_id") @Nullable String user_id,
			@Named("password") @Nullable String password) {
		Database database = new Database();
		Teacher n_Teacher = new Teacher();
		try {
			Connection con = database.getConnect();
			JobObject object = new JobObject();
			n_Teacher.setCare_num("" + object.increaseCareNum(con, category_id, id, user_id, password));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_Teacher;
	}

	@ApiMethod(name = "decreaseCareNum", path="teacherDeCreaseCareNum")
	public Teacher deCreaseCareNum(@Named("category_id") String category_id,
			@Named("id") String id, @Named("user_id") @Nullable String user_id,
			@Named("password") @Nullable String password) {
		Database database = new Database();
		Teacher n_Teacher = new Teacher();
		System.out.println(user_id + " pp" + password);
		try {
			Connection con = database.getConnect();
			JobObject object = new JobObject();
			n_Teacher.setCare_num("" + object.decreaseCareNum(con, category_id, id, user_id, password));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_Teacher;
	}
}
