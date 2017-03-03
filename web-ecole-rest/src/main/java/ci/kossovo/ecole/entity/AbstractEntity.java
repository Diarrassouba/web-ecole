package ci.kossovo.ecole.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public class AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	@Version
	protected Long version;

	public AbstractEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AbstractEntity(Long id, Long version) {
		super();
		this.id = id;
		this.version = version;
	}
	

 //Pour le teste	
	public AbstractEntity(Long id) {
		super();
		this.id = id;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		 return hash;
	}

	public AbstractEntity build(Long id, Long version) {
		 this.id = id;
		 this.version = version;
		 return this;
		}
	
	@Override
	public boolean equals(Object obj) {
		String class1 = this.getClass().getName();
		String class2 = obj.getClass().getName();
		 if (!class2.equals(class1) || obj==null) {
		return false;
		 }
		 AbstractEntity other = (AbstractEntity) obj;
		 return this.id.longValue() == other.id.longValue();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	

}
