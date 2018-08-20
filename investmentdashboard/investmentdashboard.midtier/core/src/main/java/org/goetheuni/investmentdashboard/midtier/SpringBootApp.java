package org.goetheuni.investmentdashboard.midtier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.client.RestTemplate;

import io.oasp.module.jpa.dataaccess.api.AdvancedRevisionEntity;

/**
 * Main entry point of this {@link SpringBootApplication}. Simply run this class to start this app.
 */
@SpringBootApplication
@EntityScan(basePackages = { "org.goetheuni.investmentdashboard.midtier" }, basePackageClasses = {
AdvancedRevisionEntity.class })
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class SpringBootApp {

  /**
   * Entry point for spring-boot based app
   *
   * @param args - arguments
   */
  public static void main(String[] args) {

    SpringApplication.run(SpringBootApp.class, args);
  }

  /**
   * @return the {@link RestTemplate} by using the {@link RestTemplateBuilder}.
   */
  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {

    return builder.build();
  }
}
