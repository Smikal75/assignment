package com.Perficient.employeeSkillTracker.SkillDAO;

import java.util.List;

public interface SkillDAO {
//CRUD
	
	public void add (Skill newSkill);
	
	public List <Skill> getAllSkills ();
	public List <Skill> getSkillsByEmployeeId (String employeeId);
	
	public void	updateEmployeeSkill (String employeeId, Skill skill);
	
	public void	removeEmployeeSkill (String employeeId, String skillId);
	
}
