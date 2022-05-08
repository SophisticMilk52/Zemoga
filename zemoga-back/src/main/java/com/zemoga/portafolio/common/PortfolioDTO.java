package com.zemoga.portafolio.common;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import twitter4j.Status;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PortfolioDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String description;

  private String names;

  private String email;

  private String lastNames;

  private String experienceSummary;

  private String image;

  private String tittle;

  private String twitterUsername;

  private List<Status> status;
}
