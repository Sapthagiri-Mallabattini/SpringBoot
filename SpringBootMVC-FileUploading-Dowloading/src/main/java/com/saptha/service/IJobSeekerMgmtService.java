package com.saptha.service;

import java.util.List;

import com.saptha.entity.JobSeekerInfo;

public interface IJobSeekerMgmtService {
	public String saveJobSeeker(JobSeekerInfo info);
	public List<JobSeekerInfo> showAllJobSeeker();
	
	public String fetchResumePathById(Integer id);
	public String fetchPhotopathById(Integer id);
	
}
