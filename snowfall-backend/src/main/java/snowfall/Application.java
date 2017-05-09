package snowfall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EntityScan
@EnableAutoConfiguration
@EnableAsync
@EnableScheduling
@Configuration
@SpringBootApplication
public class Application   {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
