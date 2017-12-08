package code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableCircuitBreaker
public class RunningLocationUpdaterApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RunningLocationUpdaterApplication.class, args);
    }

}
