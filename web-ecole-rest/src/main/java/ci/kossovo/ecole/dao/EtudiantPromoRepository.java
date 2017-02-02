package ci.kossovo.ecole.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.kossovo.ecole.entity.EtudiantPomo;
import ci.kossovo.ecole.entity.EtudiantPromoID;

public interface EtudiantPromoRepository extends JpaRepository<EtudiantPomo, EtudiantPromoID> {

}
