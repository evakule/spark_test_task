package tasks;

import model.SuicideInfoRecord;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.sql.Dataset;
import scala.Tuple2;

public class AvgSuicideByOneHundred {
  public final JavaPairRDD<String, Double> get(Dataset<SuicideInfoRecord> data) {
    return data.toJavaRDD().mapToPair(
            x -> new Tuple2<>(x.getCountryAndYear(), x.getSuicidesPer100k() / 12)
    ).reduceByKey(Double::sum)
            .mapToPair(s -> new Tuple2<>(s._2(), s._1()))
            .sortByKey(false)
            .mapToPair(s -> new Tuple2<>(s._2(), s._1()));
  }
}
