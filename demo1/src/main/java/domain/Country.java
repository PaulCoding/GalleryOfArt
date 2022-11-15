package domain;

import domain.interfaces.PrintableInList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Country implements PrintableInList {
    @Id
    @GeneratedValue
    private Long countryID;
    private String name;
    @OneToMany(mappedBy = "country")
    private Collection<City> cities = new ArrayList<>();

    public Country() {}

    public Long getID() {
        return countryID;
    }

    public void setCountryID(Long countryID) {
        this.countryID = countryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
