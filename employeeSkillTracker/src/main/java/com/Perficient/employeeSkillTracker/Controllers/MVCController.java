package com.Perficient.employeeSkillTracker.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Perficient.employeeSkillTracker.EmployeeDAO.Employee;
import com.Perficient.employeeSkillTracker.EmployeeDAO.EmployeeDAO;

@Controller
@CrossOrigin
public class MVCController {

	@Autowired
	EmployeeDAO employees;
	
	@RequestMapping (path= "/", method= RequestMethod.GET)
	public String returnAllEmployeesJsp (ModelMap map) {
		List <Employee> allEmployees = employees.getAll();
		map.addAttribute("employees", allEmployees);
		return "employees";
	}
}

