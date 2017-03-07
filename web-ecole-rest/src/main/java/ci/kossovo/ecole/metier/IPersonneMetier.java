package ci.kossovo.ecole.metier;

import java.util.List;

import ci.kossovo.ecole.entity.Enseigne;
import ci.kossovo.ecole.entity.Etudiant;
import ci.kossovo.ecole.entity.Personne;

public interface IPersonneMetier extends IMetier<Personne, Long> {
	
	public Personne chercherParMatricule(String matricule);
	public Personne chercherParIdentifiantS(String numCni);
	public List<Personne> chercherParStatus(String status);
	public List<Personne> chercherParFonction(String fonction);
	public List<Personne> chercherEtudiantParMc(String mc);
	public List<Personne> chercherEnseignantParMc(String mc);
	public List<Personne> chercherAdministrateurParMc(String mc);
	public List<Personne> chercherUserParMc(String mc);
	public List<Etudiant> listEtudiants();
	public List<Personne> listEnseignants();
	public List<Personne> listAdministrateurs();
	public List<Personne> userAll();
	public List<Personne> personneAll();
	public List<Personne> personneAll(String type);
	
	public Enseigne affecterPromgMat(Long idEnseignant, Long idPromo,Long idMatiere);
	

}
