package tasks;

import model.SuicideInfoRecord;
import org.apache.spark.sql.Dataset;

import java.util.HashMap;


public class DistributionByCountryAndAge {

  public final HashMap<String, HashMap<String, Integer>> get(
          final Dataset<SuicideInfoRecord> data
  ) {
    HashMap<String, HashMap<String, Integer>> distribution = new HashMap<>();
    data.collectAsList().forEach(e -> {
      HashMap<String, Integer> ageToAmountOfSuicides = distribution.get(e.getCountry());
      ageToAmountOfSuicides = updateMapValue(ageToAmountOfSuicides, e);
      distribution.put(e.getCountry(), ageToAmountOfSuicides); //map overriding
    });
    return distribution;
  }

  private HashMap<String, Integer> updateMapValue(
          HashMap<String, Integer> map,
          SuicideInfoRecord record
  ) {
    HashMap<String, Integer> mapToUpdate = map;
    if (map == null) {
      mapToUpdate = new HashMap<>();
      mapToUpdate.put(record.getAge(), record.getAmountOfSuicides());
    } else {
      mapToUpdate.merge(record.getAge(),
                        record.getAmountOfSuicides(),
                        Integer::sum);
    }
    return mapToUpdate;
  }
}
