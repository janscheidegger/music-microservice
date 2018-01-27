package ch.bfh.schescha.artistcdservice.model;

public class Song {

    private String songId;
    private String title;
    private int duration;

    public Song() {
    }

    public Song(String songId, String title, int duration) {
        this.songId = songId;
        this.title = title;
        this.duration = duration;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
