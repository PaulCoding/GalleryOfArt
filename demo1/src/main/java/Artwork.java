import javax.persistence.*;

@Entity
public class Artwork {
    @Id
    @GeneratedValue
    private Long artworkid;

    @ManyToOne
    @JoinColumn(name = "artistid")
    private Artist artist;

    private String name;
    private String year;
    private String technique;

    @ManyToOne
    @JoinColumn(name = "locationid")
    private Location location;

    public Artwork() {}

    public String getName() {
        return name;
    }

    public Long getArtworkid() {
        return artworkid;
    }

    public void setArtworkid(Long artworkid) {
        this.artworkid = artworkid;
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
