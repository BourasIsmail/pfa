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

    @Bean
    CommandLineRunner runner() {
        return args -> {
        	
        	logger.info("Filling Database and tests started ...");

            User user1 = new User("ismail", pwEncoder.encode("ismail"), "ismail@gmail.com", "Ismail", "Bouras", "44 RUE CAMERON, Diour Jamaa", "06-00000", "Rabat");
            user1.setRole("ROLE_ADMIN");

            User user2 = new User("houda", pwEncoder.encode("houda"), "houda@gmail.com", "Houda", "El-Jonhy", "meknes meknes", "06- ... ", "meknes");
            user2.setRole("ROLE_EMPLOYEE");

            User user3 = new User("aa", pwEncoder.encode("aa"), "aa@gmail.com", "aa", "bb", "4,rue, avenue place", "0682670018", "Fes");
            user3.setRole("ROLE_USER");

            User user4 = new User("admin", pwEncoder.encode("admin"), "admin@gmail.com", "Admin", "Admin", "el 1   33333333333 21 3, lot 6", "07-000000", "Rabat");
            user4.setRole("ROLE_ADMIN");


            User user5 = new User("zaid", pwEncoder.encode("zaid"), "zaid@gmail.com", "zaid", "riahi", "Agdal", "06-12347895", "Tetouan");
            User user6 = new User("reda", pwEncoder.encode("reda"), "Reda@gmail.com", "reda", "ichchou", "wifaaq", "06-0000100", "Temara");
            User user7 = new User("yassin", pwEncoder.encode("yassin"), "yassin@gmail.com", "Yassin", "Kartouti", "Saléé ,place", "06-4568162", "Oujda");
            User user8 = new User("simo", pwEncoder.encode("simo"), "simo@gmail.com", "Mohamed", "Chniwi", "wiffaaq", "06-014000", "Temara");
            User user9 = new User("allo", pwEncoder.encode("allo"), "allo@gmail.com", "allo allo allo", "aloo", "allo", "06-11111", "Casa");
            

            userService.save(user1);
            userService.save(user2);
            userService.save(user3);
            userService.save(user4);
            userService.save(user5);
            userService.save(user6);
            userService.save(user7);
            userService.save(user8);
            userService.save(user9);


            Car car1 = new Car("Corolla : Toyota", "Fournisseur 1", 2001, 1);
            Car car2 = new Car("308 : Peugeot", "Fournisseur 1", 2000, 1);
            Car car3 = new Car("Tucson : Hyundai", "Fournisseur 1", 2012, 3);
            Car car4 = new Car("Focus : Ford", "Fournisseur 1", 2007, 2);
            Car car5 = new Car("Astra : Opel", "Fournisseur 1", 2013, 3);
            Car car6 = new Car("CLA : Mercedes", "Fournisseur 1", 1002, 2);
            Car car7 = new Car("Logan : Dacia", "Fournisseur 1", 2002, 2);
            Car car8 = new Car("Clio4 : Renault", "Fournisseur 1", 2011, 1);
            Car car9 = new Car("308 : Peugeot", "Fournisseur 1", 2009, 1);
            Car car10 = new Car("Golf : VolksWagen", "Fournisseur 1", 2015, 3);
            Car car11 = new Car("Fabia : SKoda", "Fournisseur 1", 2005, 1);
            Car car12 = new Car("Uno : Fiat", "Fournisseur 1", 2008, 1);
            Car car13 = new Car("Punto : Fiat", "Fournisseur 2", 2000, 2);
            Car car14 = new Car("Kuga : Ford", "Fournisseur 2", 2001, 3);
            Car car15 = new Car("ClasseE : Mercedes", "Fournisseur 2", 2005, 3);
            Car car16 = new Car("Tiguan : VolksWagen", "Fournisseur 2", 2016, 2);
            Car car17 = new Car("Evoque : RangeRover", "Fournisseur 2", 2014, 1);
            Car car18 = new Car("Fiesta : Ford", "Fournisseur 2", 2012, 2);
            Car car19 = new Car("Micra : Nissan", "Fournisseur 2", 2009, 2);
            Car car20 = new Car("Qashqai : Nissan", "Fournisseur 2", 2016, 3);
            Car car21 = new Car("Megane : Renault", "Fournisseur 2", 2006, 3);
            Car car22 = new Car("Leon : Seat", "Fournisseur 2", 2015, 1);
            Car car23 = new Car("Picanto : Kia", "Fournisseur 2", 2001, 2);
            Car car24 = new Car("Micra : Nissan", "Fournisseur 3", 2017, 3);
            Car car25 = new Car("500 : Fiat", "Fournisseur 3", 2016, 1);
            Car car26 = new Car("X5 : BMW", "Fournisseur 3", 2009, 1);
            Car car27 = new Car("Q8 : Audi", "Fournisseur 3", 2011, 1);
            Car car28 = new Car("A4 : Audi", "Fournisseur 3", 2010, 2);
            Car car29 = new Car("508 : Peugeot", "Fournisseur 3", 2017, 3);
            Car car30 = new Car("Ibiza : Seat", "Fournisseur 3", 2013, 1);
            Car car31 = new Car("Corsa : Opel", "Fournisseur 3", 2014, 1);
            Car car32 = new Car("C3 : Citroen", "Fournisseur 3", 2009, 2);
            Car car33 = new Car("C4 : Citroen", "Fournisseur 3", 2020, 3);
            Car car34 = new Car("XC60 : VOLVO", "Fournisseur 3", 2019, 3);
            Car car35 = new Car("Fiesta : Ford", "Fournisseur 3", 2016, 3);

            carService.save(car1);
            carService.save(car2);
            carService.save(car3);
            carService.save(car4);
            carService.save(car5);
            carService.save(car6);
            carService.save(car7);
            carService.save(car8);
            carService.save(car9);
            carService.save(car10);
            carService.save(car11);
            carService.save(car12);
            carService.save(car13);
            carService.save(car14);
            carService.save(car15);
            carService.save(car16);
            carService.save(car17);
            carService.save(car18);
            carService.save(car19);
            carService.save(car20);
            carService.save(car21);
            carService.save(car22);
            carService.save(car23);
            carService.save(car24);
            carService.save(car25);
            carService.save(car26);
            carService.save(car27);
            carService.save(car28);
            carService.save(car29);
            carService.save(car30);
            carService.save(car31);
            carService.save(car32);
            carService.save(car33);
            carService.save(car34);
            carService.save(car35);

            car10.setTheUser(user3);
            car10.setReturnDate(LocalDate.of(2021, 5, 23));

            car34.setTheUser(user5);
            car34.setReturnDate(LocalDate.of(2021, 12, 28));

            car1.setTheUser(user3);
            car1.setReturnDate(LocalDate.of(2021, 5, 05));

            user3.setCars(Arrays.asList(car10, car1));

            carService.save(car1);
            carService.save(car10);
            userService.save(user3);
            
         

            midAppRef.midnightApplicationRefresher();
            logger.info("Tests ended ...");
        };
    }
}