package code.service.impl;

import code.model.CurrentPosition;
import code.model.SupplyLocation;
import code.service.SupplyLocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class DefaultSupplyLocationService implements SupplyLocationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultSupplyLocationService.class);

    //    @Autowired
//    @LoadBalanced
    private RestTemplate restTemplate = new RestTemplate();

    //	@HystrixCommand(
//			commandKey="supplyLocations",
//			commandProperties = {
//					@HystrixProperty(name = "circuitBreaker.forceOpen", value = "true")
//			},
//			fallbackMethod = "handleSupplyLocationServiceFailure")
    @Override
    public void updateSupplyLocations(CurrentPosition currentPosition) {

        switch (currentPosition.getRunnerStatus()) {

            case SERVICE_NOW:
            case SERVICE_SOON:
            case STOP_NOW:
                ResponseEntity<Resource<SupplyLocation>> result = this.restTemplate.exchange(
                        "http://supply-location-service/supplyLocations/search/findFirstByLocationNear?location={lat},{long}",
                        HttpMethod.GET, new HttpEntity<Void>((Void) null),
                        new ParameterizedTypeReference<Resource<SupplyLocation>>() {
                        }, currentPosition.getLocation().getLatitude(),
                        currentPosition.getLocation().getLongitude());
                if (result.getStatusCode() == HttpStatus.OK
                        && result.getBody().getContent() != null) {
                    currentPosition.setSupplyLocation(result.getBody().getContent());
                }
                break;
            default:
        }

    }

    public void handleSupplyLocationServiceFailure(CurrentPosition currentPosition) {
        LOGGER.error("Hystrix Fallback Method. Unable to retrieve service station info.");
    }
}
