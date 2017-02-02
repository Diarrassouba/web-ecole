package ci.kossovo.ecole.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.kossovo.ecole.entity.Enseigne;
import ci.kossovo.ecole.entity.EnseigneID;

public interface EnseigneRepository extends JpaRepository<Enseigne, EnseigneID> {

}
