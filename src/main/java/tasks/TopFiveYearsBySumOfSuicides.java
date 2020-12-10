package tasks;

import model.CountryYearSuicideAmount;
import model.SuicideInfoRecord;
import org.apache.spark.sql.Dataset;

import java.util.*;
import java.util.stream.Collectors;

public class TopFiveYearsBySumOfSuicides {

  public Map<String, Integer> getTopFive(Dataset<SuicideInfoRecord> data) {
    Map<String, Integer> map = getSumOfSuicidesInCountryByYear(data);
    Map<String, Integer> sortedMap = getSortedByValueMap(map);
    return sortedMap.entrySet().stream()
            .limit(5)
            .collect(Collectors
                    .toMap(
                            Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
  }

  public Map<String, Integer> getSumOfSuicidesInCountryByYear(
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

  public LinkedHashMap<String, Integer> getSortedByValueMap(Map<String, Integer> map) {
    return map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
  }

  private List<CountryYearSuicideAmount> getCountryYearSuicideAmountList(Dataset<SuicideInfoRecord> data) {
    List<CountryYearSuicideAmount> timeAndAmount = new ArrayList<>();
    List<SuicideInfoRecord> list = data.collectAsList();
    for (SuicideInfoRecord record : list) {
      timeAndAmount.add(
              new CountryYearSuicideAmount(
                      record.getCountryAndYear(),
                      Integer.valueOf(record.getAmountOfSuicides())));
    }
    return timeAndAmount;
  }
}
