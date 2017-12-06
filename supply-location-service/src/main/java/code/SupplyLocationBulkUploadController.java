package code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class SupplyLocationBulkUploadController {

    private SupplyLocationRepository repository;
    private SupplyLocationService service;

    @Autowired
    public SupplyLocationBulkUploadController(SupplyLocationRepository repository) {
        this.repository = repository;

    }

    @Autowired
    public SupplyLocationBulkUploadController(SupplyLocationRepository repository, SupplyLocationService service) {
        this.repository = repository;
        this.service = service;
    }

    @RequestMapping(value = "/bulk/supplyLocations", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<SupplyLocation> locations) {
        this.repository.save(locations);
    }

    @RequestMapping(value = "/purge", method = RequestMethod.POST)
    public void purge() {
        this.repository.deleteAll();
    }

    public List<SupplyLocation> uploadFitleredLocations(List<SupplyLocation> locations) {
        return this.service.saveSupplyLocationsZipContains504(locations);
    }
}
