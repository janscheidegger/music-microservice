package ch.bfh.schescha.artistcdservice.model;

import org.springframework.hateoas.ResourceSupport;

import java.time.LocalDate;
import java.util.Collection;

/**
 * Created by simon on 22.01.2018.
 */
public class ArtistCd extends ResourceSupport {

    private String name;
    private int members;
    private LocalDate creationDate;
    private String origin;

    private Collection<Cd> cds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Collection<Cd> getCds() {
        return cds;
    }

    public void setCds(Collection<Cd> cds) {
        this.cds = cds;
    }

}
