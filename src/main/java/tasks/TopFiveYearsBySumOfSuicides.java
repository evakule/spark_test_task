package tasks;

import model.SuicideInfoRecord;
import org.apache.spark.sql.Dataset;
import scala.Tuple2;

import java.util.List;

public class TopFiveYearsBySumOfSuicides {
  private static final Integer LIMIT_OF_VIEW = 5;

  public final List<Tuple2<String, Integer>> get(final Dataset<SuicideInfoRecord> data) {
    return data.toJavaRDD().mapToPair(s -> new Tuple2<>(
            s.getCountryAndYear(), s.getAmountOfSuicides()))
            .reduceByKey(Integer::sum)
            .mapToPair(s -> new Tuple2<>(s._2, s._1))
            .sortByKey(false)
            .mapToPair(s -> new Tuple2<>(s._2, s._1))
            .take(LIMIT_OF_VIEW);
  }
}
