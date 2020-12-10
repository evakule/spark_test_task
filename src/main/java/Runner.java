import source.DataProvider;
import tasks.TopFiveYearsBySumOfSuicides;


public class Runner {
  public static void main(String[] args) {
    DataProvider dataProvider = new DataProvider();
    TopFiveYearsBySumOfSuicides topFive = new TopFiveYearsBySumOfSuicides();

    topFive.getTopFive(dataProvider.getDataSet())
            .entrySet()
            .forEach(System.out::println);
  }
}
