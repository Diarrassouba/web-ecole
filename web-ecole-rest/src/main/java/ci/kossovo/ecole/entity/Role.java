package ci.kossovo.ecole.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_ROLES")
public class Role extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	private String roleName;

	private String description;

	public Role() {

	}

	@Override
	public String toString() {
		return String.format("Role[%s]", roleName);
	}
	
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
