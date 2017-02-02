package ci.kossovo.ecole.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.kossovo.ecole.dao.SaleRepository;
import ci.kossovo.ecole.entity.Sale;

@Service
public class SaleMetierImpl implements ISaleMetier {
	
	@Autowired
	private SaleRepository saleRepository;

	@Override
	public Sale creer(Sale entity) {
		return saleRepository.save(entity);
	}

	@Override
	public Sale modifier(Sale entity) {
		return saleRepository.save(entity);
	}

	@Override
	public Sale find(Long id) {
		return saleRepository.findOne(id);
	}

	@Override
	public List<Sale> findAll() {
		return saleRepository.findAll();
	}

	@Override
	public void spprimer(List<Sale> entities) {
		saleRepository.delete(entities);

	}

	@Override
	public boolean supprimer(Long id) {
		saleRepository.delete(id);;
		return true;
	}

	@Override
	public boolean existe(Long id) {
		return saleRepository.exists(id);
	}

	@Override
	public Long compter() {
		return saleRepository.count();
	}

}
