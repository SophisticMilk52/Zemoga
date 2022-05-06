package com.zemoga.portafolio.common;

import java.io.Serializable;

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

  public static long getSerialversionuid() {
    return serialVersionUID;
  }
}
