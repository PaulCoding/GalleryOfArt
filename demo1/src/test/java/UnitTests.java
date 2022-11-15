import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.Artwork;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class UnitTests {
    private static final Logger logger = LoggerFactory.getLogger(UnitTests.class);

    /* The common players we need for every test. */
    private EntityTransaction tx;
    private EntityManagerFactory emf;
    private EntityManager em;

    @BeforeEach
    void setUp() {
        String persistenceUnitName = "jpa-hiber-postgres-pu";
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @Test
    @DisplayName("select name of artworks")
    void selectNameOfAllArtworks() {

        var queryString = "SELECT a FROM Artwork a";
        var jpqlQuery = em.createQuery(queryString, Artwork.class);
        var artworks =  jpqlQuery.getResultList();

        assertThat(artworks.size()).isEqualTo(85);

    }

    @Test
    @DisplayName("select favorite artwork")
    void selectFavoriteArtwork() {

        var queryString = "SELECT a FROM Artwork a WHERE a.name='Bouquet of Flowers'";
        var jpqlQuery = em.createQuery(queryString, Artwork.class);
        var artwork = jpqlQuery.getSingleResult();
        var name = artwork.getName();

        assertThat(name).isEqualTo("Bouquet of Flowers");
    }







}
