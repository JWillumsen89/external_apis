package dk.jwillum.external_apis.dto;

import dk.jwillum.external_apis.entity.CombinedResponseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CombinedRequest {

  String name;
  String gender;
  double genderProbability;
  int age;
  int ageCount;
  String country;
  double countryProbability;
  boolean isCached;

  public static CombinedResponseEntity getCombinedResponseEntity(CombinedRequest c) {
    return new CombinedResponseEntity(c.name, c.gender, c.genderProbability,c.age, c.ageCount,c.country,c.countryProbability,c.isCached);
  }

  public CombinedRequest(CombinedResponseEntity c) {
    this.name = c.getName();
    this.gender = c.getGender();
    this.genderProbability = c.getGenderProbability();
    this.age = c.getAge();
    this.ageCount = c.getAgeCount();
    this.country = c.getCountry();
    this.countryProbability = c.getCountryProbability();
    this.isCached = c.isCached();
  }
}
