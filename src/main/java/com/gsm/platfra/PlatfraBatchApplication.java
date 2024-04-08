package com.gsm.platfra;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableBatchProcessing
@EnableJpaAuditing
@SpringBootApplication
public class PlatfraBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatfraBatchApplication.class, args);
    }

}
