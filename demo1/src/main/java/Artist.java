import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Artist {
    @Id
    @GeneratedValue
    private Long artistid;
    private String name;

    @OneToMany(mappedBy = "artist")
    private Collection<Artwork> artworks = new ArrayList<>();

    public Artist() {}

    public Artist(String name) {
        this.name = name;
    }

    public Long getArtistid() {
        return artistid;
    }

    public void setArtistid(Long artistid) {
        this.artistid = artistid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Artwork> getArtworks() {
        return artworks;
    }

    public void setArtworks(Collection<Artwork> artworks) {
        this.artworks = artworks;
    }
}
