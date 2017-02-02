package ci.kossovo.ecole.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.kossovo.ecole.dao.EnseigneRepository;
import ci.kossovo.ecole.dao.EtudiantPromoRepository;
import ci.kossovo.ecole.dao.PromotionRepository;
import ci.kossovo.ecole.entity.Enseigne;
import ci.kossovo.ecole.entity.EtudiantPomo;
import ci.kossovo.ecole.entity.Promotion;

@Service
public class PromotionImpl implements IPromotionMetier {
	
	@Autowired
	private PromotionRepository promotionRepository;
	@Autowired
	private EnseigneRepository enseigneRepository;
	@Autowired
	private EtudiantPromoRepository etudPromoRepository;

	@Override
	public Promotion creer(Promotion entity) {
		return promotionRepository.save(entity);
	}

	@Override
	public Promotion modifier(Promotion entity) {
		return promotionRepository.save(entity);
	}

	@Override
	public Promotion find(Long id) {
		return promotionRepository.findOne(id);
	}

	@Override
	public List<Promotion> findAll() {
		return promotionRepository.findAll();
	}

	@Override
	public void spprimer(List<Promotion> entities) {
		promotionRepository.delete(entities);
	}

	@Override
	public boolean supprimer(Long id) {
		 promotionRepository.delete(id);
		 return true;
	}

	@Override
	public boolean existe(Long id) {
		return promotionRepository.exists(id);
	}

	@Override
	public Long compter() {
		return promotionRepository.count();
	}

	

	@Override
	public Enseigne affecterEnseigMat(Long idPromo, Long idEnseignant, Long idMatiere) {
		
		return enseigneRepository.save(new Enseigne(idEnseignant, idPromo, idMatiere));
	}

	@Override
	public EtudiantPomo affecterEtudiant(Long idPromo, Long idEtudiant, int annee) {
	
		return etudPromoRepository.save(new EtudiantPomo(idEtudiant, idPromo, annee));
	}

	

}
