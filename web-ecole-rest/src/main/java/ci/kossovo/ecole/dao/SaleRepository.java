package ci.kossovo.ecole.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.kossovo.ecole.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
