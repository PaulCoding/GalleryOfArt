package domain;

import domain.interfaces.PrintableInList;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Location implements PrintableInList {
    @Id
    @GeneratedValue
    private Long locationID;
    private String name;

    @ManyToOne
    @JoinColumn (name = "cityID")
    private City city;

    @OneToMany(mappedBy = "location")
    private Collection<Artwork> artworks = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "verlangID")
    private Verlanglijst verlanglijst;

    public Location() {}

    public Verlanglijst getVerlanglijst() {
        return verlanglijst;
    }

    public void setVerlanglijst(Verlanglijst verlanglijst) {
        this.verlanglijst = verlanglijst;
    }

    public Long getID() {
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
