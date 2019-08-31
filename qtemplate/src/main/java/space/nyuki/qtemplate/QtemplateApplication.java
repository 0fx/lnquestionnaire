package space.nyuki.qtemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication

public class QtemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(QtemplateApplication.class, args);
    }

}
