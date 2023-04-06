package lab4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab41Application {
	
	public static void main(String[] args) {
		System.setProperty("error.whitelabel.enabled", "false");
		SpringApplication.run(Lab41Application.class, args);
	}

}
