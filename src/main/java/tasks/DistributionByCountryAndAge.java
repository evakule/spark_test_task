package tasks;

import model.SuicideInfoRecord;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.sql.Dataset;
import scala.Tuple2;

public class DistributionByCountryAndAge {

  public final JavaPairRDD<String, String> get(
          final Dataset<SuicideInfoRecord> data
  ) {
    return data.toJavaRDD()
            .mapToPair(s -> new Tuple2<>(
                    s.getCountry() + ":" + s.getAge(),
                    s.getAmountOfSuicides()))
            .reduceByKey(Integer::sum)
            .mapToPair(outputRefactor)
            .reduceByKey((x, y) -> x + ", " + y);
  }

  PairFunction<Tuple2<String, Integer>, String, String> outputRefactor = s -> {
    int colonIndex = s._1().indexOf(':');
    String years = s._1().substring(colonIndex + 1);
    String country = s._1().substring(0, colonIndex);
    return new Tuple2<>(country, years + "=" + s._2());
  };
}
