package ch.bfh.schescha.artistcdservice.controller;

import ch.bfh.schescha.artistcdservice.client.ArtistClient;
import ch.bfh.schescha.artistcdservice.client.CdClient;
import ch.bfh.schescha.artistcdservice.model.Artist;
import ch.bfh.schescha.artistcdservice.model.ArtistCd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class ArtistCdController implements ResourceProcessor<RepositoryLinksResource> {

    private static final Logger LOG = LoggerFactory.getLogger(ArtistCdController.class);
    @Autowired
    private ArtistClient artistClient;

    @Autowired
    private CdClient cdClient;

    @RequestMapping(value = "/artistCd/{id}", method = RequestMethod.GET, produces = "application/hal+json")
    @ResponseBody
    public Resource<ArtistCd> getArtistCd(@PathVariable("id") String id) {
        LOG.info("----- In getArtistCd -----");
        Artist artist = artistClient.getArtist(id).getContent();
        ArtistCd artistCd = new ArtistCd();
        artistCd.setName(artist.getName());
        artistCd.setMembers(artist.getMembers());
        artistCd.setCreationDate(artist.getCreationDate());
        artistCd.setOrigin(artist.getOrigin());
        artistCd.setCds(cdClient.getCdsForArtist(id).getContent());
        LOG.info("----- In ArtistCd Creation -----");
        return new Resource<>(artistCd);
    }

    @RequestMapping(value = "/artistCd", method = RequestMethod.GET, produces = "application/hal+json")
    @ResponseBody
    public Resources<ArtistCd> listArtistCds() {
        LOG.info("----- In listArtistCds -----");
        List<ArtistCd> artistCdList = new ArrayList<>();
        Resources<Artist> artistList = artistClient.getArtists();
        for (Artist artist : artistList) {
            ArtistCd artistCd = new ArtistCd();
            artistCd.setName(artist.getName());
            artistCd.setMembers(artist.getMembers());
            artistCd.setCreationDate(artist.getCreationDate());
            artistCd.setOrigin(artist.getOrigin());
            artistCd.setCds(cdClient.getCdsForArtist(artist.getArtistId()).getContent());
            artistCdList.add(artistCd);
        }
        LOG.info("----- FOUND " + artistCdList.size() + " ArtistCds-----");
        return new Resources<>(artistCdList);
    }

    @Override
    public RepositoryLinksResource process(RepositoryLinksResource repositoryLinksResource) {
        repositoryLinksResource.add(linkTo(methodOn(ArtistCdController.class).listArtistCds()).withRel("artistCd"));
        return repositoryLinksResource;
    }
}
