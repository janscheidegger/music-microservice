package ch.bfh.schescha.artistcdservice.client;

import ch.bfh.schescha.artistcdservice.model.Artist;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by simon on 22.01.2018.
 */
@FeignClient("artist-service")
public interface ArtistClient {
    @RequestMapping(method = RequestMethod.GET, value = "/artists/{id}")
    Resource<Artist> getArtist(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.GET, value = "/artists")
    Resources<Artist> getArtists();
}
