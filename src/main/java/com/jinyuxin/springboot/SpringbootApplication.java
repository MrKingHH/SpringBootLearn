package com.jinyuxin.springboot;

import com.jinyuxin.springboot.entity.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class SpringbootApplication {
  public static final Logger logger =
          LoggerFactory.getLogger(SpringApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(SpringbootApplication.class, args);
  }

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder){
    return builder.build();
  }
  @Bean
  public CommandLineRunner run(RestTemplate restTemplate) {
    return args -> {
      Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
      logger.info(quote.toString());
    };
  }
//  @Bean
//  public CommandLineRunner run(RestTemplate restTemplate) {
//    return new CommandLineRunner() {
//      @Override
//      public void run(String... args) throws Exception {
//        Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
//       logger.info(quote.toString());
//      }
//    };
//  }

  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "world") String name) {
    return String.format("Hello, %s", name);
  }

}
