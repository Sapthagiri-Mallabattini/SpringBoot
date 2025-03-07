package com.saptha.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.saptha.model.Employee;
import com.saptha.service.IEmployeeMgmtService;
import com.saptha.validator.EmployeeValidator;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeOperationsController {
	@Autowired
	private IEmployeeMgmtService empService;
	@Autowired
	private EmployeeValidator empValidator;

	@GetMapping("/")
	public String showHome() {
		return "welcome";
	}

	@GetMapping("/report")
	public String showReport(Map<String, Object> map) {
		List<Employee> empList = empService.fetchAllEmployees();
		map.put("empsInfo", empList);
		return "show_report";
	}

	@GetMapping("/register")
	public String showRegisterEmployeeFormPage(@ModelAttribute("emp") Employee emp) {
		return "employee_register_form";
	}

	@PostMapping("/register")
	public String processRegisterEmployeeFormPage(HttpSession ses, @ModelAttribute("emp") Employee emp,
			BindingResult errors) {

		if (emp.getVflag1().equalsIgnoreCase("no")) {
			if (empValidator.supports(emp.getClass())) {
				empValidator.validate(emp, errors);
				if (errors.hasErrors()) {
					return "employee_register_form";
				}
			}
		}

		if (empService.isDesgInRejectedList(emp.getJob())) {
			errors.rejectValue("job", "emp.desg.reject");
			return "employee_register_form";
		}

		System.out.println("EmployeeOperationsController.processRegisterEmployeeFormPage()");
		String msg = empService.registerEmployee(emp);
		ses.setAttribute("resultMsg", msg);
		return "redirect:report";
	}

	@GetMapping("/edit")
	public String showEditFormPage(@RequestParam("no") int no, @ModelAttribute("emp") Employee emp) {
		Employee emp1 = empService.getEmployeeById(no);
		BeanUtils.copyProperties(emp1, emp);
		return "employee_edit_form";
	}

	@PostMapping("/edit")
	public String showEditFormPage(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp,
			BindingResult errors) {
		if (emp.getVflag1().equalsIgnoreCase("no")) {
			if (empValidator.supports(emp.getClass())) {
				empValidator.validate(emp, errors);
				if (errors.hasErrors()) {
					return "employee_edit_form";
				}
			}
		}

		String msg = empService.upadateEmployee(emp);
		attrs.addFlashAttribute("resultMsg", msg);
		return "redirect:report";
	}

	@GetMapping("/delete")
	public String deleteEmployeeByNo(@RequestParam("no") int no, RedirectAttributes attrs) {
		String msg = empService.deleteEmployee(no);
		attrs.addFlashAttribute("resultMsg", msg);
		return "redirect:report";
	}

	@ModelAttribute("dnoList")
	public List<Integer> popularDeptNames() {
		List<Integer> dnoList = empService.showAllDeptNos();
		return dnoList;
	}
}
