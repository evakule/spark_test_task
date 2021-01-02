package dto;

import java.util.Objects;

public class CountryYearToSuicideAmountToGdpDTO {
  private String year;
  private String country;
  private Integer suicideAmount;
  private Double gdpPerOnePerson;

  public CountryYearToSuicideAmountToGdpDTO(
          String year,
          String country,
          Integer suicideAmount,
          Double gdpPerOnePerson
  ) {
    this.year = year;
    this.country = country;
    this.suicideAmount = suicideAmount;
    this.gdpPerOnePerson = gdpPerOnePerson;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Integer getSuicideAmount() {
    return suicideAmount;
  }

  public void setSuicideAmount(Integer suicideAmount) {
    this.suicideAmount = suicideAmount;
  }

  public Double getGdpPerOnePerson() {
    return gdpPerOnePerson;
  }

  public void setGdpPerOnePerson(Double gdpPerOnePerson) {
    this.gdpPerOnePerson = gdpPerOnePerson;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CountryYearToSuicideAmountToGdpDTO that = (CountryYearToSuicideAmountToGdpDTO) o;
    return year.equals(that.year) &&
            country.equals(that.country) &&
            suicideAmount.equals(that.suicideAmount) &&
            gdpPerOnePerson.equals(that.gdpPerOnePerson);
  }

  @Override
  public int hashCode() {
    return Objects.hash(year, country, suicideAmount, gdpPerOnePerson);
  }

  @Override
  public String toString() {
    return "CountryYearToSuicideAmountToGdpDTO{" +
            "year='" + year + '\'' +
            ", country='" + country + '\'' +
            ", suicideAmount=" + suicideAmount +
            ", gdpPerOnePerson=" + gdpPerOnePerson +
            '}';
  }
}
