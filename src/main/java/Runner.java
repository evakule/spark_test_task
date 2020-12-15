import source.DataProvider;
import tasks.AvgSuicideByOneHundred;
import tasks.DistributionByCountryAndAge;
import tasks.TopFiveYearsBySumOfSuicides;


public class Runner {
  public static void main(String[] args) {
    DataProvider dataProvider = new DataProvider();
    TopFiveYearsBySumOfSuicides topFive = new TopFiveYearsBySumOfSuicides();
    AvgSuicideByOneHundred avgOneHundred = new AvgSuicideByOneHundred();
    DistributionByCountryAndAge distribution = new DistributionByCountryAndAge();

    //Task 1
    topFive.get(dataProvider.getDataSet())
            .entrySet()
            .forEach(System.out::println);

    //Task 2
    avgOneHundred.getSortedByDesc(dataProvider.getDataSet())
            .entrySet()
            .forEach(System.out::println);

    //Task 3
    distribution.get(dataProvider.getDataSet())
            .entrySet().forEach(System.out::println);

  }
}

