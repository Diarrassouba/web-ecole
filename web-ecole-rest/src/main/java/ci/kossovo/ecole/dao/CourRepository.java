package ci.kossovo.ecole.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.kossovo.ecole.entity.Cours;

public interface CourRepository extends JpaRepository<Cours, Long> {

}
