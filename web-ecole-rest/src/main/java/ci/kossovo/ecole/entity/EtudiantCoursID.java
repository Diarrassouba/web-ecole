package ci.kossovo.ecole.entity;

import java.io.Serializable;

public class EtudiantCoursID implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id_etudiant;
	private Long id_cours;

	public EtudiantCoursID() {
		super();

	}

	public EtudiantCoursID(Long id_etudiant, Long id_cours) {
		super();
		this.id_etudiant = id_etudiant;
		this.id_cours = id_cours;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (long) id_etudiant;
		hash += (long) id_cours;

		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof EtudiantCoursID)) {
			return false;
		}
		EtudiantCoursID other = (EtudiantCoursID) obj;
		if (this.id_etudiant != other.id_etudiant) {
			return false;
		}
		if (this.id_cours != other.id_cours) {
			return false;
		}

		return true;
	}

	public Long getId_etudiant() {
		return id_etudiant;
	}

	public void setId_etudiant(Long id_etudiant) {
		this.id_etudiant = id_etudiant;
	}

	public Long getId_cours() {
		return id_cours;
	}

	public void setId_cours(Long id_cours) {
		this.id_cours = id_cours;
	}

}
