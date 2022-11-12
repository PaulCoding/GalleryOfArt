package util;

import domain.Artist;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DatabaseHelper {

    private String persistenceUnitName;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

    public DatabaseHelper() {
        persistenceUnitName = "jpa-hiber-postgres-pu";
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    public void queryMuseaInParijs() {
        var queryString = "SELECT artw.location.name FROM Artwork artw WHERE (artw.artist.id=4 OR artw.artist.id=6 " +
                "OR artw.artist.id=15 OR artw.artist.id=20 OR artw.artist.id=19 OR artw.artist.id=17 OR artw.artist.id=1)";
        var jpqlQuery = em.createQuery(queryString, String.class);
        var names = jpqlQuery.getResultList(); //(ArrayList<String>)
        Set<String> set = new HashSet<>(names);
        System.out.println("De volgende musea tonen kunst van: CÉZANNE, DEGAS, MANET, RENOIR, RODIN, MONET");
        for (String name : set) {
            System.out.println("-  " + name);
        }
    }

    public void querySteden(int artistID) {
//        if (artistIDs.isEmpty()) {
//            var queryString = "SELECT a FROM domain.Artist a";
//            var jpqlQuery = em.createQuery(queryString, domain.Artist.class);
//            var artists = (ArrayList<domain.Artist>) jpqlQuery.getResultList();
//
//            for (domain.Artist artist : artists) {
//                System.out.println("" + artist.getArtistid() + "- " + artist.getName());
//            }
//        }

    }

    public ArrayList<Artist> queryArtists(ArrayList<Integer> steden) {
        ArrayList<Artist> artists = new ArrayList<>();
        if (steden.isEmpty()) {
            var queryString = "SELECT a FROM Artist a";
            var jpqlQuery = em.createQuery(queryString, Artist.class);
            artists = (ArrayList<Artist>) jpqlQuery.getResultList();


        }
        return artists;

    }



}
