package ma.inpt.rentingCarApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Arrays;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CarRentingApplication {

	public static Logger Logger = LoggerFactory.getLogger(CarRentingApplication.class);
	
	@PostConstruct
	public void init() {
		Logger.info("Application started ...");
	}
	
    // class methods :
    public static void main(String[] args) {
    	Logger.info("Application executed ....");
        SpringApplication.run(CarRentingApplication.class, args);
    }

    
}