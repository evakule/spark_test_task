package model;

public class CountryYearToSuicideAmount {
  private String countryYear;
  private Integer amountOfSuicideIntTheYear;

  public CountryYearToSuicideAmount(
          String countryYear,
          Integer amountOfSuicideIntTheYear
  ) {
    this.countryYear = countryYear;
    this.amountOfSuicideIntTheYear = amountOfSuicideIntTheYear;
  }

  public CountryYearToSuicideAmount() {
  }

  public String getCountryYear() {
    return countryYear;
  }

  public Integer getAmountOfSuicideIntTheYear() {
    return amountOfSuicideIntTheYear;
  }

  public void setCountryYear(String countryYear) {
    this.countryYear = countryYear;
  }

  public void setAmountOfSuicideIntTheYear(Integer amountOfSuicideIntTheYear) {
    this.amountOfSuicideIntTheYear = amountOfSuicideIntTheYear;
  }
}
