package cl.inacap.auth.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.inacap.auth.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

		User findByEmail(String email);
}
