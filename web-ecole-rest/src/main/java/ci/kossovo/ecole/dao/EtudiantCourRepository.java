package ci.kossovo.ecole.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.kossovo.ecole.entity.EtudiantCours;
import ci.kossovo.ecole.entity.EtudiantCoursID;

public interface EtudiantCourRepository extends JpaRepository<EtudiantCours, EtudiantCoursID> {

}
