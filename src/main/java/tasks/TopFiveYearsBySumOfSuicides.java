package tasks;

import model.CountryYearSuicideAmount;
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

  public Map<String, Integer> get(Dataset<SuicideInfoRecord> data) {
    Map<String, Integer> map = getSumOfSuicidesInCountryByYear(data);
    Map<String, Integer> sortedMap = getSortedByValueMap(map);
    return sortedMap.entrySet().stream()
            .limit(5)
            .collect(Collectors
                    .toMap(
                            Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
  }

  private Map<String, Integer> getSumOfSuicidesInCountryByYear(Dataset<SuicideInfoRecord> data) {
    return getCountryYearSuicideAmountList(data).stream()
            .collect(
                    groupingBy(
                            CountryYearSuicideAmount::getCountryYear,
                            summingInt(CountryYearSuicideAmount::getAmountOfSuicideIntTheYear)
                    )
            );
  }

  private LinkedHashMap<String, Integer> getSortedByValueMap(Map<String, Integer> map) {
    return map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
  }

  private List<CountryYearSuicideAmount> getCountryYearSuicideAmountList(
          Dataset<SuicideInfoRecord> data) {
    return data.collectAsList().stream().map(e ->
            new CountryYearSuicideAmount(e.getCountryAndYear(), e.getAmountOfSuicides()))
            .collect(Collectors.toList());
  }
}
