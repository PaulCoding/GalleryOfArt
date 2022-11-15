package domain;

import domain.interfaces.PrintableInList;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class City implements PrintableInList {
    @Id
    @GeneratedValue
    private Long cityID;
    private String name;
    @OneToMany(mappedBy = "city")
    private Collection<Location> locations = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "countryID")
    private Country country;

    public City() {
    }

    public Long getID() {
        return cityID;
    }

    public void setCityID(Long cityID) {
        this.cityID = cityID;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
