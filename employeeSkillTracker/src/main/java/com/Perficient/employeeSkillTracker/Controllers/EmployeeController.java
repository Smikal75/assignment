package com.Perficient.employeeSkillTracker.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Perficient.employeeSkillTracker.EmployeeDAO.Employee;
import com.Perficient.employeeSkillTracker.EmployeeDAO.EmployeeDAO;

@RestController
@RequestMapping("/api")
@CrossOrigin

public class EmployeeController {

	@Autowired
	EmployeeDAO employees;
	
	@GetMapping (path= {"/employees"})
	public List<Employee> returnAllEmployees () {
		List <Employee> allEmployees = employees.getAll();
		return allEmployees;
	}
}

