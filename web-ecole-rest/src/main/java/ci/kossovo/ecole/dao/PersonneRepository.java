package ci.kossovo.ecole.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ci.kossovo.ecole.entity.Etudiant;
import ci.kossovo.ecole.entity.Personne;
import java.lang.String;

public interface PersonneRepository extends JpaRepository<Personne, Long> {

	List<Personne> findByNomCompletContainingIgnoreCase(String mc);

	@Query("select e from Etudiant e where upper(e.matricule)=UPPER(?1)")
	Personne getMatriculeIgnoreCase(String matricule);

	@Query("select en from Enseignant en where UPPER(en.status)=UPPER(?1)")
	List<Personne> getStatusIgnoreCase(String status);

	@Query("select a from Administrateur a where UPPER(a.fonction)=UPPER(?1)")
	List<Personne> getFonctionIgnoreCase(String fonction);

	@Query("select e from Etudiant e")
	List<Etudiant> findAllEtudiant();

	@Query("select e from Etudiant e where e.nomComplet like %?1%")
	List<Personne> findAllEtudiantParMc(String mc);

	@Query("select e from Enseignant e where e.nomComplet like %?1%")
	List<Personne> findAllEnseignantParMc(String mc);

	@Query("select a from Administrateur a where a.nomComplet like %?1%")
	List<Personne> findAllAdministrateurParMc(String mc);

	List<Personne> findByType(String type);

	List<Personne> findByNomIgnoreCase(String nom);

	List<Personne> findByNomIgnoreCaseAndPrenomIgnoreCase(String nom, String prenom);

	List<Personne> findByTypeAndNomAndPrenom(String type, String nom, String prenom);

	Personne findByNumCni(String numcni);
}
