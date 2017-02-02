package ci.kossovo.ecole.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ci.kossovo.ecole.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}
