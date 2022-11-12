package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Location {
    @Id
    @GeneratedValue
    private Long locationID;
    private String name;

    @ManyToOne
    @JoinColumn (name = "cityID")
    private City city;

    @OneToMany(mappedBy = "location")
    private Collection<Artwork> artworks = new ArrayList<>();

    public Location() {}

    public Long getLocationID() {
        return locationID;
    }

    public void setLocationID(Long locationID) {
        this.locationID = locationID;
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
