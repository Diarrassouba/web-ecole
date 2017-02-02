package ci.kossovo.ecole.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.kossovo.ecole.dao.CourRepository;
import ci.kossovo.ecole.dao.EtudiantCourRepository;
import ci.kossovo.ecole.entity.Cours;
import ci.kossovo.ecole.entity.EtudiantCours;

@Service
public class CourMetierImpl implements ICourMetier {
	
	@Autowired
	private CourRepository courRepository;
	@Autowired
	private EtudiantCourRepository etudiantCourRepository;

	@Override
	public Cours creer(Cours entity) {
		return courRepository.save(entity);
	}

	@Override
	public Cours modifier(Cours entity) {
		return courRepository.save(entity);
	}

	@Override
	public Cours find(Long id) {
		return courRepository.findOne(id);
	}

	@Override
	public List<Cours> findAll() {
		return courRepository.findAll();
	}

	@Override
	public void spprimer(List<Cours> entities) {
		courRepository.delete(entities);

	}

	@Override
	public boolean supprimer(Long id) {
		courRepository.delete(id);
		return true;
	}

	@Override
	public boolean existe(Long id) {
		return courRepository.exists(id);
	}

	@Override
	public Long compter() {
		return courRepository.count();
	}

	@Override
	public EtudiantCours absence(Long idCour, Long idEtudiant, boolean absence, String motif) {
		return etudiantCourRepository.save(new EtudiantCours(idEtudiant, idCour, absence, motif));
	}

}
