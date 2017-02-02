package ci.kossovo.ecole.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_USERS")

public class User extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	private String login;
	private String password;
	private Boolean enabled;

	@OneToOne
	@JoinColumn(name = "id_personne")
	private Personne personne;

	@Column(name = "id_personne", insertable = false, updatable = false)
	private long id_personne;

	public User() {

	}

	public User(String password, String login, Boolean enabled) {
		super();
		this.password = password;
		this.login = login;
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return String.format("User[%s,%s,%s,%s]",login,password,enabled,id_personne);
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Boolean isEnabled() {
		return this.enabled;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
