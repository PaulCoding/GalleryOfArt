import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class City {
    @Id
    @GeneratedValue
    private Long Cityid;
    private String name;
    @OneToMany(mappedBy = "city")
    @JoinColumn(name = "locationid")
    private Collection<Location> locations = new ArrayList<>();

    public City() {
    }

    public Long getCityid() {
        return Cityid;
    }

    public void setCityid(Long cityid) {
        Cityid = cityid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
