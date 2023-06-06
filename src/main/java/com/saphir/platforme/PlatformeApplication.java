package com.saphir.platforme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableJpaRepositories("com.saphir.platforme")
//@EntityScan("com.saphir.platforme")
@SpringBootApplication(scanBasePackages = {"com.saphir.platforme"})
//@SpringBootApplication
public class PlatformeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformeApplication.class, args);
    }


}
