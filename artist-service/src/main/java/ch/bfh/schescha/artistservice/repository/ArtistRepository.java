package ch.bfh.schescha.artistservice.repository;

import ch.bfh.schescha.artistservice.model.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArtistRepository extends CrudRepository<Artist, String> {

//    @RestResource(path = "artists")
//    List<Artist> findArtistByArtistId(@Param("artistId") String artistId);

}
