package util;

import domain.*;
import domain.interfaces.PrintableInList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;

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

    public ArrayList<String> queryLanden() {
        var queryString = "SELECT c.name FROM Country c WHERE (c.countryID >= 1 and c.countryID <= 10)";
        var jpqlQuery = em.createQuery(queryString, String.class);
        var names = (ArrayList<String>) jpqlQuery.getResultList();

        return names;
    }

    public ArrayList<? extends PrintableInList> querySteden(int countryID) {
        var queryString = "SELECT c FROM City c WHERE (c.country.countryID = '"+countryID+"')";
        var jpqlQuery = em.createQuery(queryString, City.class);
        var cities = (ArrayList<City>) jpqlQuery.getResultList();

        return cities;
    }

    public ArrayList<? extends PrintableInList> queryArtists() {
        var queryString = "SELECT a FROM Artist a";
        var jpqlQuery = em.createQuery(queryString, Artist.class);
        var artists = (ArrayList<Artist>) jpqlQuery.getResultList();

        return artists;

    }

    public ArrayList<? extends PrintableInList> queryMusea(Long cityID) {
        var queryString = "SELECT loc FROM Location loc WHERE (loc.city.cityID = '"+cityID+"')";
        var jpqlQuery = em.createQuery(queryString, Location.class);
        var names = (ArrayList<Location>) jpqlQuery.getResultList();

        return names;
    }

    public String queryStad(Long cityID) {
        var queryString = "SELECT c.name FROM City c WHERE (c.cityID = '"+cityID+"')";
        var jpqlQuery = em.createQuery(queryString, String.class);
        var name = jpqlQuery.getSingleResult();

        return name;
    }

    public ArrayList<? extends PrintableInList> queryArtistsInMuseum(Long locationID) {
        var queryString = "SELECT a.artist FROM Artwork a WHERE a.location.locationID = '"+locationID+"'";
        var jpqlQuery = em.createQuery(queryString, Artist.class);
        var artists = (ArrayList<Artist>) jpqlQuery.getResultList();

        return artists;
    }

    public ArrayList<Location> queryMuseaUitVerlanglijst() {
        var queryString = "SELECT l FROM Location l WHERE l.verlanglijst.verlangID=1";
        var jpqlQuery = em.createQuery(queryString, Location.class);
        var locations =  (ArrayList<Location>) jpqlQuery.getResultList();

        return locations;
    }

    public void zetMuseumOpVerlanglijstje(Long option) {
        tx.begin();
        Verlanglijst verlanglijst = em.find(Verlanglijst.class, 1L);
        Location location = em.find(Location.class, option);
        location.setVerlanglijst(verlanglijst);
        em.merge(location);
        tx.commit();
    }

    public void verwijderMuseumVanVerlanglijstje(Long option) {
        tx.begin();
        Location location = em.find(Location.class, option);
        location.setVerlanglijst(null);
        em.merge(location);
        tx.commit();
    }

    public ArrayList<Location> queryMuseaBijKunstenaar(Long kunstenaar) {
        var queryString = "SELECT a.location FROM Artwork a WHERE a.artist.artistID= '"+kunstenaar+"'";
        var jpqlQuery = em.createQuery(queryString, Location.class);
        var locations =  (ArrayList<Location>) jpqlQuery.getResultList();

        return locations;
    }

    public ArrayList<? extends PrintableInList> queryKunstwerkenOpMuseumEnKunstenaar(Long locationID, Long artistID) {
        var queryString = "SELECT a FROM Artwork a WHERE a.location = '"+locationID+"' AND a.artist='"+artistID+"'";
        var jpqlQuery = em.createQuery(queryString, Artwork.class);
        var artworks =  (ArrayList<Artwork>) jpqlQuery.getResultList();

        return artworks;
    }

    public Artist queryArtist(Long artistID) {
        var queryString = "SELECT a FROM Artist a WHERE a.artistID= '"+artistID+"' ";
        var jpqlQuery = em.createQuery(queryString, Artist.class);
        var artist = jpqlQuery.getSingleResult();

        return artist;

    }

    public Location queryMuseum(Long locationID) {
        var queryString = "SELECT l FROM Location l WHERE l.locationID = '"+locationID+"' ";
        var jpqlQuery = em.createQuery(queryString, Location.class);
        var location = jpqlQuery.getSingleResult();

        return location;
    }

    public Location queryMuseumVoorKunstwerk(Long artworkID) {
        var queryString = "SELECT a.location FROM Artwork a WHERE a.artworkID = '"+artworkID+"' ";
        var jpqlQuery = em.createQuery(queryString, Location.class);
        var location = jpqlQuery.getSingleResult();

        return location;
    }

    public Artwork queryArtwork(Long artworkID) {
        var queryString = "SELECT a FROM Artwork a WHERE a.artworkID = '"+artworkID+"' ";
        var jpqlQuery = em.createQuery(queryString, Artwork.class);
        var artwork = jpqlQuery.getSingleResult();

        return artwork;
    }

    public ArrayList<Artwork> queryAllArtworkInCountry(Long countryID) {
        var queryString = "SELECT a FROM Artwork a WHERE a.location.city.country.countryID= '"+countryID+"'";
        var jpqlQuery = em.createQuery(queryString, Artwork.class);
        var artworks = (ArrayList<Artwork>) jpqlQuery.getResultList();

        return artworks;
    }
}
