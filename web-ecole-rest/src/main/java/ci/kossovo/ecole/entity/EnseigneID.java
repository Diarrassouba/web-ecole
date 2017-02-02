package ci.kossovo.ecole.entity;

import java.io.Serializable;

public class EnseigneID implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id_enseignant;
	private Long id_promotion;
	private Long id_matiere;

	public EnseigneID() {
		super();

	}

	public EnseigneID(Long id_enseignant, Long id_promotion, Long id_matiere) {
		super();
		this.id_enseignant = id_enseignant;
		this.id_promotion = id_promotion;
		this.id_matiere = id_matiere;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (long) id_enseignant;
		hash += (long) id_promotion;
		hash += (long) id_matiere;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof EnseigneID)) {
			return false;
		}
		EnseigneID other = (EnseigneID) obj;
		if (this.id_enseignant != other.id_enseignant) {
			return false;
		}
		if (this.id_promotion != other.id_promotion) {
			return false;
		}
		if (this.id_matiere != other.id_matiere) {
			return false;
		}
		return true;
	}

	public Long getId_enseignant() {
		return id_enseignant;
	}

	public void setId_enseignant(Long id_enseignant) {
		this.id_enseignant = id_enseignant;
	}

	public Long getId_promotion() {
		return id_promotion;
	}

	public void setId_promotion(Long id_promotion) {
		this.id_promotion = id_promotion;
	}

	public Long getId_matiere() {
		return id_matiere;
	}

	public void setId_matiere(Long id_matiere) {
		this.id_matiere = id_matiere;
	}

}
