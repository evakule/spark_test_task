package tasks;

import model.CountryYearToSuicideAmount;
import model.SuicideInfoRecord;
import org.apache.spark.sql.Dataset;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class TopFiveYearsBySumOfSuicides {
  private static final Integer LIMIT_OF_VIEW = 5;

  public final Map<String, Integer> get(final Dataset<SuicideInfoRecord> data) {
    Map<String, Integer> map = getSumOfSuicidesInCountryByYear(data);
    Map<String, Integer> sortedMap = getSortedByValueMap(map);
    return sortedMap.entrySet().stream()
            .limit(LIMIT_OF_VIEW)
            .collect(Collectors
                    .toMap(
                            Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
  }

  private Map<String, Integer> getSumOfSuicidesInCountryByYear(
          final Dataset<SuicideInfoRecord> data
  ) {
    return getCountryYearSuicideAmountList(data).stream()
            .collect(
                    groupingBy(
                            CountryYearToSuicideAmount::getCountryYear,
                            summingInt(CountryYearToSuicideAmount::getAmountOfSuicideIntTheYear)
                    )
            );
  }

  private LinkedHashMap<String, Integer> getSortedByValueMap(
          final Map<String, Integer> map
  ) {
    return map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
  }

  private List<CountryYearToSuicideAmount> getCountryYearSuicideAmountList(
          final Dataset<SuicideInfoRecord> data) {
    return data.collectAsList().stream().map(e ->
            new CountryYearToSuicideAmount(e.getCountryAndYear(), e.getAmountOfSuicides()))
            .collect(Collectors.toList());
  }
}
