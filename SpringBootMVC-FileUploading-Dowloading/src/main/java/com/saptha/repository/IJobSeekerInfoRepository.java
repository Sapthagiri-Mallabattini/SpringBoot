package com.saptha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.saptha.entity.JobSeekerInfo;

public interface IJobSeekerInfoRepository extends JpaRepository<JobSeekerInfo, Integer> {
	@Query("select resumePath from JobSeekerInfo where jsId=:id")
	public String getResumePathBiJsId(Integer id);
	
	@Query("select photoPath from JobSeekerInfo where jsId=:id")
	public String getPhotoPathBiJsId(Integer id);
}
