package com.saptha.service;

import java.util.List;

import com.saptha.model.Employee;

public interface IEmployeeMgmtService {
	public List<Employee> fetchAllEmployees();
	public String registerEmployee(Employee emp);
	public Employee getEmployeeById(int no);
	public String upadateEmployee(Employee emp);
	public String deleteEmployee(int no);
}
