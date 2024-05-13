package io.github.jonata03.springdocker;

import jdk.jfr.Registered;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringDockerApplication {
    private static final Logger log = LoggerFactory.getLogger(SpringDockerApplication.class);

    @GetMapping("/")
    public String hello(){
        return "hello";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDockerApplication.class, args);
    }

}
