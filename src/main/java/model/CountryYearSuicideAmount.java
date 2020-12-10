package model;

public class CountryYearSuicideAmount {
  private String countryYear;
  private Integer amountOfSuicideIntTheYear;

  public CountryYearSuicideAmount(
          String countryYear,
          Integer amountOfSuicideIntTheYear
  ) {
    this.countryYear = countryYear;
    this.amountOfSuicideIntTheYear = amountOfSuicideIntTheYear;
  }

  public CountryYearSuicideAmount() {
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
