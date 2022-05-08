package com.zemoga.portafolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zemoga.portafolio.common.utils.TwitterApi;

@Configuration
public class Configurations {
  @Bean
  public TwitterApi twitterApi() {
    return new TwitterApi();
  }
}
