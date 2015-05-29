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
import com.kenshin.SyntheticAd.dto.Applicance;
import com.kenshin.SyntheticAd.dto.Applicance;

public class ApplicanceObject {
	public ArrayList<Applicance> getAll(Connection connection, String offset)
			throws Exception {

		ArrayList<Applicance> datas = new ArrayList<Applicance>();
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM testcraighslist.applicance ORDER BY applicance.updated_at DESC LIMIT 10 OFFSET ? ");
			ps.setLong(1, Long.parseLong(offset));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Applicance c = new Applicance();
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
					c.setPass(rs.getString("pass"));
				}
				c.setCare_num(rs.getString("care_num"));
				if (rs.getString("size") != null)
					c.setSize(rs.getString("size"));
				c.setCreated_at(rs.getString("created_at"));
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
			throw e;
		} finally {
			if (connection != null)
				connection.close();
		}
	}

	public ArrayList<Applicance> searchApplicance(Connection connection,
			String title, String category_id, String location_id, String type)
			throws Exception {
		ArrayList<Applicance> datas = new ArrayList<Applicance>();

		return datas;
	}

	public Applicance getApplicance(Connection connection, String location_id)
			throws Exception {
		Applicance applicance = new Applicance();
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM testcraighslist.applicance WHERE applicance.id = ? ");
			ps.setString(1, location_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Applicance c = new Applicance();
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

				applicance = c;
			}
			connection.close();
			return applicance;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			if (connection != null)
				connection.close();
		}
	}

	public ArrayList<Applicance> getByLocationAndCategory(Connection connection,
			String category_id, String location_id, String type, String offset)
			throws Exception {
		ArrayList<Applicance> datas = new ArrayList<Applicance>();
		try {
			PreparedStatement ps;
			if (Long.parseLong(location_id) == 0) {
				System.out.println("no location" + Long.parseLong(location_id));
				ps = connection
						.prepareStatement("SELECT * FROM testcraighslist.applicance WHERE applicance.category_id = ? AND applicance.type = ? ORDER BY applicance.updated_at DESC LIMIT 10 OFFSET ?");
				ps.setLong(1, Long.parseLong(category_id));
				ps.setLong(2, Long.parseLong(type));
				ps.setLong(3, Long.parseLong(offset));

				// rs = ps.executeQuery();

			} else {
				ps = connection
						.prepareStatement("SELECT * FROM testcraighslist.applicance WHERE applicance.location_id = ? AND applicance.category_id = ? AND applicance.type = ? ORDER BY applicance.updated_at DESC LIMIT 10 OFFSET ?");
				System.out.println("detected location");
				ps.setLong(1, Long.parseLong(location_id));
				ps.setLong(2, Long.parseLong(category_id));
				ps.setLong(3, Long.parseLong(type));
				ps.setLong(4, Long.parseLong(offset));
				// rs = ps.executeQuery();
			}

			// PreparedStatement ps = connection
			// .prepareStatement("SELECT * FROM testcraighslist.applicance WHERE applicance.category_id = ? AND applicance.location_id = ? AND applicance.type = ? LIMIT 10 OFFSET ?");
			// System.out.println("detected location" +
			// Long.parseLong(location_id) + Long.parseLong(category_id) +
			// Long.parseLong(type) + Long.parseLong(offset));
			// ps.setLong(2, Long.parseLong(location_id));
			// ps.setLong(1, Long.parseLong(category_id));
			// ps.setLong(3, Long.parseLong(type));
			// ps.setLong(4, Long.parseLong(offset));

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Applicance c = new Applicance();
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
			throw e;
		} finally {
			if (connection != null)
				connection.close();
		}
	}

	public Applicance updateApplicance(Connection connection, Applicance applicance)
			throws Exception {
		Applicance nApplicance = new Applicance();

		try {
			String query = "UPDATE `testcraighslist`.`applicance` SET ";
			StringBuilder build = new StringBuilder(query);

			if (applicance.getTitle() != null) {
				build.append("`title`= '" + applicance.getTitle() + "',");
			}

			if (applicance.getDescription() != null) {
				build.append("`description` = '" + applicance.getDescription()
						+ "',");
			}

			if (applicance.getPrice() != 0) {
				build.append(" `price` = '" + applicance.getPrice() + "',");
			}

			if (applicance.getCondition() != 0) {
				build.append(" `condition` = '" + applicance.getCondition() + "',");
			}

			if (applicance.getType() != 0) {
				build.append(" `type` = '" + applicance.getType() + "',");
			}

			if (applicance.getLocation_id() != 0) {
				build.append(" `location_id` = '" + applicance.getLocation_id()
						+ "',");
			}

			if (applicance.getLat() != null) {
				build.append(" `lat` = '" + applicance.getLat() + "',");
			}

			if (applicance.getLon() != null) {
				build.append(" `lon` = '" + applicance.getLon() + "',");
			}

			if (applicance.getCare_num() != 0) {
				build.append(" `care_num` = '" + applicance.getCare_num() + "',");
			}

			if (applicance.getSize() != 0) {
				build.append(" `size` = '" + applicance.getSize() + "',");
			}

			if (applicance.getPass() != null) {
				build.append(" `pass` = '" + applicance.getPass() + "',");
			}

			if (applicance.getAddress() != null) {
				build.append(" `address` = '" + applicance.getAddress() + "',");
			}

			if (applicance.getPhone_num() != null) {
				build.append(" `phone_num` = '" + applicance.getPhone_num() + "',");
			}

			build.deleteCharAt(build.length() - 1);

			build.append("WHERE `id` = '" + applicance.getId() + "';");

			System.out.println(build.toString());

			PreparedStatement ps = connection
					.prepareStatement(build.toString());
			System.out.println(ps.executeUpdate());

			String queryToTitle = "UPDATE `testcraighslist`.`title` SET ";
			StringBuilder build1 = new StringBuilder(queryToTitle);

			if (applicance.getTitle() != null) {
				build1.append("`title`= '" + applicance.getTitle() + "',");
			}
			if (applicance.getType() != 0) {
				build1.append(" `type` = '" + applicance.getType() + "',");
			}

			if (applicance.getLocation_id() != 0) {
				build1.append(" `location_id` = '" + applicance.getLocation_id()
						+ "',");
			}

			build1.deleteCharAt(build.length() - 1);

			build1.append("WHERE `post_id` = '" + applicance.getId()
					+ "AND `category_id`= '" + applicance.getCategory_id() + "';");

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

		return nApplicance;
	}

	public Applicance insertApplicance(Connection connection, Applicance applicance,
			String password) throws Exception {
		// TODO Auto-generated method stub
		Applicance nApplicance = new Applicance();

		try {
			PreparedStatement preps = connection
					.prepareStatement("SELECT * FROM testcraighslist.user WHERE user.id = ? AND user.password = ?;");
			preps.setLong(1, applicance.getUser_id());
			preps.setString(2, password);

			ResultSet rs = preps.executeQuery();

			if (!rs.next()) {
				return null;
			}

			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO `testcraighslist`.`applicance` (`category_id`,"
							+ " `title`, `description`, `price`, `condition`, `user_id`, `type`, `location_id`, `pass`, `image_url`, `address`, `phone_num`, `lat`, `lon`) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setLong(1, applicance.getCategory_id());
			ps.setString(2, applicance.getTitle());
			ps.setString(3, applicance.getDescription());
			ps.setLong(4, (long) applicance.getPrice());
			ps.setLong(5, applicance.getCondition());
			ps.setLong(6, applicance.getUser_id());
			ps.setLong(7, applicance.getType());
			ps.setLong(8, applicance.getLocation_id());
			ps.setString(9, applicance.getPass());
			ps.setString(10, applicance.getImageUrl());
			ps.setString(11, applicance.getAddress());

			if (applicance.getPhone_num() != null) {
				ps.setString(12, applicance.getPhone_num());
			} else {
				ps.setString(12, "");
			}

			if (applicance.getLat() != null)
				ps.setString(13, String.valueOf(applicance.getLat()));
			else
				ps.setLong(13, 0);
			if (applicance.getLon() != null)
				ps.setString(14, String.valueOf(applicance.getLon()));
			else
				ps.setLong(14, 0);

			System.out.println(ps.executeUpdate());

			try {
				ResultSet result = ps.getGeneratedKeys();
				if (result.next()) {

					PreparedStatement ps1 = connection
							.prepareStatement("INSERT INTO `testcraighslist`.`title` (`category_id`, `post_id`, `title`, `user_id`, `location_id`, `type`)"
									+ " VALUES (?, ?, ?, ?, ?, ?);");
					ps1.setLong(1, applicance.getCategory_id());
					ps1.setLong(2, result.getLong(1));
					ps1.setString(3, applicance.getTitle());
					ps1.setLong(4, applicance.getUser_id());
					ps1.setLong(5, applicance.getLocation_id());
					ps1.setLong(6, applicance.getType());
					ps1.executeUpdate();
				}

			} catch (Exception e) {
				// TODO: handle exception
				throw e;
			}
			connection.close();
			return nApplicance;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.close();
		}
		return nApplicance;
	}

	public Applicance deleteApplicance(Connection connection, String applicance)
			throws Exception {
		Applicance nApplicance = new Applicance();
		try {
			PreparedStatement ps = connection
					.prepareStatement("DELETE FROM `testcraighslist`.`applicance` WHERE `id`=?;");
			ps.setLong(1, Long.parseLong(applicance));

			System.out.println(ps.executeUpdate());
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (connection != null)
				connection.close();
		}
		return nApplicance;
	}

	public ArrayList<Applicance> getByDistance(Connection connection,
			String category_id, Double lat, Double lon, Double distance,
			int offset) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Applicance> datas = new ArrayList<Applicance>();

		try {

			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM testcraighslist.applicance WHERE applicance.lat > ? AND applicance.lat < ? AND applicance.lon > ? AND applicance.lon < ? ORDER BY applicance.created_at DESC LIMIT 10 OFFSET ?");
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
				Applicance c = new Applicance();
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
					.prepareStatement("UPDATE `testcraighslist`.`applicance` SET `care_num` = care_num + 1 WHERE `id`= ? AND `category_id` = ?;");
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
			
			PreparedStatement ps2 = connection.prepareStatement("SELECT `care_num` FROM `testcraighslist`.`applicance` WHERE `id`= ? AND `category_id` = ?;");
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
					.prepareStatement("UPDATE `testcraighslist`.`applicance` SET `care_num` = care_num - 1 WHERE `id`=? AND `category_id` = ?;");

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
			
			PreparedStatement ps2 = connection.prepareStatement("SELECT `care_num` FROM `testcraighslist`.`applicance` WHERE `id`= ? AND `category_id` = ?;");
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
	
	public ArrayList<Applicance> getApplicanceByKeyWord(Connection connection,
			String category_id, String keyword, String location_id, String type)
			throws Exception {
		ArrayList<Applicance> applicances = new ArrayList<Applicance>();

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
			String query = "SELECT * FROM testcraighslist.applicance WHERE applicance.category_id = " + category_id + " AND ";
			StringBuilder builder = new StringBuilder(query);
			for (int i = 0; i < list.size(); i++) {
				if (i == list.size() - 1) {
					builder.append("applicance.title LIKE '%" + list.get(i) + "%'");
					break;
				}

				builder.append("applicance.title LIKE '%" + list.get(i) + "%'"
						+ "OR ");

			}

			if (location_id != null)
				builder.append(" AND applicance.location_id = " + location_id);
			if (type != null)
				builder.append(" AND applicance.type = " + type);

			query = builder.toString();
			System.out.println(query);
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Applicance c = new Applicance();
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

				applicances.add(c);
			}
			
			connection.close();
			return applicances;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			if (connection != null)
				connection.close();
		}
	}
}
