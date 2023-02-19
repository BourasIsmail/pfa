package ma.emsi.rentingCarApp.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.emsi.rentingCarApp.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
