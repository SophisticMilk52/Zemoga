package com.zemoga.portafolio.common.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Component
public class TwitterApi {
  @Value("${twitter.configuration.apiKey}")
  private String consumerKey;

  @Value("${twitter.configuration.secretKey}")
  private String consumerSecret;

  @Value("${twitter.configuration.accessToken}")
  private String accessToken;

  @Value("${twitter.configuration.secretToken}")
  private String accessTokenSecret;

  public List<Status> consumeTwitterApi(String name) throws TwitterException {
    ConfigurationBuilder builder = new ConfigurationBuilder();
    builder.setOAuthConsumerKey(consumerKey);
    builder.setOAuthConsumerSecret(consumerSecret);
    builder.setOAuthAccessToken(accessToken);
    builder.setOAuthAccessTokenSecret(accessTokenSecret);
    TwitterFactory factory = new TwitterFactory(builder.build());
    Twitter tw = factory.getInstance();
    List<Status> list = tw.getUserTimeline(name);
    return list;
  }
}
