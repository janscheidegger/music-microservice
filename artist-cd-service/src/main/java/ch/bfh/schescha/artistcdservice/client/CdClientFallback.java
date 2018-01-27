package ch.bfh.schescha.artistcdservice.client;

import ch.bfh.schescha.artistcdservice.model.Cd;
import ch.bfh.schescha.artistcdservice.model.Song;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by simon on 22.01.2018.
 */
@Component
public class CdClientFallback implements CdClient{
    @Override
    public Resources<Cd> getCds() {
        return createDummyCds();
    }

    @Override
    public Resources<Cd> getCdsForArtist(@RequestParam("artistId") String artistId) {
        return createDummyCds();
    }

    private Resources<Cd> createDummyCds() {
        List<Cd> cdList = new ArrayList<>();
        Cd cd = new Cd();
        cd.setCdId("-- DUMMY CD ID --");
        cd.setDuration(0);
        cd.setTitle("-- DUMMY CD TITLE --");
        cd.setNumbersSold(0);
        cd.setReleaseDate(LocalDate.now());
        cd.setSongs(Collections.singletonList(
                new Song("--DUMMY ID", "DUMMY TITLE", 123)
        ));
        return new Resources<>(cdList);
    }
}
