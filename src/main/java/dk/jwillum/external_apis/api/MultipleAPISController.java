package dk.jwillum.external_apis.api;


import dk.jwillum.external_apis.dto.CombinedResponse;
import dk.jwillum.external_apis.service.CombinedResponseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultipleAPISController {
  CombinedResponseService combinedResponseService;

  public MultipleAPISController(CombinedResponseService combinedResponseService) {
    this.combinedResponseService = combinedResponseService;
  }

  @GetMapping("name/{input}")
  public CombinedResponse getNameInfo(@PathVariable String input) {
    return combinedResponseService.fetchNameDetails(input);
  }

}
