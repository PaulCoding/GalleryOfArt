package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Verlanglijst {
     @Id
     @GeneratedValue
     private Long verlangID;
     @OneToMany(mappedBy = "verlanglijst")
     private Collection<Location> locations = new ArrayList<>();

     public Verlanglijst() {}

     public ArrayList<Location> getLocations() {
          return (ArrayList<Location>) locations;
     }

     public void setLocations(ArrayList<Location> locations) {
          this.locations = locations;
     }

     public Long getVerlangID() {
          return verlangID;
     }

     public void setVerlangID(Long verlangID) {
          this.verlangID = verlangID;
     }
}
