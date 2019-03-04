package com.csj.ceshi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author
 */
@SpringBootApplication
@EnableScheduling
public class CeshiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CeshiApplication.class, args);
    }
}
