package dk.jwillum.external_apis.dto;

import dk.jwillum.external_apis.entity.CombinedResponseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CombinedResponse {
  String name;
  String gender;
  double genderProbability;
  int age;
  int ageCount;
  String country;
  double countryProbability;
  boolean isCached;

  public CombinedResponse(GenderResponse g, AgeResponse a, NationalityResponse n, boolean isCached) {
    this.name = g.getName();
    this.gender = g.getGender();
    this.genderProbability = g.getProbability();
    this.age = a.getAge();
    this.ageCount = a.getCount();
    this.country = n.getCountry().get(0).getCountry_id();
    this.countryProbability = n.getCountry().get(0).getProbability();
    this.isCached = isCached;
  }

  public CombinedResponse(CombinedResponseEntity c, boolean isCached) {
    this.name = c.getName();
    this.gender = c.getGender();
    this.genderProbability = c.getGenderProbability();
    this.age = c.getAge();
    this.ageCount = c.getAgeCount();
    this.country = c.getCountry();
    this.countryProbability = c.getCountryProbability();
    this.isCached = isCached;
  }
}
