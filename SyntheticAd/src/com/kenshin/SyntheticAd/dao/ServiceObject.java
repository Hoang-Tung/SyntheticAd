package com.kenshin.SyntheticAd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kenshin.SyntheticAd.dto.Post;
import com.kenshin.SyntheticAd.dto.Service;
import com.kenshin.SyntheticAd.dto.Service;

public class ServiceObject {

	public ArrayList<Service> getAll(Connection connection) throws Exception {
		ArrayList<Service> datas = new ArrayList<Service>();
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM testcraighslist.service");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Service c = new Service();
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

	public ArrayList<Service> getServiceByCategoryAndLocation(
			Connection connection, String category_id, String location,
			String type, String offset) throws Exception {
		ArrayList<Service> datas = new ArrayList<Service>();

		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM testcraighslist.service WHERE service.category_id = ? AND service.location_id = ? AND service.type = ? LIMIT 10 OFFSET ?;");
			ps.setLong(1, Long.parseLong(category_id));
			ps.setLong(2, Long.parseLong(location));
			ps.setLong(3, Long.parseLong(type));
			ps.setLong(4, Long.parseLong(offset));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Service c = new Service();
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

	public Service createService(Connection connection, Service service,
			String password) throws Exception {
		Service n_Service = new Service();

		try {
			PreparedStatement preps = connection
					.prepareStatement("SELECT * FROM testcraighslist.user WHERE user.id = ? AND user.password = ?;");
			preps.setLong(1, service.getUser_id());
			preps.setString(2, password);

			ResultSet rs = preps.executeQuery();

			if (!rs.next()) {
				return null;
			}

			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO `testcraighslist`.`service` (`category_id`,"
							+ " `title`, `description`, `price`, `condition`, `user_id`, `type`, `location_id`, `pass`, `image_url`, `address`, `phone_num`, `lat`, `lon`) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setLong(1, service.getCategory_id());
			ps.setString(2, service.getTitle());
			ps.setString(3, service.getDescription());
			ps.setLong(4, (long) service.getPrice());
			ps.setLong(5, service.getCondition());
			ps.setLong(6, service.getUser_id());
			ps.setLong(7, service.getType());
			ps.setLong(8, service.getLocation_id());
			ps.setString(9, service.getPass());
			ps.setString(10, service.getImageUrl());
			ps.setString(11, service.getAddress());

			if (service.getPhone_num() != null) {
				ps.setString(12, service.getPhone_num());
			} else {
				ps.setString(12, "");
			}

			if (service.getLat() != null)
				ps.setString(13, String.valueOf(service.getLat()));
			else
				ps.setLong(13, 0);
			if (service.getLon() != null)
				ps.setString(14, String.valueOf(service.getLon()));
			else
				ps.setLong(14, 0);

			System.out.println(ps.executeUpdate());

			try {
				ResultSet result = ps.getGeneratedKeys();

				if (result.next()) {

					PreparedStatement ps1 = connection
							.prepareStatement("INSERT INTO `testcraighslist`.`title` (`category_id`, `post_id`, `title`)"
									+ " VALUES (?, ?, ?);");
					ps1.setLong(1, service.getCategory_id());
					ps1.setLong(2, result.getLong(1));
					n_Service.setId(result.getString(1));
					ps1.setString(3, service.getTitle());
					ps1.executeUpdate();

				}

			} catch (Exception e) {
				// TODO: handle exception
				throw e;
			}

			return n_Service;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.close();
		}

		return n_Service;
	}

	public Service updateService(Connection connection, Service service)
			throws Exception {
		Service u_Service = new Service();

		try {
			String queryToJob = "UPDATE `testcraighslist`.`service` SET ";
			StringBuilder build = new StringBuilder(queryToJob);

			if (service.getTitle() != null) {
				build.append("`title`= '" + service.getTitle() + "',");
			}

			if (service.getDescription() != null) {
				build.append("`description` = '" + service.getDescription()
						+ "',");
			}

			if (service.getPrice() != 0) {
				build.append(" `price` = '" + service.getPrice() + "',");
			}

			if (service.getCondition() != 0) {
				build.append(" `condition` = '" + service.getCondition() + "',");
			}

			if (service.getType() != 0) {
				build.append(" `type` = '" + service.getType() + "',");
			}

			if (service.getLocation_id() != 0) {
				build.append(" `location_id` = '" + service.getLocation_id()
						+ "',");
			}

			if (service.getLat() != null) {
				build.append(" `lat` = '" + service.getLat() + "',");
			}

			if (service.getLon() != null) {
				build.append(" `lon` = '" + service.getLon() + "',");
			}

			if (service.getCare_num() != 0) {
				build.append(" `care_num` = '" + service.getCare_num() + "',");
			}

			if (service.getSize() != 0) {
				build.append(" `size` = '" + service.getSize() + "',");
			}

			if (service.getPass() != null) {
				build.append(" `pass` = '" + service.getPass() + "',");
			}

			if (service.getAddress() != null) {
				build.append(" `address` = '" + service.getAddress() + "',");
			}

			if (service.getPhone_num() != null) {
				build.append(" `phone_num` = '" + service.getPhone_num() + "',");
			}

			build.deleteCharAt(build.length() - 1);

			build.append(" WHERE `id` = '" + service.getId() + "';");

			System.out.println(build.toString());

			PreparedStatement ps = connection
					.prepareStatement(build.toString());
			System.out.println(ps.executeUpdate());

			String queryToTitle = "UPDATE `testcraighslist`.`title` SET ";
			StringBuilder build1 = new StringBuilder(queryToTitle);

			if (service.getTitle() != null) {
				build1.append("`title`= '" + service.getTitle() + "',");
			}
			if (service.getType() != 0) {
				build1.append(" `type` = '" + service.getType() + "',");
			}

			if (service.getLocation_id() != 0) {
				build1.append(" `location_id` = '" + service.getLocation_id()
						+ "',");
			}

			build1.deleteCharAt(build1.length() - 1);

			build1.append(" WHERE `post_id` = '" + service.getId() + "'"
					+ " AND `category_id`= '" + service.getCategory_id() + "';");

			System.out.println(build1.toString());

			PreparedStatement ps1 = connection.prepareStatement(build1
					.toString());
			System.out.println(ps1.execute());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.close();
		}

		return u_Service;
	}
	
	public boolean deleteService(Connection connection,String id) throws Exception{

		try {
			PreparedStatement ps = connection
					.prepareStatement("DELETE FROM `testcraighslist`.`service` WHERE `id`=?;");
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

}
