package ma.emsi.rentingCarApp.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.emsi.rentingCarApp.entities.Notification;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long> {

}
