package newWine.API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class NewWineApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewWineApiApplication.class, args);
	}

}
