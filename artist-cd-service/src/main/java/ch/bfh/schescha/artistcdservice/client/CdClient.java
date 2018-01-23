package ch.bfh.schescha.artistcdservice.client;

import ch.bfh.schescha.artistcdservice.model.Cd;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by simon on 22.01.2018.
 */
@FeignClient(value = "cd-service", fallback = CdClientFallback.class)
public interface CdClient {

    @RequestMapping(method = RequestMethod.GET, value = "/cds")
    Resources<Cd> getCds();

    @RequestMapping(method = RequestMethod.GET, value = "/cds/search/artist")
    Resources<Cd> getCdsForArtist(@RequestParam("artistId") String artistId);
}
