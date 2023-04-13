package dk.jwillum.external_apis.entity;

import dk.jwillum.external_apis.dto.AgeResponse;
import dk.jwillum.external_apis.dto.CombinedResponse;
import dk.jwillum.external_apis.dto.GenderResponse;
import dk.jwillum.external_apis.dto.NationalityResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CombinedResponseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;
  String name;
  String gender;
  double genderProbability;
  int age;
  int ageCount;
  String country;
  double countryProbability;
  boolean isCached;

  public CombinedResponseEntity(GenderResponse g, AgeResponse a, NationalityResponse n, Boolean isCached) {
    this.name = g.getName();
    this.gender = g.getGender();
    this.genderProbability = g.getProbability();
    this.age = a.getAge();
    this.ageCount = a.getCount();
    this.country = n.getCountry().get(0).getCountry_id();
    this.countryProbability = n.getCountry().get(0).getProbability();
    this.isCached = isCached;
  }

  public CombinedResponseEntity(String name, String gender, double genderProbability, int age, int ageCount, String country, double countryProbability, boolean isCached) {
    this.name = name;
    this.gender = gender;
    this.genderProbability = genderProbability;
    this.age = age;
    this.ageCount = ageCount;
    this.country = country;
    this.countryProbability = countryProbability;
    this.isCached = isCached;
  }

  public  CombinedResponseEntity(CombinedResponse c) {
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