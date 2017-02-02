package ci.kossovo.ecole.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.kossovo.ecole.entity.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {

}
