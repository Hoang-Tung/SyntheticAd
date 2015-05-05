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
import com.kenshin.SyntheticAd.dto.Maid;
import com.kenshin.SyntheticAd.dto.Job;

public class MaidObject extends JobObject {

	public ArrayList<Maid> getMaidByCategoryAndLocation(Connection connection,
			String category_id, String location_id, String type, String offset)
			throws Exception {
		ArrayList<Job> datas = new ArrayList<Job>();
		ArrayList<Maid> maid_datas = new ArrayList<Maid>();

		datas = this.getJobByCategoryAndLocation(connection, category_id,
				location_id, type, offset);

		Database database = new Database();
		Connection cont = database.getConnect();

		for (int i = 0; i < datas.size(); i++) {
			Maid n_maid = new Maid();

			n_maid.setId(datas.get(i).getId());
			n_maid.setTitle(datas.get(i).getTitle());
			n_maid.setDescription(datas.get(i).getDescription());
			n_maid.setPrice(datas.get(i).getPrice());
			n_maid.setCategory_id(datas.get(i).getCategory_id());
			n_maid.setAddress(datas.get(i).getAddress());
			n_maid.setPass(datas.get(i).getPass());
			n_maid.setPhone_num(datas.get(i).getPhone_num());
			n_maid.setLocation_id(datas.get(i).getLocation_id());
			n_maid.setLat(datas.get(i).getLat());
			n_maid.setLon(datas.get(i).getLon());
			n_maid.setUpdated_at(datas.get(i).getUpdated_at());
			n_maid.setCreated_at(datas.get(i).getCreated_at());
			n_maid.setCondition(datas.get(i).getCondition());
			n_maid.setType(datas.get(i).getType());
			n_maid.setUser_id(datas.get(i).getUser_id());
			n_maid.setCare_num(datas.get(i).getCare_num());

			try {
				PreparedStatement ps = cont
						.prepareStatement("SELECT * FROM testcraighslist.maid WHERE maid.post_id = ?;");

				ps.setLong(1, datas.get(i).getId());

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					n_maid.setMaid_id(rs.getString("id"));
					n_maid.setArea(rs.getString("area"));
					System.out.println(rs.getString("time_start"));
					n_maid.setStart_time(rs.getString("time_start"));
					System.out.println(rs.getString("time_end"));
					n_maid.setEnd_time(rs.getString("time_end"));
				}

			} catch (Exception e) {
				// TODO: handle exception
				throw e;
			}

			maid_datas.add(n_maid);
		}

		cont.close();
		return maid_datas;
	}

	public Maid createMaid(Connection connection, Maid maid, String password) {
		Maid n_Maid = new Maid();
		Job p_Job = new Job();

		try {

			PreparedStatement preps = connection
					.prepareStatement("SELECT * FROM testcraighslist.user WHERE user.id = ? AND user.password = ?;");
			preps.setLong(1, maid.getUser_id());
			preps.setString(2, password);

			ResultSet rs = preps.executeQuery();

			if (!rs.next()) {
				return null;
			}
			p_Job = createJob(connection, maid, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Database database = new Database();
		try {
			Connection con = database.getConnect();

			PreparedStatement ps = con
					.prepareStatement("INSERT INTO testcraighslist.maid (`category_id`, `post_id`, `area`, `time_start`, `time_end`) VALUES (?, ?, ?, ?, ?);");
			ps.setLong(1, maid.getCategory_id());
			ps.setLong(2, p_Job.getId());
			ps.setLong(3, (long) maid.getArea());

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");

			ps.setString(4, simpleDateFormat.format(maid.getStart_time()));

			ps.setString(5, simpleDateFormat.format(maid.getEnd_time()));

			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_Maid;
	}

	public boolean deleteMaid(Connection connection, String id)
			throws Exception {

		deleteJob(connection, id);

		try {
			PreparedStatement ps = connection
					.prepareStatement("DELETE FROM `testcraighslist`.`maid` WHERE `post_id`= ? ;");
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

	public Maid updateMaid(Connection connection, Maid maid)
			throws Exception {

		Job n_Job = new Job();
		n_Job = maid.createJob();

		updateJob(connection, n_Job);

		try {
			
			String queryToJob = "UPDATE `testcraighslist`.`maid` SET ";
			StringBuilder build = new StringBuilder(queryToJob);

			if (maid.getTitle() != null) {
				build.append("`title`= '" + maid.getTitle() + "',");
			}

			if (maid.getArea() != 0) {
				build.append(" `area` = '" + maid.getArea() + "',");
			}

			build.deleteCharAt(build.length() - 1);

			build.append("WHERE `post_id` = '" + maid.getPost_id() + "';");

			System.out.println(build.toString());

			PreparedStatement ps = connection
					.prepareStatement(build.toString());
			System.out.println(ps.executeUpdate());

			String queryToTitle = "UPDATE `testcraighslist`.`title` SET ";
			StringBuilder build1 = new StringBuilder(queryToTitle);

			if (maid.getTitle() != null) {
				build1.append("`title`= '" + maid.getTitle() + "',");
			}
			if (maid.getType() != 0) {
				build1.append(" `type` = '" + maid.getType() + "',");
			}

			if (maid.getLocation_id() != 0) {
				build1.append(" `location_id` = '" + maid.getLocation_id()
						+ "',");
			}

			build1.deleteCharAt(build.length() - 1);

			build1.append("WHERE `post_id` = '" + maid.getPost_id()
					+ "AND `category_id`= '" + maid.getCategory_id() + "';");

			PreparedStatement ps1 = connection.prepareStatement(build1
					.toString());

			System.out.println(ps1.executeUpdate());

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (connection != null)
				connection.close();
		}

		return maid;
	}

}
