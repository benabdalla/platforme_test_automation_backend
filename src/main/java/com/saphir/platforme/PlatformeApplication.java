package com.saphir.platforme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//@EnableJpaRepositories("com.saphir.platforme")
//@EntityScan("com.saphir.platforme")
@SpringBootApplication(scanBasePackages = {"com.saphir.platforme"})
//@SpringBootApplication
public class PlatformeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlatformeApplication.class, args);
	}





}
