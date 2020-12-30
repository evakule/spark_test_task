import io.IOProvider;
import model.CountryYearToSuicideAmountToGdp;
import source.DataProvider;
import tasks.AvgSuicideByOneHundred;
import tasks.DistributionByCountryAndAge;
import tasks.DistributionByGdpAndCount;
import tasks.TopFiveYearsBySumOfSuicides;

import java.util.List;


public class Runner {
  public static void main(String[] args) {
    DataProvider dataProvider = new DataProvider();
    IOProvider ioProvider = new IOProvider();

    TopFiveYearsBySumOfSuicides topFive = new TopFiveYearsBySumOfSuicides();
    AvgSuicideByOneHundred avgOneHundred = new AvgSuicideByOneHundred();
    DistributionByCountryAndAge countryAndAge = new DistributionByCountryAndAge();
    DistributionByGdpAndCount gdpAndCount = new DistributionByGdpAndCount();

    //Task 1
    topFive.get(dataProvider.getDataSet())
            .entrySet()
            .forEach(System.out::println);

    //Task 2
    avgOneHundred.getSortedByDesc(dataProvider.getDataSet())
            .entrySet()
            .forEach(System.out::println);

    //Task 3
    countryAndAge.get(dataProvider.getDataSet())
            .entrySet().forEach(System.out::println);

    //Task 4
    List<CountryYearToSuicideAmountToGdp> dataToWriteAsParquet = gdpAndCount
            .get(dataProvider.getDataSet());

    ioProvider.writeAsParquetFile(dataToWriteAsParquet);
  }
}
