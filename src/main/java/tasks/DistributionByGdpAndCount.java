package tasks;

import model.CountryYearToSuicideAmountToGdp;
import model.SuicideInfoRecord;
import org.apache.spark.sql.Dataset;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.summingInt;


public class DistributionByGdpAndCount {

  public final List<CountryYearToSuicideAmountToGdp> get(
          final Dataset<SuicideInfoRecord> data
  ) {
    Map<String, Integer> countryAndYearToSuicideAmount = getCountryAndYearToSuicideAmountMap(data);
    Map<String, Double> countryAndYearToGdpPerPerson = getCountryAndYearToGdpPerPersonMap(data);
    return mergeTwoMapsToListOfObjects(countryAndYearToSuicideAmount, countryAndYearToGdpPerPerson);
  }

  private Map<String, Integer> getCountryAndYearToSuicideAmountMap(
          final Dataset<SuicideInfoRecord> data
  ) {
    return data.collectAsList().stream().collect(
            Collectors.groupingBy(
                    SuicideInfoRecord::getCountryAndYear,
                    summingInt(SuicideInfoRecord::getAmountOfSuicides)
            )
    );
  }

  private Map<String, Double> getCountryAndYearToGdpPerPersonMap(
          final Dataset<SuicideInfoRecord> data
  ) {
    return data.collectAsList().stream().collect(
            Collectors.groupingBy(
                    SuicideInfoRecord::getCountryAndYear,
                    averagingInt(SuicideInfoRecord::getGDPPerOnePerson)
            )
    );
  }

  private List<CountryYearToSuicideAmountToGdp> mergeTwoMapsToListOfObjects(
          final Map<String, Integer> countryAndYearToSuicideAmount,
          final Map<String, Double> countryAndYearToGdpPerPerson
  ) {
    List<CountryYearToSuicideAmountToGdp> list = new ArrayList<>();
    for (String countryAndYear : countryAndYearToSuicideAmount.keySet()) {
      CountryYearToSuicideAmountToGdp countrySuicideGdp =
              new CountryYearToSuicideAmountToGdp(
                      countryAndYear,
                      countryAndYearToSuicideAmount.get(countryAndYear),
                      countryAndYearToGdpPerPerson.get(countryAndYear)
              );
      list.add(countrySuicideGdp);
    }
    return list;
  }
}
