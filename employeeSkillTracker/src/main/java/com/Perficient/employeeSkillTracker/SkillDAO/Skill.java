package com.Perficient.employeeSkillTracker.SkillDAO;

public class Skill {
		private String skillId;
		private String name;
		private String type;
		private String experience ="";
		private String summary = "";
		
		public String getSkillId() {
			return skillId;
		}
		public void setSkillId(String skillId) {
			this.skillId = skillId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getExperience() {
			return experience;
		}
		public void setExperience(String experience) {
			this.experience = experience;
		}
		public String getSummary() {
			return summary;
		}
		public void setSummary(String summary) {
			this.summary = summary;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((experience == null) ? 0 : experience.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((skillId == null) ? 0 : skillId.hashCode());
			result = prime * result + ((summary == null) ? 0 : summary.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Skill other = (Skill) obj;
			if (experience == null) {
				if (other.experience != null)
					return false;
			} else if (!experience.equals(other.experience))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (skillId == null) {
				if (other.skillId != null)
					return false;
			} else if (!skillId.equals(other.skillId))
				return false;
			if (summary == null) {
				if (other.summary != null)
					return false;
			} else if (!summary.equals(other.summary))
				return false;
			if (type == null) {
				if (other.type != null)
					return false;
			} else if (!type.equals(other.type))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Skill [skillId=" + skillId + ", name=" + name + ", type=" + type + ", experience=" + experience
					+ ", summary=" + summary + "]";
		}
		
}
