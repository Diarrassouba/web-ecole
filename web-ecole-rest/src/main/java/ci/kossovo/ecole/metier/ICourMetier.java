package ci.kossovo.ecole.metier;

import ci.kossovo.ecole.entity.Cours;
import ci.kossovo.ecole.entity.EtudiantCours;

public interface ICourMetier extends IMetier<Cours, Long> {
	
	public EtudiantCours absence(Long idCour , Long idEtudiant, boolean absence, String motif);

}
