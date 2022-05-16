package com.quintrix.james.restdemo.config;

import java.time.Duration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

  // The value for timeOut is in the application.yml file.
  @Value("${config.timeOut}")
  Integer timeOut;

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {

    return builder.setConnectTimeout(Duration.ofMillis(timeOut))
        .setReadTimeout(Duration.ofMillis(5000)).build();
  }
}
