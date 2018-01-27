package ch.bfh.schescha.artistcdservice.model;

import java.time.LocalDate;
import java.util.List;

public class Cd {

    private String cdId;

    private String artistId;
    private String title;
    private LocalDate releaseDate;
    private int numbersSold;
    private int duration;

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
