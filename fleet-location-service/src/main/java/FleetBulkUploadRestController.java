import java.util.List;

import domain.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import service.LocationService;


@RestController
public class FleetBulkUploadRestController {

    private LocationService locationService;

    @Autowired
    public FleetBulkUploadRestController(LocationService locationService) {
        this.locationService = locationService;

    }

    @RequestMapping(value = "/fleet", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<Location> locations) throws Exception {
        this.locationService.saveCarLocations(locations);
    }

    @RequestMapping(value = "/purge", method = RequestMethod.POST)
    public void purge() {
        this.locationService.deleteAll();
    }


//    private LocationRepository repository;
//
//    @Autowired
//    public FleetBulkUploadRestController(LocationRepository repository) {
//        this.repository = repository;
//
//    }

//    @RequestMapping(value = "/fleet", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    public void upload(@RequestBody List<Location> trucks) throws Exception {
//        this.repository.save(trucks);
//    }
//
//    @RequestMapping(value = "/purge", method = RequestMethod.POST)
//    public void purge() {
//        this.repository.deleteAll();
//    }

}