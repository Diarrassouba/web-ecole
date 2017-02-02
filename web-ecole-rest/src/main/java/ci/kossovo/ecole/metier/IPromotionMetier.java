package ci.kossovo.ecole.metier;

import ci.kossovo.ecole.entity.Enseigne;
import ci.kossovo.ecole.entity.EtudiantPomo;
import ci.kossovo.ecole.entity.Promotion;

public interface IPromotionMetier extends IMetier<Promotion, Long> {
	public EtudiantPomo affecterEtudiant(Long idPromo, Long idEtudiant, int annee );
	public Enseigne affecterEnseigMat(Long idPromo, Long idEnseignant,Long idMatiere);

}
