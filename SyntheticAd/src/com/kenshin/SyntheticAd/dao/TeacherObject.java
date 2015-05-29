package com.kenshin.SyntheticAd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.google.appengine.api.rdbms.AppEngineDriver;
import com.google.appengine.api.utils.SystemProperty;
import com.google.appengine.tools.util.Logging;
import com.kenshin.SyntheticAd.database.Database;
import com.kenshin.SyntheticAd.dto.Teacher;
import com.kenshin.SyntheticAd.dto.Job;

public class TeacherObject extends JobObject {
	
	public Teacher getTeacherById(Connection connection, String post_id) throws Exception {
		Teacher n_Teacher = new Teacher();
		Job n_Job = new Job();
		
		n_Job = getJob(connection, post_id);
		n_Teacher.setMaid(n_Job);
		
		Database database = new Database();
		Connection cont = database.getConnect();
		
		try {
			PreparedStatement ps = cont.prepareStatement("SELECT * FROM testcraighslist.teacher WHERE teacher.post_id = ?;");
			ps.setString(1, post_id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				n_Teacher.setSubject_id(rs.getString("subject_id"));
				n_Teacher.setGrade(rs.getString("grade_type"));
				
			}
			
			return n_Teacher;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (connection != null)
				connection.close();
		}
		
		return n_Teacher;
	}

	public ArrayList<Teacher> getTeacherByCategoryAndLocation(Connection connection,
			String category_id, String location_id, String type, String offset)
			throws Exception {
		ArrayList<Job> datas = new ArrayList<Job>();
		ArrayList<Teacher> teacher_datas = new ArrayList<Teacher>();

		datas = this.getJobByCategoryAndLocation(connection, category_id,
				location_id, type, offset);

		Database database = new Database();
		Connection cont = database.getConnect();

		for (int i = 0; i < datas.size(); i++) {
			Teacher n_teacher = new Teacher();

			n_teacher.setId("" +datas.get(i).getId());
			n_teacher.setTitle(datas.get(i).getTitle());
			n_teacher.setDescription(datas.get(i).getDescription());
			n_teacher.setPrice("" + datas.get(i).getPrice());
			n_teacher.setCategory_id("" +datas.get(i).getCategory_id());
			n_teacher.setAddress(datas.get(i).getAddress());
			n_teacher.setPass(datas.get(i).getPass());
			n_teacher.setPhone_num(datas.get(i).getPhone_num());
			n_teacher.setLocation_id("" +datas.get(i).getLocation_id());
			n_teacher.setImageUrl(datas.get(i).getImageUrl());
			n_teacher.setLat("" +datas.get(i).getLat());
			n_teacher.setLon("" +datas.get(i).getLon());
			n_teacher.setUpdated_at(datas.get(i).getUpdated_at());
			n_teacher.setCreated_at(datas.get(i).getCreated_at());
			n_teacher.setCondition("" + datas.get(i).getCondition());
			n_teacher.setType("" +datas.get(i).getType());
			n_teacher.setUser_id("" +datas.get(i).getUser_id());
			n_teacher.setCare_num("" +datas.get(i).getCare_num());

			try {
				PreparedStatement ps = cont
						.prepareStatement("SELECT * FROM testcraighslist.teacher WHERE teacher.post_id = ?;");

				ps.setLong(1, datas.get(i).getId());

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					n_teacher.setTeacher_id(rs.getString("id"));
					n_teacher.setSubject_id(rs.getString("subject_id"));
					n_teacher.setGrade(rs.getString("grade_type"));
					
				}

			} catch (Exception e) {
				// TODO: handle exception
				throw e;
			}

			teacher_datas.add(n_teacher);
		}

		cont.close();
		return teacher_datas;
	}

	public Teacher createTeacher(Connection connection, Teacher teacher, String password) {
		Teacher n_Teacher = new Teacher();
		Job p_Job = new Job();

		try {

			PreparedStatement preps = connection
					.prepareStatement("SELECT * FROM testcraighslist.user WHERE user.id = ? AND user.password = ?;");
			preps.setLong(1, teacher.getUser_id());
			preps.setString(2, password);

			ResultSet rs = preps.executeQuery();

			if (!rs.next()) {
				return null;
			}
			p_Job = createJob(connection, teacher, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Database database = new Database();
		try {
			Connection con = database.getConnect();

			PreparedStatement ps = con
					.prepareStatement("INSERT INTO testcraighslist.teacher (`category_id`, `post_id`, `subject_id`, `grade_type`) VALUES (?, ?, ?, ?);");
			ps.setLong(1, teacher.getCategory_id());
			ps.setLong(2, p_Job.getId());
			ps.setLong(3, (long) teacher.getSubject_id());
			
			ps.setString(4, "" +teacher.getGrade());



			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_Teacher;
	}

	public boolean deleteTeacher(Connection connection, String id)
			throws Exception {

		deleteJob(connection, id);

		try {
			PreparedStatement ps = connection
					.prepareStatement("DELETE FROM `testcraighslist`.`teacher` WHERE `post_id`= ? ;");
			ps.setLong(1, Long.parseLong(id));

			System.out.println(ps.executeUpdate());

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (connection != null)
				connection.close();
		}

		return true;
	}

	public Teacher updateTeacher(Connection connection, Teacher teacher)
			throws Exception {

		Job n_Job = new Job();
		n_Job = teacher.createJob();

		updateJob(connection, n_Job);

		try {
			
			String queryToJob = "UPDATE `testcraighslist`.`teacher` SET ";
			StringBuilder build = new StringBuilder(queryToJob);

			if (teacher.getTitle() != null) {
				build.append("`title`= '" + teacher.getTitle() + "',");
			}

			
			build.deleteCharAt(build.length() - 1);

			build.append("WHERE `post_id` = '" + teacher.getPost_id() + "';");

			System.out.println(build.toString());

			PreparedStatement ps = connection
					.prepareStatement(build.toString());
			System.out.println(ps.executeUpdate());

			String queryToTitle = "UPDATE `testcraighslist`.`title` SET ";
			StringBuilder build1 = new StringBuilder(queryToTitle);

			if (teacher.getTitle() != null) {
				build1.append("`title`= '" + teacher.getTitle() + "',");
			}
			if (teacher.getType() != 0) {
				build1.append(" `type` = '" + teacher.getType() + "',");
			}

			if (teacher.getLocation_id() != 0) {
				build1.append(" `location_id` = '" + teacher.getLocation_id()
						+ "',");
			}

			build1.deleteCharAt(build.length() - 1);

			build1.append("WHERE `post_id` = '" + teacher.getPost_id()
					+ "AND `category_id`= '" + teacher.getCategory_id() + "';");

			PreparedStatement ps1 = connection.prepareStatement(build1
					.toString());

			System.out.println(ps1.executeUpdate());

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (connection != null)
				connection.close();
		}

		return teacher;
	}
	
	
	
}
