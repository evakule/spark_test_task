package tasks;

import model.SuicideInfoRecord;
import org.apache.spark.sql.Dataset;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;

public class AvgSuicideByOneHundred {
  public Map<String, Double> get(Dataset<SuicideInfoRecord> data) {
    List<SuicideInfoRecord> list = data.collectAsList();
    return list.stream()
            .collect(
                    groupingBy(
                            SuicideInfoRecord::getCountry,
                            averagingDouble(SuicideInfoRecord::getSuicidesPer100k)
                    )
            );
  }

  public Map<String, Double> getSortedByDesc(
          Dataset<SuicideInfoRecord> data
  ) {
    return get(data).entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
  }




}
