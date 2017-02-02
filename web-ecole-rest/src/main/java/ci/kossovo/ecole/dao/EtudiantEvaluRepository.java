package ci.kossovo.ecole.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.kossovo.ecole.entity.EtudiantEvalu;
import ci.kossovo.ecole.entity.EtudiantEvaluID;

public interface EtudiantEvaluRepository extends JpaRepository<EtudiantEvalu, EtudiantEvaluID> {

}
