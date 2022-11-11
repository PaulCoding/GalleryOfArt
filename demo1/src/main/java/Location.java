import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Location {
    @Id
    @GeneratedValue
    private Long locationid;
    private String name;

    @ManyToOne
    @JoinColumn (name = "cityid")
    private City city;

    @OneToMany(mappedBy = "location")
    private Collection<Artwork> artworks = new ArrayList<>();

    public Location() {}

    public Long getLocationid() {
        return locationid;
    }

    public void setLocationid(Long locationid) {
        this.locationid = locationid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Collection<Artwork> getArtworks() {
        return artworks;
    }

    public void setArtworks(Collection<Artwork> artworks) {
        this.artworks = artworks;
    }
}
