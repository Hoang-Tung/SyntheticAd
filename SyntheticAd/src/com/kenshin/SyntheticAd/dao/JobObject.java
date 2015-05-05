package com.kenshin.SyntheticAd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kenshin.SyntheticAd.dto.Job;
import com.kenshin.SyntheticAd.dto.Job;

public class JobObject {
	public ArrayList<Job> getAll(Connection connection) throws Exception {
		ArrayList<Job> datas = new ArrayList<Job>();
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM testcraighslist.job");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Job c = new Job();
				c.setId(rs.getString("id"));
				System.out.println(rs.getString("id"));

				c.setUser_id(rs.getString("user_id"));
				System.out.println(rs.getString("user_id"));

				c.setTitle(rs.getString("title"));
				System.out.println(rs.getString("title"));

				c.setCategory_id(rs.getString("category_id"));
				System.out.println(rs.getString("category_id"));

				c.setDescription(rs.getString("description"));
				System.out.println(rs.getString("description"));

				c.setType(rs.getString("type"));
				System.out.println(rs.getString("type"));

				c.setPrice(rs.getString("price"));
				System.out.println(rs.getString("price"));

				if (rs.getString("lon") != null) {
					c.setLon(rs.getString("lon"));
					System.out.println("lon " + rs.getString("lon"));
				}

				if (rs.getString("lat") != null) {
					c.setLat(rs.getString("lat"));
					System.out.println("lat " + rs.getString("lat"));
				}
				c.setLocation_id(rs.getString("location_id"));
				System.out.println(rs.getString("location_id"));

				if (rs.getString("image_url") != null) {
					c.setImageUrl(rs.getString("image_url"));
					System.out.println(rs.getString("image_url"));
				}

				if (rs.getString("condition") != null) {
					c.setCondition(rs.getString("condition"));
					System.out.println(rs.getString("condition"));
				}

				if (rs.getString("extend_type") != null) {
					c.setExtend_type(rs.getString("extend_type"));
				}

				c.setCare_num(rs.getString("care_num"));

				if (rs.getString("size") != null)
					c.setSize(rs.getString("size"));

				c.setCreated_at(rs.getString("created_at"));
				System.out.println(rs.getString("created_at"));

				c.setUpdated_at(rs.getString("updated_at"));
				System.out.println(rs.getString("updated_at"));

				if (rs.getString("pass") != null) {
					c.setPass(rs.getString("pass"));
				}

				c.setAddress(rs.getString("address"));
				if (rs.getString("phone_num") != null)
					c.setPhone_num(rs.getString("phone_num"));

				datas.add(c);
			}
			return datas;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			if (connection != null)
				connection.close();
		}

	}

	public ArrayList<Job> getJobByCategoryAndLocation(Connection connection,
			String category_id, String location, String type, String offset)
			throws Exception {
		ArrayList<Job> datas = new ArrayList<Job>();

		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM testcraighslist.job WHERE job.category_id = ? AND job.location_id = ? AND job.type = ? LIMIT 10 OFFSET ?;");
			ps.setLong(1, Long.parseLong(category_id));
			ps.setLong(2, Long.parseLong(location));
			ps.setLong(3, Long.parseLong(type));
			ps.setLong(4, Long.parseLong(offset));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Job c = new Job();
				c.setId(rs.getString("id"));
				System.out.println(rs.getString("id"));

				c.setUser_id(rs.getString("user_id"));
				System.out.println(rs.getString("user_id"));

				c.setTitle(rs.getString("title"));
				System.out.println(rs.getString("title"));

				c.setCategory_id(rs.getString("category_id"));
				System.out.println(rs.getString("category_id"));

				c.setDescription(rs.getString("description"));
				System.out.println(rs.getString("description"));

				c.setType(rs.getString("type"));
				System.out.println(rs.getString("type"));

				c.setPrice(rs.getString("price"));
				System.out.println(rs.getString("price"));

				if (rs.getString("lon") != null) {
					c.setLon(rs.getString("lon"));
					System.out.println("lon " + rs.getString("lon"));
				}

				if (rs.getString("lat") != null) {
					c.setLat(rs.getString("lat"));
					System.out.println("lat " + rs.getString("lat"));
				}
				c.setLocation_id(rs.getString("location_id"));
				System.out.println(rs.getString("location_id"));

				if (rs.getString("image_url") != null) {
					c.setImageUrl(rs.getString("image_url"));
					System.out.println(rs.getString("image_url"));
				}

				if (rs.getString("condition") != null) {
					c.setCondition(rs.getString("condition"));
					System.out.println(rs.getString("condition"));
				}

				if (rs.getString("extend_type") != null) {
					c.setExtend_type(rs.getString("extend_type"));
				}

				c.setCare_num(rs.getString("care_num"));

				if (rs.getString("size") != null)
					c.setSize(rs.getString("size"));

				c.setCreated_at(rs.getString("created_at"));
				System.out.println(rs.getString("created_at"));

				c.setUpdated_at(rs.getString("updated_at"));
				System.out.println(rs.getString("updated_at"));

				if (rs.getString("pass") != null) {
					c.setPass(rs.getString("pass"));
				}

				c.setAddress(rs.getString("address"));
				if (rs.getString("phone_num") != null)
					c.setPhone_num(rs.getString("phone_num"));

				datas.add(c);
			}
			return datas;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			if (connection != null)
				connection.close();
		}
	}

	public Job createJob(Connection connection, Job job) throws Exception {
		Job n_Job = new Job();

		try {
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO `testcraighslist`.`job` (`category_id`,"
							+ " `title`, `description`, `price`, `condition`, `user_id`, `type`, `location_id`, `pass`, `image_url`, `address`, `phone_num`) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setLong(1, job.getCategory_id());
			ps.setString(2, job.getTitle());
			ps.setString(3, job.getDescription());
			ps.setLong(4, (long) job.getPrice());
			ps.setLong(5, job.getCondition());
			ps.setLong(6, job.getUser_id());
			ps.setLong(7, job.getType());
			ps.setLong(8, job.getLocation_id());
			ps.setString(9, job.getPass());
			ps.setString(10, job.getImageUrl());
			ps.setString(11, job.getAddress());
			if (job.getPhone_num() != null) {
				ps.setString(12, job.getPhone_num());
			} else {
				ps.setString(12, "");
			}

			System.out.println(ps.executeUpdate());

			try {
				ResultSet result = ps.getGeneratedKeys();

				if (result.next()) {

					PreparedStatement ps1 = connection
							.prepareStatement("INSERT INTO `testcraighslist`.`title` (`category_id`, `post_id`, `title`)"
									+ " VALUES (?, ?, ?);");
					ps1.setLong(1, job.getCategory_id());
					ps1.setLong(2, result.getLong(1));
					n_Job.setId(result.getString(1));
					ps1.setString(3, job.getTitle());
					ps1.executeUpdate();

				}

			} catch (Exception e) {
				// TODO: handle exception
				throw e;
			}

			return n_Job;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.close();
		}

		return n_Job;
	}

	public Job updateJob(Connection connection, Job job) throws Exception {
		// TODO Auto-generated method stub
		Job nJob = new Job();

		try {
			String queryToJob = "UPDATE `testcraighslist`.`Job` SET ";
			StringBuilder build = new StringBuilder(queryToJob);

			if (job.getTitle() != null) {
				build.append("`title`= '" + job.getTitle() + "',");
			}

			if (job.getDescription() != null) {
				build.append("`description` = '" + job.getDescription() + "',");
			}

			if (job.getPrice() != 0) {
				build.append(" `price` = '" + job.getPrice() + "',");
			}

			if (job.getCondition() != 0) {
				build.append(" `condition` = '" + job.getCondition() + "',");
			}

			if (job.getType() != 0) {
				build.append(" `type` = '" + job.getType() + "',");
			}

			if (job.getLocation_id() != 0) {
				build.append(" `location_id` = '" + job.getLocation_id() + "',");
			}

			if (job.getLat() != 0) {
				build.append(" `lat` = '" + job.getLat() + "',");
			}

			if (job.getLon() != 0) {
				build.append(" `lon` = '" + job.getLon() + "',");
			}

			if (job.getCare_num() != 0) {
				build.append(" `care_num` = '" + job.getCare_num() + "',");
			}

			if (job.getSize() != 0) {
				build.append(" `size` = '" + job.getSize() + "',");
			}

			if (job.getPass() != null) {
				build.append(" `pass` = '" + job.getPass() + "',");
			}

			if (job.getAddress() != null) {
				build.append(" `address` = '" + job.getAddress() + "',");
			}

			if (job.getPhone_num() != null) {
				build.append(" `phone_num` = '" + job.getPhone_num() + "',");
			}

			build.deleteCharAt(build.length() - 1);

			build.append("WHERE `id` = '" + job.getId() + "';");

			System.out.println(build.toString());

			PreparedStatement ps = connection
					.prepareStatement(build.toString());
			System.out.println(ps.executeUpdate());

			String queryToTitle = "UPDATE `testcraighslist`.`Job` SET ";
			StringBuilder build1 = new StringBuilder(queryToTitle);

			if (job.getTitle() != null) {
				build1.append("`title`= '" + job.getTitle() + "',");
			}
			if (job.getType() != 0) {
				build1.append(" `type` = '" + job.getType() + "',");
			}

			if (job.getLocation_id() != 0) {
				build1.append(" `location_id` = '" + job.getLocation_id()
						+ "',");
			}
			
			build.deleteCharAt(build.length() - 1);

			build.append("WHERE `post_id` = '" + job.getId() + "AND `category_id`= '" + job.getCategory_id() + "';");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.close();
		}

		return nJob;
	}
	
	public boolean deleteJob(Connection connection, String post_id) throws Exception {
		
		try {
			PreparedStatement ps2 = connection.prepareStatement("SELECT job.category_id FROM `testcraighslist`.`job` WHERE `id`=?;");
			ps2.setString(1, post_id);
			
			ResultSet rs = ps2.executeQuery();
			
			String category_id = null;
			if(rs.next())
				category_id = rs.getString(1);
			System.out.println("delete category_id: " + category_id);
				 
			PreparedStatement ps = connection.prepareStatement("DELETE FROM `testcraighslist`.`job` WHERE `id`=?;");
			ps.setString(1, post_id);
			
			System.out.println(ps.executeUpdate());
			
			PreparedStatement ps1 = connection.prepareStatement("DELETE FROM `testcraighslist`.`title` WHERE `post_id`= ? AND `category_id` = ?;");
			ps1.setString(1, post_id);
			ps1.setString(2, category_id);
			
			System.out.println(ps1.executeUpdate());
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.close();
		}
		return true;
	}
	
}
