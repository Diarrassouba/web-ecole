//
// This file was generated by the JPA Modeler
//
package ci.kossovo.ecole.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="T_ETUDIANT_EVALU")
@IdClass(EtudiantEvaluID.class)
public class EtudiantEvalu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id_etudiant;
	@Id
	private Long id_evaluation;
	
	@Version
	private Long version;
	
	private double note;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "id_evaluation", insertable = false, updatable = false)
	private Evaluation evaluation;

	
	private Boolean absence;

	private String motif;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "id_etudiant", insertable = false, updatable = false)
	private Etudiant etudiant;

	

	public EtudiantEvalu() {

	}

	
	
	public EtudiantEvalu(double note, Boolean absence, String motif) {
		super();
		this.note = note;
		this.absence = absence;
		this.motif = motif;
	}



	public EtudiantEvalu(Long id_etudiant, Long id_evaluation, double note, Boolean absence, String motif) {
		super();
		this.id_etudiant = id_etudiant;
		this.id_evaluation = id_evaluation;
		this.note = note;
		this.absence = absence;
		this.motif = motif;
	}


	@Override
	public String toString() {
		return String.format("EtdiantEvalu[%s,%s,%s,%s,%s]", id_etudiant,id_evaluation,note, absence,motif);
	}

	public Double getNote() {
		return this.note;
	}

	public Boolean isAbsence() {
		return this.absence;
	}

	public void setAbsence(Boolean absence) {
		this.absence = absence;
	}

	

	public String getMotif() {
		return this.motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Etudiant getEtudiant() {
		return this.etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}


	public Boolean getAbsence() {
		return absence;
	}

	public void setNote(double note) {
		this.note = note;
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

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	

}