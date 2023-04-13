package dk.jwillum.external_apis.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class NationalityResponse {
  List<Country> country;
  String name;

}
