package ci.kossovo.ecole.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.kossovo.ecole.entity.Matiere;

public interface MatiereRepository extends JpaRepository<Matiere, Long> {

}
