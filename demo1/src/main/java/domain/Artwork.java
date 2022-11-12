package domain;

import javax.persistence.*;

@Entity
public class Artwork {
    @Id
    @GeneratedValue
    private Long artworkID;

    private String name;
    private String year;
    private String technique;

    @ManyToOne
    @JoinColumn(name = "locationID")
    private Location location;
    @ManyToOne
    @JoinColumn(name = "artistID")
    private Artist artist;

    public Artwork() {}

    public String getName() {
        return name;
    }

    public Long getArtworkID() {
        return artworkID;
    }

    public void setArtworkID(Long artworkID) {
        this.artworkID = artworkID;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTechnique() {
        return technique;
    }

    public void setTechnique(String technique) {
        this.technique = technique;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
