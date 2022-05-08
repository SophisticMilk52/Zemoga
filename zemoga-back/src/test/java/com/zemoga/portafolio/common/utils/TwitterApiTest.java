package com.zemoga.portafolio.common.utils;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import twitter4j.TwitterException;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TwitterApiTest {

  @InjectMocks private TwitterApi TwitterApi;

  @Before
  public void init() {
    ReflectionTestUtils.setField(TwitterApi, "consumerKey", "KRy7l0v8wex3w8Sy5zThai3Ea");
    ReflectionTestUtils.setField(
        TwitterApi, "consumerSecret", "X2eBm0Y21kYEuR74W3Frqc2JVIizOj8Q1EVGatDsEVVEJo0ucu");
    ReflectionTestUtils.setField(
        TwitterApi, "accessToken", "1220032047516921859-otvXjhExyUTZ5GLxssc9h5ORqtPZja");
    ReflectionTestUtils.setField(
        TwitterApi, "accessTokenSecret", "tmJKqM4ORfQW6CH7wIVV8uKNpmSEmeFAP8lYwGb19uYjj");
  }

  @Test
  public void consumeTwitterApiTest() throws TwitterException {
    assertNotNull(TwitterApi.consumeTwitterApi("Alejandro"));
  }
}
