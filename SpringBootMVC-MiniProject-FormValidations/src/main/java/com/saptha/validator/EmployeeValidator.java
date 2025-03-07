package com.saptha.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.saptha.model.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("EmployeeValidator.validate()");
		Employee emp = (Employee) target;
		if (emp.getEname().equals("") || emp.getEname().length() == 0) {
			errors.rejectValue("ename", "emp.name.required");
		} else if (emp.getEname().length() < 5 || emp.getEname().length() > 15) {
			errors.rejectValue("ename", "emp.name.length");
		}

		if (emp.getJob().equals("") || emp.getJob().length() == 0) {
			errors.rejectValue("job", "emp.job.required");
		} else if (emp.getJob().length() < 4 || emp.getJob().length() > 10) {
			errors.rejectValue("job", "emp.job.length");
		}

		if (!errors.hasFieldErrors("sal")) {
			if (emp.getSal() == null) {
				errors.rejectValue("sal", "emp.sal.required");
			} else if (emp.getSal() < 10000 || emp.getSal() > 200000) {
				errors.rejectValue("sal", "emp.sal.range");
			}
		}

		if (emp.getDeptno() == null) {
			errors.rejectValue("deptno", "emp.deptno.required");
		}

	}

}
