package dk.jwillum.external_apis.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GenderResponse {
  String gender;
  String name;
  int count;
  double probability;
}

