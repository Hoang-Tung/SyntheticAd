package com.kenshin.SyntheticAd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kenshin.SyntheticAd.Constant;
import com.kenshin.SyntheticAd.dto.Post;
import com.kenshin.SyntheticAd.dto.House;
import com.kenshin.SyntheticAd.dto.House;

public class HouseObject {
//	public ArrayList<House> getAll(Connection connection, String offset)
//			throws Exception {
//
//		ArrayList<House> datas = new ArrayList<House>();
//		try {
//			PreparedStatement ps = connection
//					.prepareStatement("SELECT * FROM testcraighslist.house ORDER BY house.updated_at DESC LIMIT 10 OFFSET ? ");
//			ps.setLong(1, Long.parseLong(offset));
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next()) {
//				House c = new House();
//				c.setId(rs.getString("id"));
//				c.setUser_id(rs.getString("user_id"));
//				c.setTitle(rs.getString("title"));
//				c.setCategory_id(rs.getString("category_id"));
//				c.setDescription(rs.getString("description"));
//				c.setType(rs.getString("type"));
//				c.setPrice(rs.getString("price"));
//				if (rs.getString("lon") != null) {
//					c.setLon(rs.getString("lon"));
//				}
//				if (rs.getString("lat") != null) {
//					c.setLat(rs.getString("lat"));
//				}
//				c.setLocation_id(rs.getString("location_id"));
//				if (rs.getString("image_url") != null) {
//					c.setImageUrl(rs.getString("image_url"));
//				}
//				if (rs.getString("condition") != null) {
//					c.setCondition(rs.getString("condition"));
//				}
//				if (rs.getString("extend_type") != null) {
//					c.setExtend_type(rs.getString("extend_type"));
//				}
//				if (rs.getString("pass") != null) {
//					c.setPass(rs.getString("pass"));
//				}
//				c.setCare_num(rs.getString("care_num"));
//				if (rs.getString("size") != null)
//					c.setSize(rs.getString("size"));
//				c.setCreated_at(rs.getString("created_at"));
//				c.setUpdated_at(rs.getString("updated_at"));
//				c.setAddress(rs.getString("address"));
//				if (rs.getString("phone_num") != null)
//					c.setPhone_num(rs.getString("phone_num"));
//
//				datas.add(c);
//			}
//			connection.close();
//			return datas;
//		} catch (Exception e) {
//			// TODO: handle exception
//			throw e;
//		} finally {
//			if (connection != null)
//				connection.close();
//		}
//	}

	public ArrayList<House> searchHouse(Connection connection,
			String title, String category_id, String location_id, String type)
			throws Exception {
		ArrayList<House> datas = new ArrayList<House>();

		return datas;
	}

	public House getHouse(Connection connection, String location_id)
			throws Exception {
		House house = new House();
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM testcraighslist.house WHERE house.id = ? ");
			ps.setString(1, location_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				House c = new House();
				c.setId(rs.getString("id"));
				c.setUser_id(rs.getString("user_id"));
				c.setTitle(rs.getString("title"));
				c.setCategory_id(rs.getString("category_id"));
				c.setDescription(rs.getString("description"));
				c.setType(rs.getString("type"));
				c.setPrice(rs.getString("price"));
				if (rs.getString("lon") != null) {
					c.setLon(rs.getString("lon"));
				}
				if (rs.getString("lat") != null) {
					c.setLat(rs.getString("lat"));
				}
				c.setLocation_id(rs.getString("location_id"));
				if (rs.getString("image_url") != null) {
					c.setImageUrl(rs.getString("image_url"));
				}
				if (rs.getString("condition") != null) {
					c.setCondition(rs.getString("condition"));
				}
				if (rs.getString("extend_type") != null) {
					c.setExtend_type(rs.getString("extend_type"));
				}
				if (rs.getString("pass") != null) {
					c.setExtend_type(rs.getString("pass"));
				}
				c.setCare_num(rs.getString("care_num"));
				if (rs.getString("size") != null)
					c.setSize(rs.getString("size"));
				c.setCreated_at(rs.getString("created_at"));
				c.setUpdated_at(rs.getString("updated_at"));
				c.setAddress(rs.getString("address"));
				if (rs.getString("phone_num") != null)
					c.setPhone_num(rs.getString("phone_num"));

				house = c;
			}
			connection.close();
			return house;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			if (connection != null)
				connection.close();
		}
	}

	public ArrayList<House> getByLocationAndCategory(Connection connection,
			String category_id, String location_id, String type, String offset)
			throws Exception {
		ArrayList<House> datas = new ArrayList<House>();
		try {
			PreparedStatement ps;
			if (Long.parseLong(location_id) == 0) {
				System.out.println("no location" + Long.parseLong(location_id));
				ps = connection
						.prepareStatement("SELECT * FROM testcraighslist.house WHERE house.category_id = ? AND house.type = ? ORDER BY house.created_at DESC LIMIT 10 OFFSET ?");
				ps.setLong(1, Long.parseLong(category_id));
				ps.setLong(2, Long.parseLong(type));
				ps.setLong(3, Long.parseLong(offset));

				// rs = ps.executeQuery();

			} else {
				ps = connection
						.prepareStatement("SELECT * FROM testcraighslist.house WHERE house.location_id = ? AND house.category_id = ? AND house.type = ? ORDER BY house.created_at DESC LIMIT 10 OFFSET ?");
				System.out.println("detected location");
				ps.setLong(1, Long.parseLong(location_id));
				ps.setLong(2, Long.parseLong(category_id));
				ps.setLong(3, Long.parseLong(type));
				ps.setLong(4, Long.parseLong(offset));
				// rs = ps.executeQuery();
			}

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("have result");
				House c = new House();
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
				}
				if (rs.getString("lat") != null) {
					c.setLat(rs.getString("lat"));
				}
				c.setLocation_id(rs.getString("location_id"));
				System.out.println(rs.getString("location_id"));
				if (rs.getString("image_url") != null) {
					c.setImageUrl(rs.getString("image_url"));
				}
				if (rs.getString("condition") != null) {
					c.setCondition(rs.getString("condition"));
				}
				if (rs.getString("extend_type") != null) {
					c.setExtend_type(rs.getString("extend_type"));
				}
				if (rs.getString("pass") != null) {
					c.setExtend_type(rs.getString("pass"));
				}
				c.setCare_num(rs.getString("care_num"));
				System.out.println(rs.getString("care_num"));
				if (rs.getString("size") != null)
					c.setSize(rs.getString("size"));
				if (rs.getString("created_at") != null)
					c.setCreated_at(rs.getString("created_at"));
				if (rs.getString("updated_at") != null)
					c.setUpdated_at(rs.getString("updated_at"));
				c.setAddress(rs.getString("address"));
				System.out.println(rs.getString("address"));
				if (rs.getString("phone_num") != null)
					c.setPhone_num(rs.getString("phone_num"));

				datas.add(c);
			}
			connection.close();
			return datas;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			if (connection != null)
				connection.close();
		}
	}

	public House updateHouse(Connection connection, House house)
			throws Exception {
		House nHouse = new House();

		try {
			String query = "UPDATE `testcraighslist`.`house` SET ";
			StringBuilder build = new StringBuilder(query);

			if (house.getTitle() != null) {
				build.append("`title`= '" + house.getTitle() + "',");
			}

			if (house.getDescription() != null) {
				build.append("`description` = '" + house.getDescription()
						+ "',");
			}

			if (house.getPrice() != 0) {
				build.append(" `price` = '" + house.getPrice() + "',");
			}

			if (house.getCondition() != 0) {
				build.append(" `condition` = '" + house.getCondition() + "',");
			}

			if (house.getType() != 0) {
				build.append(" `type` = '" + house.getType() + "',");
			}

			if (house.getLocation_id() != 0) {
				build.append(" `location_id` = '" + house.getLocation_id()
						+ "',");
			}

			if (house.getLat() != null) {
				build.append(" `lat` = '" + house.getLat() + "',");
			}

			if (house.getLon() != null) {
				build.append(" `lon` = '" + house.getLon() + "',");
			}

			if (house.getCare_num() != 0) {
				build.append(" `care_num` = '" + house.getCare_num() + "',");
			}

			if (house.getSize() != 0) {
				build.append(" `size` = '" + house.getSize() + "',");
			}

			if (house.getPass() != null) {
				build.append(" `pass` = '" + house.getPass() + "',");
			}

			if (house.getAddress() != null) {
				build.append(" `address` = '" + house.getAddress() + "',");
			}

			if (house.getPhone_num() != null) {
				build.append(" `phone_num` = '" + house.getPhone_num() + "',");
			}

			build.deleteCharAt(build.length() - 1);

			build.append("WHERE `id` = '" + house.getId() + "';");

			System.out.println(build.toString());

			PreparedStatement ps = connection
					.prepareStatement(build.toString());
			System.out.println(ps.executeUpdate());

			String queryToTitle = "UPDATE `testcraighslist`.`title` SET ";
			StringBuilder build1 = new StringBuilder(queryToTitle);

			if (house.getTitle() != null) {
				build1.append("`title`= '" + house.getTitle() + "',");
			}
			if (house.getType() != 0) {
				build1.append(" `type` = '" + house.getType() + "',");
			}

			if (house.getLocation_id() != 0) {
				build1.append(" `location_id` = '" + house.getLocation_id()
						+ "',");
			}

			build1.deleteCharAt(build.length() - 1);

			build1.append("WHERE `post_id` = '" + house.getId()
					+ "AND `category_id`= '" + house.getCategory_id() + "';");

			PreparedStatement ps1 = connection.prepareStatement(build1
					.toString());

			System.out.println(ps1.executeUpdate());
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.close();
		}

		return nHouse;
	}

	public House insertHouse(Connection connection, House house,
			String password) throws Exception {
		// TODO Auto-generated method stub
		House nHouse = new House();

		try {
			PreparedStatement preps = connection
					.prepareStatement("SELECT * FROM testcraighslist.user WHERE user.id = ? AND user.password = ?;");
			preps.setLong(1, house.getUser_id());
			preps.setString(2, password);

			ResultSet rs = preps.executeQuery();

			if (!rs.next()) {
				return null;
			}

			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO `testcraighslist`.`house` (`category_id`,"
							+ " `title`, `description`, `price`, `condition`, `user_id`, `type`, `location_id`, `pass`, `image_url`, `address`, `phone_num`, `lat`, `lon`) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setLong(1, house.getCategory_id());
			ps.setString(2, house.getTitle());
			ps.setString(3, house.getDescription());
			ps.setLong(4, (long) house.getPrice());
			ps.setLong(5, house.getCondition());
			ps.setLong(6, house.getUser_id());
			ps.setLong(7, house.getType());
			ps.setLong(8, house.getLocation_id());
			ps.setString(9, house.getPass());
			ps.setString(10, house.getImageUrl());
			ps.setString(11, house.getAddress());

			if (house.getPhone_num() != null) {
				ps.setString(12, house.getPhone_num());
			} else {
				ps.setString(12, "");
			}

			if (house.getLat() != null)
				ps.setString(13, String.valueOf(house.getLat()));
			else
				ps.setLong(13, 0);
			if (house.getLon() != null)
				ps.setString(14, String.valueOf(house.getLon()));
			else
				ps.setLong(14, 0);

			System.out.println(ps.executeUpdate());

			try {
				ResultSet result = ps.getGeneratedKeys();
				if (result.next()) {

					PreparedStatement ps1 = connection
							.prepareStatement("INSERT INTO `testcraighslist`.`title` (`category_id`, `post_id`, `title`, `user_id`, `location_id`, `type`)"
									+ " VALUES (?, ?, ?, ?, ?, ?);");
					ps1.setLong(1, house.getCategory_id());
					ps1.setLong(2, result.getLong(1));
					ps1.setString(3, house.getTitle());
					ps1.setLong(4, house.getUser_id());
					ps1.setLong(5, house.getLocation_id());
					ps1.setLong(6, house.getType());
					ps1.executeUpdate();
				}

			} catch (Exception e) {
				// TODO: handle exception
				throw e;
			}
			connection.close();
			return nHouse;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.close();
		}
		return nHouse;
	}

	public House deleteHouse(Connection connection, String house)
			throws Exception {
		House nHouse = new House();
		try {
			PreparedStatement ps = connection
					.prepareStatement("DELETE FROM `testcraighslist`.`house` WHERE `id`=?;");
			ps.setLong(1, Long.parseLong(house));

			System.out.println(ps.executeUpdate());
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (connection != null)
				connection.close();
		}
		return nHouse;
	}

	public ArrayList<House> getByDistance(Connection connection,
			String category_id, Double lat, Double lon, Double distance,
			int offset) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<House> datas = new ArrayList<House>();

		try {

			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM testcraighslist.house WHERE house.lat > ? AND house.lat < ? AND house.lon > ? AND house.lon < ? ORDER BY house.created_at DESC LIMIT 10 OFFSET ?");
			ps.setString(1, String.valueOf(lat
					- (distance * 360 / Constant.earth / Constant.pi / 2)));
			ps.setString(2, String.valueOf(lat
					+ (distance * 360 / Constant.earth / Constant.pi / 2)));
			ps.setString(3, String.valueOf(lon
					- (distance * 360 / Constant.earth / Constant.pi / 2)));
			ps.setString(4, String.valueOf(lon
					+ (distance * 360 / Constant.earth / Constant.pi / 2)));
			ps.setLong(5, offset);
			System.out.println(String.valueOf(lat
					+ (distance * 360 / Constant.earth / Constant.pi / 2)));
			System.out.println(ps.getQueryTimeout());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				House c = new House();
				c.setId(rs.getString("id"));
				c.setUser_id(rs.getString("user_id"));
				c.setTitle(rs.getString("title"));
				c.setCategory_id(rs.getString("category_id"));
				c.setDescription(rs.getString("description"));
				c.setType(rs.getString("type"));
				c.setPrice(rs.getString("price"));
				if (rs.getString("lon") != null) {
					c.setLon(rs.getString("lon"));
				}
				if (rs.getString("lat") != null) {
					c.setLat(rs.getString("lat"));
				}
				c.setLocation_id(rs.getString("location_id"));
				if (rs.getString("image_url") != null) {
					c.setImageUrl(rs.getString("image_url"));
				}
				if (rs.getString("condition") != null) {
					c.setCondition(rs.getString("condition"));
				}
				if (rs.getString("extend_type") != null) {
					c.setExtend_type(rs.getString("extend_type"));
				}
				if (rs.getString("pass") != null) {
					c.setExtend_type(rs.getString("pass"));
				}
				c.setCare_num(rs.getString("care_num"));
				if (rs.getString("size") != null)
					c.setSize(rs.getString("size"));
				if (rs.getString("created_at") != null)
					c.setCreated_at(rs.getString("created_at"));
				if (rs.getString("updated_at") != null)
					c.setUpdated_at(rs.getString("updated_at"));
				c.setAddress(rs.getString("address"));
				if (rs.getString("phone_num") != null)
					c.setPhone_num(rs.getString("phone_num"));

				datas.add(c);
			}
			connection.close();
			return datas;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.close();
		}
		return datas;
	}

	public int increaseCareNum(Connection connection, String category_id,
			String post_id, String user_id, String password) throws Exception {
		// TODO Auto-generated method stub
		int care_num = 0;
		try {
			PreparedStatement ps = connection
					.prepareStatement("UPDATE `testcraighslist`.`house` SET `care_num` = care_num + 1 WHERE `id`= ? AND `category_id` = ?;");
			ps.setString(1, post_id);
			ps.setString(2, category_id);
			
			ps.executeUpdate();
			
			if (user_id != null) {

				PreparedStatement check = connection
						.prepareStatement("SELECT * FROM `testcraighslist`.`user` WHERE `id` = ? AND `password` = ?;");
				check.setString(1, user_id);
				check.setString(2, password);
				ResultSet rs = check.executeQuery();
				
				if (rs.next()) {
					
					PreparedStatement ps1 = connection
							.prepareStatement("INSERT INTO `testcraighslist`.`care_sequence` (`category_id`, `post_id`, `user_id`) VALUES (?, ?, ?);");
					ps1.setString(1, category_id);
					ps1.setString(2, post_id);
					ps1.setString(3, user_id);

					ps1.executeUpdate();
				}
			}
			
			PreparedStatement ps2 = connection.prepareStatement("SELECT `care_num` FROM `testcraighslist`.`house` WHERE `id`= ? AND `category_id` = ?;");
			ps2.setString(1, post_id);
			ps2.setString(2, category_id);
			
			ResultSet rs2 = ps2.executeQuery();
			
			if (rs2.next())
				care_num = rs2.getInt(1);
			connection.close();
			return care_num;
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (connection != null)
				connection.close();
		}
		return care_num;
	}

	public int decreaseCareNum(Connection connection, String category_id,
			String post_id, String user_id, String password) throws Exception {
		// TODO Auto-generated method stub
		int care_num = 0;
		
		try {
			PreparedStatement ps = connection
					.prepareStatement("UPDATE `testcraighslist`.`house` SET `care_num` = care_num - 1 WHERE `id`=? AND `category_id` = ?;");

			ps.setString(1, post_id);
			ps.setString(2, category_id);
			
			ps.executeUpdate();
			
			if (user_id != null) {

				PreparedStatement check = connection
						.prepareStatement("SELECT * FROM `testcraighslist`.`user` WHERE id = ? AND password = ?;");
				check.setString(1, user_id);
				check.setString(2, password);
				ResultSet rs = check.executeQuery();

				if (rs.next()) {
					System.out.println(rs.getString("email"));
					
					PreparedStatement ps1 = connection
							.prepareStatement("DELETE FROM `testcraighslist`.`care_sequence` WHERE `category_id` = ? AND `post_id` = ? AND `user_id` = ?;");
					ps1.setString(1, category_id);
					ps1.setString(2, post_id);
					ps1.setString(3, user_id);

					ps1.executeUpdate();
				}
			}
			
			PreparedStatement ps2 = connection.prepareStatement("SELECT `care_num` FROM `testcraighslist`.`house` WHERE `id`= ? AND `category_id` = ?;");
			ps2.setString(1, post_id);
			ps2.setString(2, category_id);
			
			ResultSet rs2 = ps2.executeQuery();
			
			if (rs2.next())
				care_num = rs2.getInt(1);
			connection.close();
			return care_num;
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (connection != null)
				connection.close();
		}
		return care_num;
	}
	
	public ArrayList<House> getHouseByKeyWord(Connection connection,
			String category_id, String keyword, String location_id, String type)
			throws Exception {
		ArrayList<House> houses = new ArrayList<House>();

		ArrayList<String> list = new ArrayList<String>();

		String temp = Normalizer.normalize(keyword, Normalizer.Form.NFD);
		Pattern pattern1 = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		String temp1 = pattern1.matcher(temp).replaceAll("");

		Pattern pattern = Pattern.compile("\\w+");
		Matcher matcher = pattern.matcher(temp1);
		while (matcher.find()) {
			list.add(matcher.group());
			System.out.println(matcher.group());
		}

		try {
			String query = "SELECT * FROM testcraighslist.house WHERE house.category_id = " + category_id + " AND ";
			StringBuilder builder = new StringBuilder(query);
			for (int i = 0; i < list.size(); i++) {
				if (i == list.size() - 1) {
					builder.append("house.title LIKE '%" + list.get(i) + "%'");
					break;
				}

				builder.append("house.title LIKE '%" + list.get(i) + "%'"
						+ "OR ");

			}

			if (location_id != null)
				builder.append(" AND house.location_id = " + location_id);
			if (type != null)
				builder.append(" AND house.type = " + type);

			query = builder.toString();
			System.out.println(query);
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				House c = new House();
				c.setId(rs.getString("id"));
				c.setUser_id(rs.getString("user_id"));
				c.setTitle(rs.getString("title"));
				c.setCategory_id(rs.getString("category_id"));
				c.setDescription(rs.getString("description"));
				c.setType(rs.getString("type"));
				c.setPrice(rs.getString("price"));
				if (rs.getString("lon") != null) {
					c.setLon(rs.getString("lon"));
				}
				if (rs.getString("lat") != null) {
					c.setLat(rs.getString("lat"));
				}
				c.setLocation_id(rs.getString("location_id"));
				if (rs.getString("image_url") != null) {
					c.setImageUrl(rs.getString("image_url"));
				}
				if (rs.getString("condition") != null) {
					c.setCondition(rs.getString("condition"));
				}
				if (rs.getString("extend_type") != null) {
					c.setExtend_type(rs.getString("extend_type"));
				}
				if (rs.getString("pass") != null) {
					c.setExtend_type(rs.getString("pass"));
				}
				c.setCare_num(rs.getString("care_num"));
				if (rs.getString("size") != null)
					c.setSize(rs.getString("size"));
				if (rs.getString("created_at") != null)
					c.setCreated_at(rs.getString("created_at"));
				if (rs.getString("updated_at") != null)
					c.setUpdated_at(rs.getString("updated_at"));
				c.setAddress(rs.getString("address"));
				if (rs.getString("phone_num") != null)
					c.setPhone_num(rs.getString("phone_num"));

				houses.add(c);
			}
			
			connection.close();
			return houses;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			if (connection != null)
				connection.close();
		}
	}
}
