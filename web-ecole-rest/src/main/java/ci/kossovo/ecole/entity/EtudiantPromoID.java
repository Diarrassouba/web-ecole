package ci.kossovo.ecole.entity;

import java.io.Serializable;

public class EtudiantPromoID implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id_etudiant;
	private Long id_promotion;
	private Long annee;

	public EtudiantPromoID() {
		super();

	}

	public EtudiantPromoID(Long id_etudiant, Long id_promotion, Long annee) {
		super();
		this.id_etudiant = id_etudiant;
		this.id_promotion = id_promotion;
		this.annee = annee;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (long) id_etudiant;
		hash += (long) id_promotion;
		hash += (long) annee;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof EtudiantPromoID)) {
			return false;
		}
		EtudiantPromoID other = (EtudiantPromoID) obj;
		if (this.id_etudiant != other.id_etudiant) {
			return false;
		}
		if (this.id_promotion != other.id_promotion) {
			return false;
		}
		if (this.annee != other.annee) {
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

	public Long getId_promotion() {
		return id_promotion;
	}

	public void setId_promotion(Long id_promotion) {
		this.id_promotion = id_promotion;
	}

	public Long getAnnee() {
		return annee;
	}

	public void setAnnee(Long annee) {
		this.annee = annee;
	}

}
