package ci.kossovo.ecole.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ci.kossovo.ecole.entity.Role;
import ci.kossovo.ecole.entity.User;
import java.lang.String;
import java.util.List;

public interface UsersRepository extends JpaRepository<User, Long> {

	List<User> findByLogin(String login);

	// liste role par id
	@Query("select ur.role from UserRole ur where ur.user.id=?1")
	List<Role> getRoles(Long id);

	@Query("select ur.role from UserRole ur where ur.user.login=?1 and ur.user.password=?2")
	List<Role> getRoles(String login, String password);

}
