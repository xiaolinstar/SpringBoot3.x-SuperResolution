package com.xiaolin.superresolution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author xlxing
 */
@EnableAsync(proxyTargetClass = true)
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SuperResolutionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuperResolutionApplication.class, args);
    }

}
