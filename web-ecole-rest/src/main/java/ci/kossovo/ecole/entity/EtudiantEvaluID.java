package ci.kossovo.ecole.entity;

import java.io.Serializable;

public class EtudiantEvaluID implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id_etudiant;
	private Long id_evaluation;

	public EtudiantEvaluID() {
		super();

	}

	public EtudiantEvaluID(Long id_etudiant, Long id_evaluation) {
		super();
		this.id_etudiant = id_etudiant;
		this.id_evaluation = id_evaluation;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (long) id_etudiant;
		hash += (long) id_evaluation;

		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof EtudiantEvaluID)) {
			return false;
		}
		EtudiantEvaluID other = (EtudiantEvaluID) obj;
		if (this.id_etudiant != other.id_etudiant) {
			return false;
		}
		if (this.id_evaluation != other.id_evaluation) {
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

	public Long getId_evaluation() {
		return id_evaluation;
	}

	public void setId_evaluation(Long id_evaluation) {
		this.id_evaluation = id_evaluation;
	}

}
