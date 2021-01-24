package model;

import java.io.Serializable;

public class CountryYearToSuicideAmountToGdp implements Serializable {
  private String countryYear;
  private Integer suicideAmount;
  private Integer gdpPerOnePerson;

  public CountryYearToSuicideAmountToGdp(
          String countryYear,
          Integer suicideAmount,
          Integer gdpPerOnePerson
  ) {
    this.countryYear = countryYear;
    this.suicideAmount = suicideAmount;
    this.gdpPerOnePerson = gdpPerOnePerson;
  }

  public String getCountryYear() {
    return countryYear;
  }

  public void setCountryYear(String countryYear) {
    this.countryYear = countryYear;
  }

  public Integer getSuicideAmount() {
    return suicideAmount;
  }

  public void setSuicideAmount(Integer suicideAmount) {
    this.suicideAmount = suicideAmount;
  }

  public Integer getGdpPerOnePerson() {
    return gdpPerOnePerson;
  }

  public void setGdpPerOnePerson(Integer gdpPerOnePerson) {
    this.gdpPerOnePerson = gdpPerOnePerson;
  }

  @Override
  public String toString() {
    return "CountryYearToSuicideAmountToGdp{" +
            "countryYear='" + countryYear + '\'' +
            ", suicideAmount=" + suicideAmount +
            ", gdpPerOnePerson=" + gdpPerOnePerson +
            '}';
  }
}
