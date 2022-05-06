package com.zemoga.portafolio.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "portfolio")
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

  @Column(name = "tittle")
  private String tittle;

  @Column(name = "twitter_user")
  private String twitterUsername;

  public long getIdPortfolio() {
    return idPortfolio;
  }

  public void setIdPortfolio(long idPortfolio) {
    this.idPortfolio = idPortfolio;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getNames() {
    return names;
  }

  public void setNames(String names) {
    this.names = names;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getLastNames() {
    return lastNames;
  }

  public void setLastNames(String lastNames) {
    this.lastNames = lastNames;
  }

  public String getExperienceSummary() {
    return experienceSummary;
  }

  public void setExperienceSummary(String experienceSummary) {
    this.experienceSummary = experienceSummary;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getTittle() {
    return tittle;
  }

  public void setTittle(String tittle) {
    this.tittle = tittle;
  }

  public String getTwitterUsername() {
    return twitterUsername;
  }

  public void setTwitterUsername(String twitterUsername) {
    this.twitterUsername = twitterUsername;
  }
}
