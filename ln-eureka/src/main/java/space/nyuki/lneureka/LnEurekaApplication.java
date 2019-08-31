package space.nyuki.lneureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class LnEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LnEurekaApplication.class, args);
    }

}
