package com.kenshin.SyntheticAd.model;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.text.Caret;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.kenshin.SyntheticAd.dao.JobObject;
import com.kenshin.SyntheticAd.dao.JobObject;
import com.kenshin.SyntheticAd.dao.JobObject;
import com.kenshin.SyntheticAd.database.Database;
import com.kenshin.SyntheticAd.dto.Job;
import com.kenshin.SyntheticAd.dto.Job;
import com.kenshin.SyntheticAd.dto.Job;

@Api(name = "job", version = "v1")
public class JobObjectManager {

	@ApiMethod(name = "getjob")
	public ArrayList<Job> getJobLocationAndCategory(
			@Named("category_id") String category_id,
			@Named("location_id") String location_id,
			@Named("type") String type, @Named("offset") @Nullable String offset)
			throws Exception {
		ArrayList<Job> datas = new ArrayList<Job>();

		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			JobObject object = new JobObject();
			datas = object.getJobByCategoryAndLocation(connection, category_id,
					location_id, type, offset);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return datas;
	}

	@ApiMethod(name="getJobById")
	public Job getJob(@Named("id") String id) throws Exception{
		Job n_Job = new Job();
		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			JobObject object = new JobObject();
			n_Job = object.getJob(connection, id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return n_Job;
	}
	
	@ApiMethod(name = "jobcreate", path="job")
	public Job createJob(Job job, @Named("password") @Nullable String password)
			throws Exception {
		Job n_Job = new Job();

		Database database = new Database();
		try {
			Connection con = database.getConnect();
			JobObject object = new JobObject();
			n_Job = object.createJob(con, job, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return n_Job;
	}

	@ApiMethod(name = "jobupdate")
	public Job updateJob(Job job) throws Exception {
		Job n_Job = new Job();

		Database database = new Database();
		try {
			Connection con = database.getConnect();
			JobObject object = new JobObject();
			n_Job = object.updateJob(con, job);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_Job;
	}

	@ApiMethod(name = "jobdelete")
	public void deleteJob(@Named("id") String id) throws Exception {
		boolean result = false;

		Database database = new Database();
		try {
			Connection con = database.getConnect();
			JobObject object = new JobObject();
			result = object.deleteJob(con, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@ApiMethod(name = "increaseCareNum", path="jobInCreaseCareNum")
	public Job inCreaseCareNum(@Named("category_id") String category_id,
			@Named("id") String id, @Named("user_id") @Nullable String user_id,
			@Named("password") @Nullable String password) {
		Database database = new Database();
		Job n_Job = new Job();
		try {
			Connection con = database.getConnect();
			JobObject object = new JobObject();
			n_Job.setCare_num("" + object.increaseCareNum(con, category_id, id, user_id, password));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_Job;
	}

	@ApiMethod(name = "decreaseCareNum", path="jobDeCreaseCareNum")
	public Job deCreaseCareNum(@Named("category_id") String category_id,
			@Named("id") String id, @Named("user_id") @Nullable String user_id,
			@Named("password") @Nullable String password) {
		Database database = new Database();
		Job n_Job = new Job();
		System.out.println(user_id + " pp" + password);
		try {
			Connection con = database.getConnect();
			JobObject object = new JobObject();
			n_Job.setCare_num("" + object.decreaseCareNum(con, category_id, id, user_id, password));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n_Job;
	}

	@ApiMethod(name = "jobByKeyword")
	public ArrayList<Job> getJobByKeyword(@Named("category_id") String category_id,
			@Named("keyword") @Nullable String keyword,
			@Named("location_id") @Nullable String location_id,
			@Named("type") @Nullable String type) {
		ArrayList<Job> datas = new ArrayList<Job>();

		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			JobObject object = new JobObject();
			datas = object.getJobByKeyWord(connection, category_id, keyword, location_id,
					type);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return datas;
	}

}
