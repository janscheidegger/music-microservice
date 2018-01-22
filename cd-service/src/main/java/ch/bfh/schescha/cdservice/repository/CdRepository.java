package ch.bfh.schescha.cdservice.repository;

import ch.bfh.schescha.cdservice.model.Cd;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface CdRepository extends CrudRepository<Cd, String> {

    @RestResource(path = "artist")
    List<Cd> findByArtistId(@Param("artistId") String artistId);
}




