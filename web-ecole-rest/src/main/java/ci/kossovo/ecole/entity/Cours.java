//
// This file was generated by the JPA Modeler
//
package ci.kossovo.ecole.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_COURS")
public class Cours extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_sale")
	private Sale sale;

	@Column(name = "id_sale", insertable = false, updatable = false)
	private long idSale;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCour;

	private int duree;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_matiere")
	private Matiere matiere;

	@Column(name = "id_matiere", insertable = false, updatable = false)
	private long idMatiere;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_promotion")
	private Promotion promotion;

	@Column(name = "id_promotion", insertable = false, updatable = false)
	private long idPromotion;

	public Cours() {

	}

	public Cours(Date dateCour, int duree) {
		super();
		this.dateCour = dateCour;
		this.duree = duree;
	}


	@Override
	public String toString() {
		return String.format("Cours[%s,%s,%s,%s,%s]", idSale,dateCour,duree, idMatiere,idPromotion);
	}
	
	public Sale getSale() {
		return this.sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Date getDateCour() {
		return this.dateCour;
	}

	public void setDateCour(Date dateCour) {
		this.dateCour = dateCour;
	}

	public int getDuree() {
		return this.duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Matiere getMatiere() {
		return this.matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Promotion getPromotion() {
		return this.promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public long getIdSale() {
		return idSale;
	}

	public void setIdSale(long idSale) {
		this.idSale = idSale;
	}

	public long getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(long idMatiere) {
		this.idMatiere = idMatiere;
	}

	public long getIdPromotion() {
		return idPromotion;
	}

	public void setIdPromotion(long idPromotion) {
		this.idPromotion = idPromotion;
	}

}
