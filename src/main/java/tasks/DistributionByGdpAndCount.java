package tasks;

import model.CountryYearToSuicideAmountToGdp;
import model.SuicideInfoRecord;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Dataset;
import scala.Tuple2;


public class DistributionByGdpAndCount {

  public final JavaRDD<CountryYearToSuicideAmountToGdp> get(
          final Dataset<SuicideInfoRecord> data
  ) {
    return data.toJavaRDD()
            .mapToPair(s -> new Tuple2<>(
                    s.getCountryAndYear(),
                    new Tuple2<>(s.getAmountOfSuicides(), s.getGDPPerOnePerson())
            ))
            .reduceByKey((x, y) -> new Tuple2<>(x._1() + y._1(), x._2))
            .map(collectToObject);
  }

  private Function<Tuple2<String, Tuple2<Integer, Integer>>, CountryYearToSuicideAmountToGdp>
          collectToObject = s -> new CountryYearToSuicideAmountToGdp(s._1(), s._2()._1(), s._2()._2());
}
