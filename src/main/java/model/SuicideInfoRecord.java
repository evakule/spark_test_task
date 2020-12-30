package model;

import java.io.Serializable;

public class SuicideInfoRecord implements Serializable {
  private String country;
  private String year;
  private String sex;
  private String age;

  private Integer amountOfSuicides;
  private String population;
  private Double suicidesPer100k;
  private String countryAndYear;

  private String HDIForYear;
  private String GDPForYear;
  private Integer GDPPerOnePerson;
  private String generationType;

  public SuicideInfoRecord(
          String country,
          String year,
          String sex,
          String age,
          Integer amountOfSuicides,
          String population,
          Double suicidesPer100k,
          String countryAndYear,
          String HDIForYear,
          String GDPForYear,
          Integer GDPPerOnePerson,
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

  public Integer getAmountOfSuicides() {
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

  public void setAmountOfSuicides(Integer amountOfSuicides) {
    this.amountOfSuicides = amountOfSuicides;
  }

  public String getPopulation() {
    return population;
  }

  public void setPopulation(String population) {
    this.population = population;
  }

  public Double getSuicidesPer100k() {
    return suicidesPer100k;
  }

  public void setSuicidesPer100k(Double suicidesPer100k) {
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

  public Integer getGDPPerOnePerson() {
    return GDPPerOnePerson;
  }

  public void setGDPPerOnePerson(Integer GDPPerOnePerson) {
    this.GDPPerOnePerson = GDPPerOnePerson;
  }

  public String getGenerationType() {
    return generationType;
  }

  public void setGenerationType(String generationType) {
    this.generationType = generationType;
  }

  @Override
  public String toString() {
    return "SuicideInfoRecord{" +
            "country='" + country + '\'' +
            ", year='" + year + '\'' +
            ", sex='" + sex + '\'' +
            ", age='" + age + '\'' +
            ", amountOfSuicides=" + amountOfSuicides +
            ", population='" + population + '\'' +
            ", suicidesPer100k=" + suicidesPer100k +
            ", countryAndYear='" + countryAndYear + '\'' +
            ", HDIForYear='" + HDIForYear + '\'' +
            ", GDPForYear='" + GDPForYear + '\'' +
            ", GDPPerOnePerson='" + GDPPerOnePerson + '\'' +
            ", generationType='" + generationType + '\'' +
            '}';
  }
}
