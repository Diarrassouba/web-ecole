package ci.kossovo.ecole.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.kossovo.ecole.dao.FiliereRepository;
import ci.kossovo.ecole.entity.Filiere;

@Service 
public class FiliereMetierImpl implements IFiliereMetier {

	@Autowired
	private FiliereRepository filiereRepository;
	
	@Override
	public Filiere creer(Filiere entity) {
		return filiereRepository.save(entity);
	}

	@Override
	public Filiere modifier(Filiere entity) {
		return filiereRepository.save(entity);
	}

	@Override
	public Filiere find(Long id) {
		return filiereRepository.findOne(id);
	}

	@Override
	public List<Filiere> findAll() {
		return filiereRepository.findAll();
	}

	@Override
	public void spprimer(List<Filiere> entities) {
		filiereRepository.delete(entities);

	}

	@Override
	public boolean supprimer(Long id) {
		filiereRepository.delete(id);
		return true;
	}

	@Override
	public boolean existe(Long id) {
		return filiereRepository.exists(id);
	}

	@Override
	public Long compter() {
		return filiereRepository.count();
	}

}
