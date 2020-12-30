package source;

import model.SuicideInfoRecord;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;

public class DataProvider {
  private static final String PATH_TO_DATA_FILE =
          "C:/Users/enric/IdeaProjects/study/humanlves/src/main/resources/master.csv";
  private static final String PATH_TO_WIN_UTILS =
          "C:/Program Files (x86)/WinUtils/";
  private static final String[] HEADERS = {
          "country", "year", "sex", "age", "amountOfSuicides",
          "population", "suicidesPer100k", "countryAndYear",
          "HDIForYear", "GDPForYear", "GDPPerOnePerson", "generationType"
  };

  public Dataset<SuicideInfoRecord> getDataSet() {
    System.setProperty("hadoop.home.dir", PATH_TO_WIN_UTILS);
    Encoder<SuicideInfoRecord> encoder = Encoders.bean(SuicideInfoRecord.class);
    return getSparkSession().read()
            .format("csv")
            .option("sep", ",")
            .option("inferSchema", "true")
            .option("header", "true")
            .load(PATH_TO_DATA_FILE)
            .toDF(HEADERS)
            .as(encoder);
  }

  private SparkSession getSparkSession() {
    return SparkSession.builder()
            .appName("humanlves")
            .config("spark.master", "local")
            .getOrCreate();
  }
}
