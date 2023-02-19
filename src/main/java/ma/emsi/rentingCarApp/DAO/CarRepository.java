package ma.emsi.rentingCarApp.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.emsi.rentingCarApp.entities.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

}
