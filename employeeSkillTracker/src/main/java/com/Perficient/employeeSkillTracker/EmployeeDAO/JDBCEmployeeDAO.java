package com.Perficient.employeeSkillTracker.EmployeeDAO;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate template;

	public JDBCEmployeeDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}
	
	public Employee mapRowToEmployee (SqlRowSet row) {
		Employee employee = new Employee();
		employee.setEmployeeId(row.getString("employeeId"));
		employee.setFirstName(row.getString("firstName"));
		employee.setLastName(row.getString("lastName"));
		employee.setAddressId(row.getString("addressId"));
		employee.setContactEmail(row.getString("contactEmail"));
		employee.setCompanyEmail(row.getString("companyEmail"));
		employee.setBirthdate(row.getString("birthdate"));
		employee.setHireDate(row.getString("hireDate"));
		employee.setRole(row.getString("role"));
		employee.setBusinessUnit(row.getString("businessUnit"));
		employee.setAssignedTo(row.getString("assignedTo"));
		return employee;		
				
	}
	
	
	@Override
	public void add(Employee newEmployee) {
	String sql = "INSERT INTO employee "
			+ "(employeeId, firstName, lastName, addressId, contactEmail,"
			+ " companyEmail, birthdate, hireDate, role, businessUnit, assignedTo)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	template.queryForRowSet(sql, newEmployee.toString());
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> allEmployees = new ArrayList<>();
		
		String sql = "SELECT * FROM employee";
		SqlRowSet queryResults = template.queryForRowSet(sql);
		
		while (queryResults.next()) {
			allEmployees.add(mapRowToEmployee(queryResults));
			
		}
		return allEmployees;
	}

	@Override
	public Employee getById(String employeeId) {
	Employee employee = new Employee();
		
		String sql = "SELECT * FROM employee WHERE employeeId = ?";
		SqlRowSet queryResults = template.queryForRowSet(sql, employeeId);
		if (queryResults.next()) {
			employee=mapRowToEmployee(queryResults);
		}
		return employee;
	}
	

	@Override
	public void update(Employee updatedEmployee) {
		String sql = "Update  employee "
				+ "SET employeeId = ?, firstName = ?, lastName = ?, addressId = ?, contactEmail = ?,"
				+ " companyEmail = ?, birthdate = ?, hireDate = ?, role = ?, businessUnit = ?, assignedTo = ?)"
				+ "WHERE employeeId= ?";
		template.queryForRowSet(sql, updatedEmployee.toString(), updatedEmployee.getEmployeeId());
		}
	

	@Override
	public void remove(String employeeId) {
		String sql = "DELETE FROM employee WHERE employeeId = ?";
		template.update(sql, employeeId);
	

	}

}
