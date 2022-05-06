package com.zemoga.portafolio.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TwiterApi {
  @Autowired private RestTemplate restTemplate;

  @Autowired private Environment envirorment;
}
