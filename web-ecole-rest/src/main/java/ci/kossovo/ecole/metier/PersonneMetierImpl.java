package ci.kossovo.ecole.metier;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.kossovo.ecole.dao.EnseigneRepository;
import ci.kossovo.ecole.dao.PersonneRepository;
import ci.kossovo.ecole.entity.Enseigne;
import ci.kossovo.ecole.entity.Etudiant;
import ci.kossovo.ecole.entity.Personne;
import ci.kossovo.ecole.exceptions.InvalidPersonneException;

@Service
public class PersonneMetierImpl implements IPersonneMetier {

	@Autowired
	private PersonneRepository personneRepository;
	@Autowired
	private EnseigneRepository enseigneRepository;

	@Override
	public Personne creer(Personne entity) throws InvalidPersonneException {
		if (entity.getNom() == null ||entity.getNom()=="" || entity.getPrenom() == null ||entity.getPrenom()==""
				|| entity.getNumCni() == null || entity.getNumCni()=="") {
			throw new InvalidPersonneException("Le nom, prenom ou numCni ne peut etre null");
		};

		try {
			Personne p = personneRepository.findByNumCni(entity.getNumCni());
			if (p != null)
				throw new InvalidPersonneException("Cette personne existe dejà.");
		} catch (Exception e) {
			throw new InvalidPersonneException("Probleme de connexion db");
		}

		return personneRepository.save(entity);
	}

	@Override
	public Personne modifier(Personne entity) throws InvalidPersonneException {
		Personne p = personneRepository.findByNumCni(entity.getNumCni());
		if (p!=null && entity.getId()!= p.getId()) {
			
				throw new InvalidPersonneException("Cet indentifiant cni existe dejà.");
		}

		return personneRepository.save(entity);
	}

	@Override
	public Personne find(Long id) {
		return personneRepository.findOne(id);
	}

	@Override
	public List<Personne> findAll() {
		return personneRepository.findAll();
	}
	
	//liste de personnes par type
	@Override
	public List<Personne> personneAll(String type) {
		List<Personne> personnes=personneRepository.findAll();
		//filtre par type de personnes
		List<Personne> typePersonnes=personnes.stream().filter(
				p-> p.getType().equals(type)).collect(Collectors.toList());
		return typePersonnes;
	}

	@Override
	public void spprimer(List<Personne> entities) {
		personneRepository.delete(entities);

	}

	@Override
	public boolean supprimer(Long id) {
		personneRepository.delete(id);
		return true;
	}

	@Override
	public boolean existe(Long id) {
		return personneRepository.exists(id);
	}

	@Override
	public Long compter() {
		return personneRepository.count();
	}

	@Override
	public Personne chercherParMatricule(String matricule) {
		return personneRepository.getMatriculeIgnoreCase(matricule);
	}

	@Override
	public List<Personne> chercherParStatus(String status) {
		return personneRepository.getStatusIgnoreCase(status);
	}

	@Override
	public List<Personne> chercherEtudiantParMc(String mc) {
		return personneRepository.findAllEtudiantParMc(mc);
	}

	@Override
	public List<Personne> chercherEnseignantParMc(String mc) {
		return personneRepository.findAllEnseignantParMc(mc);
	}

	@Override
	public List<Personne> chercherAdministrateurParMc(String mc) {
		return personneRepository.findAllAdministrateurParMc(mc);
	}

	@Override
	public List<Personne> chercherUserParMc(String mc) {
		return personneRepository.findByNomCompletContainingIgnoreCase(mc);
	}

	@Override
	public List<Etudiant> listEtudiants() {
		return personneRepository.findAllEtudiant();
	}

	@Override
	public List<Personne> listEnseignants() {
		return personneRepository.findByType("EN");
	}

	@Override
	public List<Personne> listAdministrateurs() {
		return personneRepository.findByType("AD");
	}

	@Override
	public List<Personne> userAll() {
		return personneRepository.findAll();
	}

	@Override
	public List<Personne> chercherParFonction(String fonction) {
		return personneRepository.getFonctionIgnoreCase(fonction);
	}

	@Override
	public Enseigne affecterPromgMat(Long idEnseignant, Long idPromo, Long idMatiere) {

		return enseigneRepository.save(new Enseigne(idEnseignant, idPromo, idMatiere));
	}

	@Override
	public Personne chercherParIdentifiantS(String numCni) {
		return personneRepository.findByNumCni(numCni);
	}

	@Override
	public List<Personne> personneAll() {
		return personneRepository.findByType("PE");
	}

	

}
