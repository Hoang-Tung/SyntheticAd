package com.kenshin.SyntheticAd.model;

import java.sql.Connection;
import java.util.ArrayList;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.kenshin.SyntheticAd.dao.JobObject;
import com.kenshin.SyntheticAd.database.Database;
import com.kenshin.SyntheticAd.dto.Job;

@Api(name="job", version="v1")
public class JobObjectManager {
	
	@ApiMethod(name="getjob")
	public ArrayList<Job> getJobLocationAndCategory(@Named("category_id") String category_id,
			@Named("location_id") String location_id, @Named("type") String type,
			@Named("offset") String offset) throws Exception{
		ArrayList<Job> datas = new ArrayList<Job>();
		
		try {
			Database database = new Database();
			Connection connection = database.getConnect();
			JobObject object = new JobObject();
			datas = object.getJobByCategoryAndLocation(connection, category_id, location_id, type,offset);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return datas;
	}
	
	@ApiMethod(name="jobcreate")
	public Job createJob(Job job) throws Exception{
		Job n_Job = new Job();
		
		Database database = new Database();
		try {
			Connection con = database.getConnect();
			JobObject object = new JobObject();
			n_Job = object.createJob(con, job);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
				
		return n_Job;
	}
	
	@ApiMethod(name="jobupdate")
	public Job updateJob(Job job) throws Exception{
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
	
	@ApiMethod(name="jobdelete")
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
	
}
