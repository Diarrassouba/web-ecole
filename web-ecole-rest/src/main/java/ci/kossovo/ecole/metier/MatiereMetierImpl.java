package ci.kossovo.ecole.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.kossovo.ecole.dao.MatiereRepository;
import ci.kossovo.ecole.entity.Matiere;

@Service
public class MatiereMetierImpl implements IMatiereMetier {
	@Autowired
	private MatiereRepository matiereRepository;

	@Override
	public Matiere creer(Matiere entity) {
		return matiereRepository.save(entity);
	}

	@Override
	public Matiere modifier(Matiere entity) {
		return matiereRepository.save(entity);
	}

	@Override
	public Matiere find(Long id) {
		return matiereRepository.findOne(id);
	}

	@Override
	public List<Matiere> findAll() {
		return matiereRepository.findAll();
	}

	@Override
	public void spprimer(List<Matiere> entities) {
		matiereRepository.delete(entities);

	}

	@Override
	public boolean supprimer(Long id) {
		matiereRepository.delete(id);
		return true;
	}

	@Override
	public boolean existe(Long id) {
		return matiereRepository.exists(id);
	}

	@Override
	public Long compter() {
		return matiereRepository.count();
	}

}
