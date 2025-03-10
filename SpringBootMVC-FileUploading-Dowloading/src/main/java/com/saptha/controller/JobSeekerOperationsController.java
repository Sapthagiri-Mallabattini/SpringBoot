package com.saptha.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.saptha.entity.JobSeekerInfo;
import com.saptha.model.JobSeekerDetails;
import com.saptha.service.IJobSeekerMgmtService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@MultipartConfig
public class JobSeekerOperationsController {
	@Autowired
	private IJobSeekerMgmtService jsService;
	@Autowired
	private Environment env;
	
	@GetMapping("/")
	public String showHome() {
		return "welcome";
	}
	
	@GetMapping("/js_register")
	public String showHomePage(@ModelAttribute("js")JobSeekerDetails details) {
		//return LVN
		return "js_register_form";
	}
	
	@PostMapping("/js_register")
	public String registerJobSeeker(Map<String,Object> map,@ModelAttribute("js")JobSeekerDetails details)throws Exception{
		//get folder location of file uploading from the application properties file
		String storeLocation=env.getRequiredProperty("upload.store");
		//create store location folder if it is not already there
		File storeLocationFolder=new File(storeLocation);
		if(!storeLocationFolder.exists()) {
			storeLocationFolder.mkdir(); //creates the directory
		}
		
		//get MultiPartFile objects representing the uploaded file
		MultipartFile file1=details.getResume();
		MultipartFile file2=details.getPhoto();
		
		//create inputStream from the MultipartFile objects
		InputStream file1Is=file1.getInputStream();
		InputStream file2Is=file2.getInputStream();
		
		//get original file names from the list of loaded files
		String fileName1=file1.getOriginalFilename();
		String fileName2=file2.getOriginalFilename();
		
		//create OutputStream having destination file names
		OutputStream file1Os=new FileOutputStream(storeLocationFolder.getAbsolutePath()+"/"+fileName1);
		OutputStream file2Os=new FileOutputStream(storeLocationFolder.getAbsolutePath()+"/"+fileName2);
		
		//copy the content of loaded files to Destination files
		IOUtils.copy(file1Is, file1Os);
		IOUtils.copy(file2Is, file2Os);
		//close the streams 
		file1Is.close();
		file2Is.close();
		file1Os.close();
		file2Os.close();
		
		//create entry class object having content of model class obj
		JobSeekerInfo info=new JobSeekerInfo();
		info.setJsName(details.getJsName());
		info.setJsAddrs(details.getJsAddrs());
		info.setJsQlfy(details.getJsQlfy());
		info.setPhotoPath(storeLocationFolder.getAbsolutePath()+"\\"+fileName1);
		info.setResumePath(storeLocationFolder.getAbsolutePath()+"\\"+fileName2);
		
		//use service class
		String resultMsg=jsService.saveJobSeeker(info);
		//keep results in model attributes
		map.put("resultMsg", resultMsg);
		map.put("fileName1", fileName1);
		map.put("fileName2", fileName2);
		
		//return LVN
		return "show_result";
		
	}
	
	@GetMapping("js_report")
	public String showAllJobSeekers(Map<String,Object> map) {
		//invoke the service method
		List<JobSeekerInfo> list=jsService.showAllJobSeeker();
		//add to model attribute
		map.put("jsInfo", list);
		//return LVN
		return "show_report";
	}
	
	@GetMapping("/download")
	public String downloadFile(@RequestParam("id")Integer id,
							   @RequestParam("type")String type,
							   HttpServletRequest req,HttpServletResponse res)throws Exception{
		//get the path of file to be downloaded from the DB s/w
		String filePath=null;
		if(type.equalsIgnoreCase("resume")) {
			filePath=jsService.fetchResumePathById(id);
		}
		else {
			filePath=jsService.fetchPhotopathById(id);
		}
		//create java.io.File class obj representing file to be downloaded
		File file=new File(filePath);
		//get the file length and make it is response content length
		res.setContentLengthLong(file.length());
		//get servletContext object
		ServletContext sc=req.getServletContext();
		//get MIME of the file and make if as the response content type
		String mimeType=sc.getMimeType(filePath);
		mimeType=(mimeType==null)?"application/octet-stram":mimeType;
		res.setContentType(mimeType);
		
		//create InputStream obj pointing to the file to db downloaded
		InputStream is=new FileInputStream(file);
		//create OutputStream obj pointing to the response object
		OutputStream os=res.getOutputStream();
		//give instruction to browser to display the received content as downloadable file
		res.addHeader("Content-Disposition", "attachment;fileName="+file.getName());
		//copy content to response object
		IOUtils.copy(is, os);
		
		//close the streams
		is.close();
		os.close();
		
		return null;// required if handler method wants to send the response/output to browser directly
	}
}
