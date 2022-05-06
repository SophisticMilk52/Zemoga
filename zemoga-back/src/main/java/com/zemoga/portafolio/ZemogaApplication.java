package com.zemoga.portafolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.zemoga.portafolio.common.repository")
@EntityScan("com.zemoga.portafolio.common.entity")
@PropertySource("classpath:application.properties")
@SpringBootApplication(scanBasePackages = {"com.zemoga.portafolio.*"})
public class ZemogaApplication {

  public static void main(String[] args) {
    SpringApplication.run(ZemogaApplication.class, args);
  }
}
