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
            .mapToPair(
                    s -> new Tuple2<>(
                            s.getCountryAndYear() + "," + s.getGDPPerOnePerson(),
                            s.getAmountOfSuicides()))
            .reduceByKey(Integer::sum)
            .map(refactorOutput);
  }

  Function<Tuple2<String, Integer>, CountryYearToSuicideAmountToGdp> refactorOutput = s -> {
    int commaIndex = s._1().indexOf(",");
    String countryYear = s._1().substring(0, commaIndex);
    Integer gdpPerOnePerson = Integer.valueOf(s._1().substring(commaIndex + 1));
    Integer suicideAmount = s._2();
    return new CountryYearToSuicideAmountToGdp(countryYear, suicideAmount, gdpPerOnePerson);
  };
}
