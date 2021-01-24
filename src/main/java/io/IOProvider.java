package io;

import dto.CountryYearToSuicideAmountToGdpDTO;
import mapper.CountryYearToSuicideAmountToGdpMapper;
import model.CountryYearToSuicideAmountToGdp;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.List;

public final class IOProvider {
  private static final String OUT_PATH_PARQUET_FILE = "C:/Users/enric/"
          + "IdeaProjects/study/humanlves/spark/output/parquet";
  private static final String OUT_PATH_CSV_FILE = "C:/Users/enric/"
          + "IdeaProjects/study/humanlves/spark/output/csv";
  private final CountryYearToSuicideAmountToGdpMapper mapper =
          new CountryYearToSuicideAmountToGdpMapper();

  public void writeAsParquetFile(List<CountryYearToSuicideAmountToGdp> toWrite) {
    Dataset<Row> data = getSparkSession().createDataFrame(
            toWrite,
            CountryYearToSuicideAmountToGdp.class
    );
    data.write().parquet(OUT_PATH_PARQUET_FILE);
  }

  public void writeAsCsvFile(List<CountryYearToSuicideAmountToGdp> sourceData) {
    List<CountryYearToSuicideAmountToGdpDTO> toWrite =
            mapper.toDtoList(sourceData);

    Dataset<Row> data = getSparkSession().createDataFrame(
            toWrite,
            CountryYearToSuicideAmountToGdpDTO.class
    );
    data.write().csv(OUT_PATH_CSV_FILE);
  }

  private SparkSession getSparkSession() {
    return SparkSession.builder()
            .appName("humanlves")
            .config("spark.master", "local")
            .getOrCreate();
  }
}
