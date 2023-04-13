package dk.jwillum.external_apis.service;

import dk.jwillum.external_apis.dto.AgeResponse;
import dk.jwillum.external_apis.dto.CombinedResponse;
import dk.jwillum.external_apis.dto.GenderResponse;
import dk.jwillum.external_apis.dto.NationalityResponse;
import dk.jwillum.external_apis.entity.CombinedResponseEntity;
import dk.jwillum.external_apis.repository.CombinedResponseRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CombinedResponseService {

  CombinedResponseRepository combinedResponseRepository;

  public CombinedResponseService(CombinedResponseRepository combinedResponseRepository) {
    this.combinedResponseRepository = combinedResponseRepository;
  }

  public CombinedResponse fetchNameDetails(String name) {
    CombinedResponseEntity combinedResponseEntity = combinedResponseRepository.findByName(name);
    if (combinedResponseEntity != null) {
      return new CombinedResponse(combinedResponseEntity, true);
    } else {
      WebClient client = WebClient.create();
      CombinedResponse combinedResponse = fetchCombinedResponse(client, name);
      combinedResponseRepository.save(new CombinedResponseEntity(combinedResponse));
      return combinedResponse;
    }
  }

  private CombinedResponse fetchCombinedResponse(WebClient client, String name) {
    Mono<GenderResponse> gender = fetchResponse(client, "https://api.genderize.io?name=", name, GenderResponse.class);
    Mono<AgeResponse> age = fetchResponse(client, "https://api.agify.io?name=", name, AgeResponse.class);
    Mono<NationalityResponse> nationality = fetchResponse(client, "https://api.nationalize.io?name=", name, NationalityResponse.class);

    return Mono.zip(gender, age, nationality)
        .map(tuple -> new CombinedResponse(tuple.getT1(), tuple.getT2(), tuple.getT3(), false)).block();
  }

  private <T> Mono<T> fetchResponse(WebClient client, String uri, String name, Class<T> responseType) {
    return client.get()
        .uri(uri + name)
        .retrieve()
        .bodyToMono(responseType);
  }
}
