import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "locations")
public interface ServiceLocationRepository extends PagingAndSortingRepository<ServiceLocation, Long>{

    @RestResource(rel = "by-location", description = @Description("Find by location"))
    ServiceLocation findFirstByLocationNear(@Param("location") Point location);
}
