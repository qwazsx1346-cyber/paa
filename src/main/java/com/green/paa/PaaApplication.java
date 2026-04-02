package com.green.paa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class PaaApplication {

  public static void main(String[] args) {
    SpringApplication.run(PaaApplication.class, args);
  }

}
