package ma.inpt.rentingCarApp;

import ma.inpt.rentingCarApp.entities.Car;
import ma.inpt.rentingCarApp.entities.User;
import ma.inpt.rentingCarApp.services.CarService;
import ma.inpt.rentingCarApp.services.NotificationService;
import ma.inpt.rentingCarApp.services.UserService;
import ma.inpt.rentingCarApp.utils.MidnightApplicationRefresh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@SpringBootApplication
public class CarRentingApplication {
	
	public static Logger logger = LoggerFactory.getLogger(CarRentingApplication.class);
    // class attributes :
    final CarService carService;
    final UserService userService;
    final NotificationService notificationService;
    final BCryptPasswordEncoder pwEncoder;
    final MidnightApplicationRefresh midAppRef;

    // class constructor :
    public CarRentingApplication(CarService carService, UserService userService, NotificationService notificationService, BCryptPasswordEncoder pwEncoder, MidnightApplicationRefresh midAppRef) {
        this.carService = carService;
        this.userService = userService;
        this.notificationService = notificationService;
        this.pwEncoder = pwEncoder;
        this.midAppRef = midAppRef;
    }
    
    @PostConstruct
    public void init() {
    	logger.info("Appilcation started ...");
    }

    // class methods :
    public static void main(String[] args) {
        SpringApplication.run(CarRentingApplication.class, args);
    }

    
}