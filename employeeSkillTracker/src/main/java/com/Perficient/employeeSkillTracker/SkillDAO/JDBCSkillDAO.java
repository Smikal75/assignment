package com.Perficient.employeeSkillTracker.SkillDAO;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCSkillDAO implements SkillDAO {
	private JdbcTemplate template;

	public JDBCSkillDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}
	
	public Skill mapRowToSkill (SqlRowSet row) {
	Skill skill = new Skill();
	skill.setSkillId(row.getString("skillId"));
	skill.setName(row.getString("name"));
	skill.setType(row.getString("type"));
	skill.setExperience(row.getString("experience"));
	skill.setSummary(row.getString("summary"));
	
	return skill;
	}
	
	@Override
	public void add(Skill newSkill) {
		//only add to skill fields
		String sql = "INSERT INTO skill (skillId, name, type) "
				+ "VALUES (? , ? , ? )";
		template.update(sql, newSkill.getSkillId(), newSkill.getName(), newSkill.getType());
		
	}

	@Override
	public List<Skill> getAllSkills() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Skill> getSkillsByEmployeeId(String employeeId) {
		List <Skill> employeeSkills = new ArrayList <>();
		String sql = "SELECT employeeSkill.skillId, skill.name, skill.type, employeeSkill.experience, employeeSkill.summary  FROM employeeSkill JOIN skill ON skill.skillId = employeeSkill.skillId WHERE employeeId = ?";
		SqlRowSet queryResults = template.queryForRowSet(sql, employeeId);
		while (queryResults.next()) {
			employeeSkills.add(mapRowToSkill(queryResults));
		}
		return employeeSkills;
	}

	@Override
	public void updateEmployeeSkill(String employeeId, Skill skill) {
		String sql = "SELECT * FROM employeeSkill WHERE ? , ? ";
		SqlRowSet queryResults = template.queryForRowSet(sql, employeeId, skill.getSkillId());
		if (queryResults.next()) { 
			sql="UPDATE employeeSkill SET skillId = ? , experience = ? , summary = ? "
					+ " WHERE employeeId = ?";
			template.update( sql, skill.getSkillId(), skill.getExperience(), skill.getSummary(), employeeId);		
		} else {
			sql = "INSERT INTO employeeSkill (skillId, experience, summary, employeeId)"
					+ "VALUES ( ? , ? , ? , ? )";
			template.update( sql, skill.getSkillId(), skill.getExperience(), skill.getSummary(), employeeId);
		}
	}

	@Override
	public void removeEmployeeSkill(String employeeId, String skillId) {
		String sql = "DELETE FROM employeeSkill WHERE employeeId = ? AND skillId= ?";
		template.update(sql, employeeId, skillId);
		
	}

	
}
