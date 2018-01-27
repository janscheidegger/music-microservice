package ch.bfh.schescha.cdservice.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Cd {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String cdId;

    private String artistId;
    private String title;
//    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate releaseDate;
    private int numbersSold;
    private int duration;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "cdId")
    private List<Song> songs;

    public String getCdId() {
        return cdId;
    }

    public void setCdId(String cdId) { this.cdId = cdId; }

    public String getArtistId() { return artistId; }

    public void setArtistId(String artistId) { this.artistId = artistId; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getNumbersSold() {
        return numbersSold;
    }

    public void setNumbersSold(int numbersSold) {
        this.numbersSold = numbersSold;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
