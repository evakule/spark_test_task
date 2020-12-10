package model;

import java.io.Serializable;

public class SuicideInfoRecord implements Serializable {
  private String country;
  private String year;
  private String sex;
  private String age;

  private String amountOfSuicides;
  private String population;
  private String suicidesPer100k;
  private String countryAndYear;

  private String HDIForYear;
  private String GDPForYear;
  private String GDPPerOnePerson;
  private String generationType;

  public SuicideInfoRecord(
          String country,
          String year,
          String sex,
          String age,
          String amountOfSuicides,
          String population,
          String suicidesPer100k,
          String countryAndYear,
          String HDIForYear,
          String GDPForYear,
          String GDPPerOnePerson,
          String generationType
  ) {
    this.country = country;
    this.year = year;
    this.sex = sex;
    this.age = age;
    this.amountOfSuicides = amountOfSuicides;
    this.population = population;
    this.suicidesPer100k = suicidesPer100k;
    this.countryAndYear = countryAndYear;
    this.HDIForYear = HDIForYear;
    this.GDPForYear = GDPForYear;
    this.GDPPerOnePerson = GDPPerOnePerson;
    this.generationType = generationType;
  }

  public SuicideInfoRecord() {
  }

  public String getAmountOfSuicides() {
    return amountOfSuicides;
  }

  public String getCountryAndYear() {
    return countryAndYear;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public void setAmountOfSuicides(String amountOfSuicides) {
    this.amountOfSuicides = amountOfSuicides;
  }

  public String getPopulation() {
    return population;
  }

  public void setPopulation(String population) {
    this.population = population;
  }

  public String getSuicidesPer100k() {
    return suicidesPer100k;
  }

  public void setSuicidesPer100k(String suicidesPer100k) {
    this.suicidesPer100k = suicidesPer100k;
  }

  public void setCountryAndYear(String countryAndYear) {
    this.countryAndYear = countryAndYear;
  }

  public String getHDIForYear() {
    return HDIForYear;
  }

  public void setHDIForYear(String HDIForYear) {
    this.HDIForYear = HDIForYear;
  }

  public String getGDPForYear() {
    return GDPForYear;
  }

  public void setGDPForYear(String GDPForYear) {
    this.GDPForYear = GDPForYear;
  }

  public String getGDPPerOnePerson() {
    return GDPPerOnePerson;
  }

  public void setGDPPerOnePerson(String GDPPerOnePerson) {
    this.GDPPerOnePerson = GDPPerOnePerson;
  }

  public String getGenerationType() {
    return generationType;
  }

  public void setGenerationType(String generationType) {
    this.generationType = generationType;
  }
}
