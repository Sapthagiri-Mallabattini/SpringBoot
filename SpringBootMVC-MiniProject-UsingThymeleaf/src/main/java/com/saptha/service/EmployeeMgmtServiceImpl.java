package com.saptha.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saptha.model.Employee;
import com.saptha.repository.IEmployeeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService{
	
	@Autowired
	private IEmployeeRepository empRepo;
	
	@Override
	public List<Employee> fetchAllEmployees() {
		
		return empRepo.findAll() ;
	}

	@Override
	public String registerEmployee(Employee emp) {
		//save the object
		int idVal=empRepo.save(emp).getEmpno();
		return "Employee is saved with idVal:: "+idVal;
	}

	@Override
	public Employee getEmployeeById(int no) {
		//use the repository
		Employee emp=empRepo.getReferenceById(no);
		return emp;
	}

	@Override
	public String upadateEmployee(Employee emp) {
		Optional<Employee> opt=empRepo.findById(emp.getEmpno());
		if(opt.isPresent()) {
			empRepo.save(emp);
			return emp.getEmpno()+" employeed is updated";
		}
		return emp.getEmpno()+" employee is not available for the updation";
	}

	@Override
	public String deleteEmployee(int no) {
		// use repo
		empRepo.deleteById(no);
		return "Employee is deleted";
	}

}
