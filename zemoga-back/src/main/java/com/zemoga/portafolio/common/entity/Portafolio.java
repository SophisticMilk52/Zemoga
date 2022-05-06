package com.zemoga.portafolio.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Portafolio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Portafolio {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long idPortfolio;

  @Column(name = "name")
  private String name;

  @Column(name = "experience")
  private String experience;

  @Column(name = "image_url")
  private String image;

  @Column(name = "tittle")
  private String tittle;

  @Column(name = "description")
  private String description;

  @Column(name = "twitter_user_id")
  private String twitterUserId;
}
