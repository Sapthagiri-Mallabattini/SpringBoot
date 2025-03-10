package com.saptha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saptha.entity.JobSeekerInfo;
import com.saptha.repository.IJobSeekerInfoRepository;

@Service("jsService")
public class JobSeekerMgmtServiceImpl implements IJobSeekerMgmtService {
	@Autowired
	private IJobSeekerInfoRepository jsInfoRepo;

	@Override
	public String saveJobSeeker(JobSeekerInfo info) {
		Integer idVal=jsInfoRepo.save(info).getJsId();
		return "JobSeeker is registered with the id value::"+idVal;
	}

	@Override
	public List<JobSeekerInfo> showAllJobSeeker() {
		return jsInfoRepo.findAll();
	}

	@Override
	public String fetchResumePathById(Integer id) {
		return jsInfoRepo.getResumePathBiJsId(id);
	}

	@Override
	public String fetchPhotopathById(Integer id) {
		return jsInfoRepo.getPhotoPathBiJsId(id);
	}

}
