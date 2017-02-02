package ci.kossovo.ecole.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import ci.kossovo.ecole.entity.Administrateur;
import ci.kossovo.ecole.entity.Enseignant;
import ci.kossovo.ecole.entity.Etudiant;
import ci.kossovo.ecole.entity.Personne;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonneTest {
	@Autowired
	TestEntityManager entityManager;
	@Autowired
	PersonneRepository personneRepository;

	@Test
	public void findByType() {
		entityManager.persist(new Enseignant("Mme", "Koné", "Asta", "Active"));
		entityManager.persist(new Personne("Mme", "Koné", "Asta"));
		entityManager.persist(new Etudiant("Mme", "Diabaté", "Mawa", "E00102"));
		entityManager.persist(new Administrateur("Mme", "Bamba", "Asta", "Directeur"));

		List<Personne> ps = personneRepository.findByType("EN");
		assertThat(ps.size()).isEqualTo(1);

		List<Personne> ps1 = personneRepository.findByType("ET");
		assertThat(ps1.size()).isEqualTo(1);

		List<Personne> ps2 = personneRepository.findByType("PE");
		assertThat(ps2.size()).isEqualTo(1);

		List<Personne> ps3 = personneRepository.findByType("AD");
		assertThat(ps3.size()).isEqualTo(1);

		List<Personne> pes4 = personneRepository.findByType("CE");
		assertThat(pes4.size()).isEqualTo(0);

	}

	@Test
	public void getMatriculeIgnoreCase() {
		entityManager.persist(new Etudiant("Mme", "Koné", "Asta", "E00101"));
		Etudiant e = (Etudiant) personneRepository.getMatriculeIgnoreCase("e00101");
		assertThat(e.getMatricule()).isEqualTo("E00101");

	}

	@Test
	public void getStatusIgnoreCase() {
		entityManager.persist(new Enseignant("Mme", "Koné", "Asta", "Active"));
		List<Personne> ens = personneRepository.getStatusIgnoreCase("ACTIVE");
		assertThat(ens.size()).isEqualTo(1);
		Enseignant es = (Enseignant) ens.get(0);
		assertThat(es.getStatus()).isEqualTo("Active");
	}

	@Test
	public void findAllEtudiant() {
		entityManager.persist(new Personne("Mme", "Koné", "Asta"));
		entityManager.persist(new Etudiant("Mme", "Diabaté", "Mawa", "E00102"));
		entityManager.persist(new Enseignant("Mme", "Koné", "Asta", "Active"));
		List<Personne> ets = personneRepository.findAllEtudiant();
		assertThat(ets.size()).isEqualTo(1);

	}
	@Test
	public void deleteAll() {
		entityManager.persist(new Personne("Mme", "Koné", "Asta"));
		entityManager.persist(new Etudiant("Mme", "Diabaté", "Mawa", "E00102"));
		entityManager.persist(new Enseignant("Mme", "Koné", "Asta", "Active"));
		List<Personne> ets = personneRepository.findAll();
		personneRepository.delete(ets);
		List<Personne> ets1 = personneRepository.findAllEtudiant();
		assertThat(ets1.size()).isEqualTo(0);
		
	}

	@Test
	public void findAllEtudiantParMc() {
		entityManager.persist(new Personne("Mme", "Koné", "Asta"));
		entityManager.persist(new Etudiant("Mme", "Diabaté", "Mawa", "E00102"));
		entityManager.persist(new Enseignant("Mme", "Koné", "Asta", "Active"));
		List<Personne> ets1 = personneRepository.findAllEtudiantParMc("ko");
		assertThat(ets1.size()).isEqualTo(0);
		List<Personne> ets2 = personneRepository.findAllEtudiantParMc("Dia");
		assertThat(ets2.size()).isEqualTo(1);
		Etudiant e = (Etudiant) ets2.get(0);
		assertThat(e.getNom()).isEqualTo("Diabaté");

	}

	@Test
	public void findAllEnseignantParMc() {
		entityManager.persist(new Personne("Mme", "Koné", "Asta"));
		entityManager.persist(new Etudiant("Mme", "Diabaté", "Mawa", "E00102"));
		entityManager.persist(new Enseignant("Mme", "Koné", "Asta", "Active"));
		List<Personne> ets1 = personneRepository.findAllEnseignantParMc("Dia");
		assertThat(ets1.size()).isEqualTo(0);
		List<Personne> ets2 = personneRepository.findAllEnseignantParMc("Asta");
		assertThat(ets2.size()).isEqualTo(1);
		Enseignant e = (Enseignant) ets2.get(0);
		assertThat(e.getNom()).isEqualTo("Koné");

	}

	@Test
	public void findAllAdministrateurParMc() {
		entityManager.persist(new Personne("Mme", "Koné", "Asta"));
		entityManager.persist(new Etudiant("Mme", "Diabaté", "Mawa", "E00102"));
		entityManager.persist(new Administrateur("Mme", "Koné", "Asta", "Comptable"));
		List<Personne> ets1 = personneRepository.findAllAdministrateurParMc("Dia");
		assertThat(ets1.size()).isEqualTo(0);
		List<Personne> ets2 = personneRepository.findAllAdministrateurParMc("Asta");
		assertThat(ets2.size()).isEqualTo(1);
		Administrateur a = (Administrateur) ets2.get(0);
		assertThat(a.getFonction()).isEqualTo("Comptable");

	}

	@Test
	public void getFonctionIgnoreCase() {
		entityManager.persist(new Administrateur("Mme", "Koné", "Asta", "Comptable"));
		List<Personne> adm = personneRepository.getFonctionIgnoreCase("COMPTABLE");
		assertThat(adm.size()).isEqualTo(1);
		Administrateur ad = (Administrateur) adm.get(0);
		assertThat(ad.getFonction()).isEqualTo("Comptable");

	}

	@Test
	public void findByNom() {
		entityManager.persist(new Administrateur("Mme", "Koffi", "Asta", "Comptable"));
		List<Personne> pers = personneRepository.findByNomIgnoreCase("KOFFI");
		assertThat(pers.size()).isEqualTo(1);
		Personne p = pers.get(0);
		assertThat(p.getNom()).isEqualTo("Koffi");
	}

	@Test
	public void findByNomAndPrenomIgnoreCase() {
		entityManager.persist(new Administrateur("Mr", "Kaba", "Amara", "Comptable"));
		List<Personne> pers = personneRepository.findByNomIgnoreCaseAndPrenomIgnoreCase("KABA", "AMARA");
		assertThat(pers.size()).isEqualTo(1);
		Personne p = pers.get(0);
		assertThat(p.getNomComplet()).isEqualTo("Kaba Amara");
	}

	@Test
	public void findAllAndfindOneAndsave() {
		entityManager.persist(new Personne("Mme", "Koné", "Asta"));
		entityManager.persist(new Etudiant("Mme", "Diabaté", "Mawa", "E00102"));
		entityManager.persist(new Administrateur("Mme", "Koné", "Asta", "Comptable"));
		List<Personne> ets1 = personneRepository.findAll();
		assertThat(ets1.size()).isEqualTo(3);
		Long id = ets1.get(0).getId();
		Personne p = personneRepository.findOne(id);
		assertNotNull(p);
		p.setNom("Diarra");
		p = personneRepository.save(p);
		assertThat(p.getNom()).isEqualTo("Diarra");
		personneRepository.delete(id);
		assertThat(personneRepository.findAll().size()).isEqualTo(2);
		assertNull(personneRepository.findOne(id));
		assertNotNull(personneRepository.save(new Personne("Mme", "Koné", "Asta")));
		assertThat(personneRepository.findAll().size()).isEqualTo(3);
	}
	
	@Test
	public void findByNumCni(){
		entityManager.persist(new Personne("Mlle", "Camara", "Moussa", "CN00210045"));
		entityManager.persist(new Etudiant("Mr", "Gondo", "Jules", "CN00210050", "E00108"));
		entityManager.persist(new Personne("Mme", "Soro", "jean", "CN00210060"));
		
		Personne p =personneRepository.findByNumCni("CN00210050");
		assertNotNull(p);
		assertThat(p.getNumCni()).isEqualTo("CN00210050");
		assertThat(p.getNomComplet()).isEqualTo("Gondo Jules");
	}
	
/*
	@Test
	public void findByTypeAndByNomAndByPrenomAnd() {
		entityManager.persist(new Etudiant("Mme", "Diabaté", "Mawa", "E00105"));
		Personne ps = personneRepository.getMatriculeIgnoreCase("E00105");
		assertNotNull(ps);
		
		assertThat(ps.getType()).isEqualTo("ET");
		assertThat(ps.getNomComplet()).isEqualTo("Diabaté Mawa");

	}*/

}
