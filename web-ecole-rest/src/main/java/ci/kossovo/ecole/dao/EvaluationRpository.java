package ci.kossovo.ecole.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.kossovo.ecole.entity.Evaluation;

public interface EvaluationRpository extends JpaRepository<Evaluation, Long> {

}
