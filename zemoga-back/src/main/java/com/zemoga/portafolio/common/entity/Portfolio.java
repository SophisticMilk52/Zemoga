package com.zemoga.portafolio.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "portfolio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Portfolio {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long idPortfolio;

  @Column(name = "description")
  private String description;

  @Column(name = "names")
  private String names;

  @Column(name = "email")
  private String email;

  @Column(name = "last_names")
  private String lastNames;

  @Column(name = "experience_summary")
  private String experienceSummary;

  @Column(name = "image_url")
  private String image;

  @Column(name = "title")
  private String tittle;

  @Column(name = "twitter_user_name")
  private String twitterUsername;
}
