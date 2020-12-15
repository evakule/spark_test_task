package tasks;

import model.CountryYearSuicideAmount;
import model.SuicideInfoRecord;
import org.apache.spark.sql.Dataset;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

  private Map<String, Integer> getSumOfSuicidesInCountryByYear(
          Dataset<SuicideInfoRecord> data) {
    List<CountryYearSuicideAmount> timeAndAmount = getCountryYearSuicideAmountList(data);
    Map<String, Integer> map = new HashMap<>();
    for (CountryYearSuicideAmount cys : timeAndAmount) {
      Integer value = map.get(cys.getCountryYear());
      if (value != null) {
        Integer newValue = map.get(cys.getCountryYear()) + cys.getAmountOfSuicideIntTheYear();
        map.put(cys.getCountryYear(), newValue);
      } else {
        map.put(cys.getCountryYear(), cys.getAmountOfSuicideIntTheYear());
      }
    }
    return map;
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
