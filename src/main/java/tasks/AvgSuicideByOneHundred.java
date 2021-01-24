package tasks;

import model.SuicideInfoRecord;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.sql.Dataset;
import scala.Tuple2;

public class AvgSuicideByOneHundred {
  public final JavaPairRDD<String, Double> get(Dataset<SuicideInfoRecord> data) {
    return data.toJavaRDD()
            .mapToPair(
                    s -> new Tuple2<>(
                            s.getCountryAndYear(),
                            new Tuple2<>(1, s.getSuicidesPer100k())))
            .reduceByKey((x, y) -> new Tuple2<>(x._1() + y._1(), x._2() + y._2()))
            .mapToPair(line -> new Tuple2<>(line._1(), line._2()._2() / line._2()._1())) //collecting pair with avg values
            .mapToPair(s -> new Tuple2<>(s._2(), s._1()))
            .sortByKey(false)
            .mapToPair(s -> new Tuple2<>(s._2(), s._1())); // sorting pair by value
  }
}
