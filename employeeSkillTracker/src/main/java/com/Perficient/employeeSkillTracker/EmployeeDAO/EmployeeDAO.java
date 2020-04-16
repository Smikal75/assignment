package com.Perficient.employeeSkillTracker.EmployeeDAO;

import java.util.List;

public interface EmployeeDAO {

	//CRUD
	
	public void add (Employee newEmployee);
	
	public List <Employee> getAll ();
	public Employee getById (String employeeId);
	
	public void update(Employee updatedEmployee);
	
	public void remove (String employeeId);
		
}
