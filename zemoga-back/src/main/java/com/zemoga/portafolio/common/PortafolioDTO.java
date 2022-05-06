package com.zemoga.portafolio.common;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PortafolioDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long idPortfolio;

  private String name;

  private String experience;

  private String image;

  private String tittle;

  private String description;

  private String twitterUserId;
}
