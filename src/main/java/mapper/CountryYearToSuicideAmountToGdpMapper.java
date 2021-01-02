package mapper;

import dto.CountryYearToSuicideAmountToGdpDTO;
import model.CountryYearToSuicideAmountToGdp;

import java.util.List;
import java.util.stream.Collectors;

public class CountryYearToSuicideAmountToGdpMapper {

  public final CountryYearToSuicideAmountToGdpDTO toDTO(
          final CountryYearToSuicideAmountToGdp source
  ) {
    String sourceCountryYear = source.getCountryYear();
    return new CountryYearToSuicideAmountToGdpDTO(
            source.getCountryYear()
                    .substring(sourceCountryYear.length() - 4),
            source.getCountryYear()
                    .substring(0, sourceCountryYear.length() - 4),
            source.getSuicideAmount(),
            source.getGdpPerOnePerson()
    );
  }

  public final List<CountryYearToSuicideAmountToGdpDTO> toDtoList(
          final List<CountryYearToSuicideAmountToGdp> source
  ) {
    return source
            .stream().map(this::toDTO).collect(Collectors.toList());
  }
}
