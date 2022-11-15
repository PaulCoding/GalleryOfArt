package util;

import domain.Artwork;
import domain.Location;
import domain.interfaces.PrintableInList;

import java.util.*;

import static java.lang.System.exit;

public class KeuzeMenu {

    private ArrayList<String> optionsHoofdMenu;
    private ArrayList<String> optionsReserveerRondleiding;
    private ArrayList<String> optionsReserveerRondleiding2;
    private ArrayList<String> optionsVindMusea;
    private ArrayList<String> optionsMuseumVerlanglijstje;
    private ArrayList<String> triviaVragen;
    private Scanner scanner;
    private DatabaseHelper databaseHelper;

    public KeuzeMenu() {

        scanner = new Scanner(System.in);
        databaseHelper = new DatabaseHelper();

        optionsHoofdMenu = new ArrayList<>(
                List.of("Vind musea met impressionistische kunst",
                        "Uw verlanglijstje",
                        "Reserveer een rondleiding (WIP)",
                        "Leuke trivia!",
                        "Sluit programma")
        );

        optionsVindMusea = new ArrayList<>(
                List.of("Zoek op landen",
                        "Zoek op kunstenaars",
                        "Ga één optie terug")
        );

        optionsReserveerRondleiding = new ArrayList<>(
                List.of("Toon musea op verlanglijstje, om rondleiding te reserveren",
                        "Ga één optie terug")
        );

        optionsReserveerRondleiding2 = new ArrayList<>(
                List.of("Kies een stad die u wilt bezoeken",
                        "Kies één of meer kunstenaars die u wilt bezichtigen",
                        "Ga één optie terug")
        );

        optionsMuseumVerlanglijstje = new ArrayList<>(
                List.of("Zet dit museum op verlanglijstje",
                        "Ga terug naar het hoofdmenu")
        );

        triviaVragen = new ArrayList<>(
                List.of("Kan ik in Parijs 'de opkomende zon' van Claude Monet bezichtigen?",
                        "Kan ik het beste naar Otterlo (Hoge Veluwe) of Moscow gaan, om Signac te zien?",
                        "Als ik zoveel mogelijk impressionistische kunst wil zien, kan ik dan het beste naar Frankrijk of de Verenigde Staten gaan?")
        );
    }

    public void toonHoofdmenu() {

        int option = 1;
        while (option != optionsHoofdMenu.size()) {
            System.out.println();
            System.out.println("= Travel To See Art =");
            System.out.println();
            System.out.println(" - Hoofdmenu -");
            printMenu(optionsHoofdMenu);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        vindMuseaMenu();
                        break;
                    case 2:
                        toonVerlanglijstje();
                        break;
                    case 3:
                        reserveerRondleidingMenu();
                        break;
                    case 4:
                        triviaMenu();
                        break;
                    case 5:
                        exit(0);
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter an integer value between 1 and " + optionsHoofdMenu.size());
                scanner.next();
            }
        }
    }

    private void triviaMenu() {
        int option = 1;
        while (option != 0) {
            System.out.println();
            System.out.println(" - Leuke trivia -");
            System.out.println();
            System.out.println("Elke week nieuwe vragen, die we aan onze database kunnen stellen: ");
            System.out.println();
            for (int i = 0; i < triviaVragen.size(); i++) {
                System.out.println((i + 1) + "-  " + triviaVragen.get(i));
            }
            System.out.println();
            System.out.println("0- Ga terug naar het hoofdmenu");
            System.out.println();
            System.out.print("Uw keuze: ");
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        kanIkInParijsDeOpgaandeZonBezichtigen();
                        break;
                    case 2:
                        otterloOfMoscowVoorSignac();
                        break;
                    case 3:
                        meerKunstInFrankrijkOfVS();
                        break;
                    case 0:
                        break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter an integer value between 1 and " + triviaVragen.size());
                scanner.next();
            }
        }
    }

    private void kanIkInParijsDeOpgaandeZonBezichtigen() {
        Long artworkID = 484L;
        Artwork artwork = databaseHelper.queryArtwork(artworkID);
        Location location = databaseHelper.queryMuseumVoorKunstwerk(artworkID);
        System.out.println();
        System.out.println(" - Kan ik in Parijs 'de opkomende zon' van Claude Monet bezichtigen? - ");
        System.out.println();
        System.out.println("  Yes! 'Impression, soleil levant' is al sinds 1940 te zien in " + location.getName() + ".");
        System.out.println("  Dit is het schilderij, waaraan het impressionisme zijn naam te danken heeft.");
        System.out.println("  Geschilderd door " + artwork.getArtist().getName() + " in het jaar " + artwork.getYear() + ".");
        System.out.println();

        int option = 1;
        while (option != 0) {
            System.out.println("0- Ga terug naar trivia");
            System.out.println();
            System.out.print("Uw keuze: ");

            try {
                option = scanner.nextInt();
                if (option == 0) {
                    break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter the integer value 0");
                scanner.next();
            }
        }

    }


    private void otterloOfMoscowVoorSignac() {
        Long artistID = 9L;
        var locations = databaseHelper.queryMuseaBijKunstenaar(artistID);
//        ArrayList<Artwork> artworks = databaseHelper.queryMuseaSignac();
        Location otterlo = new Location();
        Location moscow = new Location();
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).getCity().getName().equals("Otterlo")) {
                otterlo = locations.get(i);
            } else if (locations.get(i).getCity().getName().equals("Moscow")) {
                moscow = locations.get(i);
            }
        }
        int aantalOtter = otterlo.getArtworks().size();
        int aantalMos = moscow.getArtworks().size();
        System.out.println();
        System.out.println(" - Kan ik het beste naar Otterlo (Hoge Veluwe) of Moscow gaan, om Signac te zien? - ");
        System.out.println();
        System.out.println("  Goede vraag! Zowel Otterlo als Moscow hebben maar 1 schilderij van Signac.");
        System.out.println("  Om de aantallen hoef je het dus niet te doen.");
        System.out.println("  In het Kröller-Müller hangt het schilderij 'Breakfast' en in het Pushkin Museum hangt 'Pine Tree at Saint-Tropez'");
        System.out.println("  Het komt dus puur aan op je persoonlijke voorkeur!");
        System.out.println();

        int option = 1;
        while (option != 0) {
            System.out.println("0- Ga terug naar trivia");
            System.out.println();
            System.out.print("Uw keuze: ");

            try {
                option = scanner.nextInt();
                if (option == 0) {
                    break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter the integer value 0");
                scanner.next();
            }
        }
    }

    private void meerKunstInFrankrijkOfVS() {
        Long franceID = 1L;
        Long vsID = 10L;
        ArrayList<Artwork> frArtworks = databaseHelper.queryAllArtworkInCountry(franceID);
        ArrayList<Artwork> vsArtworks = databaseHelper.queryAllArtworkInCountry(vsID);
        System.out.println();
        System.out.println(" - Als ik zoveel mogelijk impressionistische kunst wil zien, kan ik dan het beste naar Frankrijk of de Verenigde Staten gaan? - ");
        System.out.println();
        System.out.println("  De Verenigde Staten wint dit maar net met " + + vsArtworks.size() + " kunstwerken, waar Frankrijk er " + frArtworks.size() + " heeft.");
        System.out.println();

        int option = 1;
        while (option != 0) {
            System.out.println("0- Ga terug naar trivia");
            System.out.println();
            System.out.print("Uw keuze: ");

            try {
                option = scanner.nextInt();
                if (option == 0) {
                    break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter the integer value 0");
                scanner.next();
            }
        }

    }

    private void reserveerRondleidingMenu() {

        int option = 0;
        while (option != optionsReserveerRondleiding.size()) {
            System.out.println();
            System.out.println(" - Reserveer een rondleiding -");
            printMenu(optionsReserveerRondleiding);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        toonVerlanglijstjeOmTeReserveren();
                        break;
                    case 2:
                        break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter an integer value between 1 and " + optionsReserveerRondleiding.size());
                scanner.next();
            }
        }
    }

    private void toonVerlanglijstje() {
//        ArrayList<? extends PrintableInList> locations = databaseHelper.queryMuseaUitVerlanglijst();
        ArrayList<Location> locations = databaseHelper.queryMuseaUitVerlanglijst();

        if (locations != null) {
            Map<Integer, Long> map = new HashMap<>();
            for (int i = 0; i < locations.size(); i++) {
                map.put(i + 1, locations.get(i).getID());
            }
            System.out.println();
            System.out.println(" - Verlanglijstje -");
            System.out.println();

            int option = -1;
            while (!map.containsKey(option) || option == 0) {
                for (int i = 0; i < locations.size(); i++) {
                    System.out.println((i + 1) + "-  " + locations.get(i).getName() + ", " + locations.get(i).getCity().getName() +
                            ", " + locations.get(i).getCity().getCountry().getName());
                }
                System.out.println();
                System.out.println("0- Ga terug naar het hoofdmenu");
                System.out.println("   Of kies een museum om te verwijderen");
                System.out.println();

                System.out.print("Uw keuze: ");
                try {
                    option = scanner.nextInt();
                    if (option == 0) {
                        break;
                    }
                    verwijderMuseumVanVerlanglijstje(map.get(option));
                } catch (InputMismatchException ex) {
                    System.out.println("Please enter an integer value between 1 and " + locations.size());
                    scanner.next();
                }
            }
        } else {
            System.out.println("Uw verlanglijstje bevat nog geen musea");
        }
    }

    private void verwijderMuseumVanVerlanglijstje(Long option) {
        databaseHelper.verwijderMuseumVanVerlanglijstje(option);
        System.out.println();
        System.out.println("museum van verlanglijstje verwijderd");
    }

    private void toonVerlanglijstjeOmTeReserveren() {
        ArrayList<? extends PrintableInList> locations = databaseHelper.queryMuseaUitVerlanglijst();
        if (locations != null) {
            Map<Integer, Long> map = new HashMap<>();
            for (int i = 0; i < locations.size(); i++) {
                map.put(i + 1, locations.get(i).getID());
            }
            System.out.println();
            System.out.println(" - Verlanglijstje -");
            System.out.println();
            System.out.print("Kies een museum om een rondleiding te reserveren:");

            int option = 0;
            while (!map.containsKey(option)) {
                printEntitiesInMenu(locations);
                try {
                    option = scanner.nextInt();
                    rondleidingReserveren(map.get(option));      //museaMenu(map.get(option));
                } catch (InputMismatchException ex) {
                    System.out.println("Please enter an integer value between 1 and " + locations.size());
                    scanner.next();
                }
            }
        } else {
            System.out.println("Uw verlanglijstje bevat nog geen musea");
        }
    }

    private void rondleidingReserveren(Long option) {
//        System.out.println();
//        System.out.println("Rondleidingen reserveren wordt mogelijk in een volgende update");
    }

    private void vindMuseaMenu() {
        int option = 0;
        while (option < 1 || option > optionsVindMusea.size()) {
            printMenu(optionsVindMusea);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        landenMenu();
                        break;
                    case 2:
                        kunstenaarsMenu();
                        break;
                    case 3:
                        break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter an integer value between 1 and " + optionsHoofdMenu.size());
                scanner.next();
            }
        }
    }

    private void printEntitiesInMenu(ArrayList<? extends PrintableInList> options) {
        System.out.println();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + "-  " + options.get(i).getName());
        }
        System.out.println();
        System.out.print("Uw keuze: ");
    }

    private void printEntitiesMetVervolgOpties(ArrayList<? extends PrintableInList> options) {
        System.out.println();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + "-  " + options.get(i).getName());
        }
        System.out.println();
    }

    private void printMenu(ArrayList<String> options) {
        System.out.println();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + "-  " + options.get(i));
        }
        System.out.println();
        System.out.print("Uw keuze: ");
    }

    private void kunstenaarsMenu() {
        ArrayList<? extends PrintableInList> artists = databaseHelper.queryArtists();
        if (artists != null) {
            Map<Integer, Long> map = new HashMap<>();
            for (int i = 0; i < artists.size(); i++) {
                map.put(i + 1, artists.get(i).getID());
            }
            int option = 0;
            while (option < 1 || option > artists.size()) {
                System.out.println();
                System.out.println(" - Impressionistische kunstenaars - ");
                System.out.println();
                System.out.print("Kies een kunstenaar om bijbehorende musea te vinden:");
                printEntitiesInMenu(artists);
                try {
                    option = scanner.nextInt();
                    toonMuseaEnKunstwerkenVanKunstenaar(map.get(option));
                } catch (InputMismatchException ex) {
                    System.out.println("Please enter an integer value between 1 and " + artists.size());
                    scanner.next();
                }
            }
        } else {
            System.out.println("De kunstenaars kunnen op dit moment niet geladen worden");
        }
    }

    private void toonMuseaEnKunstwerkenVanKunstenaar(Long artistID) {
        var locations = databaseHelper.queryMuseaBijKunstenaar(artistID);
        var artist = databaseHelper.queryArtist(artistID);

        if (locations != null) {
            Set<Location> locationsSet = new HashSet<>(locations);
            ArrayList<Location> locs = new ArrayList<>();
            for (Location location : locationsSet) {
                locs.add(location);
            }

            Map<Integer, Long> map = new HashMap<>();
            for (int i = 0; i < locs.size(); i++) {
                map.put(i + 1, locs.get(i).getID());
            }
            int option = 0;
            while (option < 1 || option > locs.size()) {
                System.out.println();
                System.out.println(" - Musea met kunst van " + artist.getName() + " - ");
                System.out.println();
                for (int i = 0; i < locs.size(); i++) {
                    System.out.println((i + 1) + "-  " + locs.get(i).getName() + ", " + locs.get(i).getCity().getName() +
                            ", " + locs.get(i).getCity().getCountry().getName());
                }
                System.out.println();
//                printEntitiesMetVervolgOpties(locs);

                System.out.println("0- Ga terug naar het hoofdmenu");
                System.out.println("Of kies een museum om de kunstwerken te zien");
                System.out.println();

                System.out.print("Uw keuze: ");

                try {
                    option = scanner.nextInt();
                    if (option == 0) {
                        break;
                    }
                    toonKunstwerkenVanKunstenaarInMuseum(map.get(option), artistID);
                } catch (InputMismatchException ex) {
                    System.out.println("Please enter an integer value between 1 and " + locs.size());
                    scanner.next();
                }
            }
        } else {
            System.out.println("De musea kunnen op dit moment niet geladen worden");
        }

    }

    private void toonKunstwerkenVanKunstenaarInMuseum(Long locationID, Long artistID) {
        var artist = databaseHelper.queryArtist(artistID);
        var museum = databaseHelper.queryMuseum(locationID);

        ArrayList<? extends PrintableInList> kunstwerken = databaseHelper.queryKunstwerkenOpMuseumEnKunstenaar(locationID, artistID);
        if (kunstwerken != null) {
            Map<Integer, Long> map = new HashMap<>();
            for (int i = 0; i < kunstwerken.size(); i++) {
                map.put(i + 1, kunstwerken.get(i).getID());
            }
            System.out.println();
            System.out.println(" - Kunstwerken van " + artist.getName() + " in museum " + museum.getName() + " -");

            int option = 1;
            while (option != 0) { //!map.containsKey(option)
                System.out.println();
                for (PrintableInList kunstwerk : kunstwerken) {
                    System.out.println("-  " + kunstwerk.getName());
                }
                System.out.println();

                System.out.println("0- Ga terug naar het hoofdmenu");
                System.out.println();

                System.out.print("Uw keuze: ");
                try {
                    option = scanner.nextInt();
                    if (option == 0) {
                        break;
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("Please enter an integer value between 1 and " + kunstwerken.size());
                    scanner.next();
                }
            }
        } else {
            System.out.println("De kunstwerken kunnen op dit moment niet geladen worden");
        }
    }


    private void landenMenu() {
        ArrayList<String> landen = databaseHelper.queryLanden();
        int option = 0;
        while (option < 1 || option > landen.size()) {
            printMenu(landen);
            try {
                option = scanner.nextInt();
                stedenMenu(option);
            } catch (InputMismatchException ex) {
                System.out.println("Please enter an integer value between 1 and " + landen.size());
                scanner.next();
            }
        }
    }

    private void stedenMenu(int countryID) {
        ArrayList<? extends PrintableInList> steden = databaseHelper.querySteden(countryID);

        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < steden.size(); i++) {
            map.put(i + 1, steden.get(i).getID());
        }
        int option = 0;
        while (!map.containsKey(option)) {
            printEntitiesInMenu(steden);
            try {
                option = scanner.nextInt();
                museaMenu(map.get(option));
            } catch (InputMismatchException ex) {
                System.out.println("Please enter an integer value between 1 and " + steden.size());
                scanner.next();
            }
        }

    }

    private void museaMenu(Long cityID) {
        String stad = databaseHelper.queryStad(cityID);
        System.out.println();
        System.out.println("Musea in " + stad + " met impressionistische kunst:");

        ArrayList<? extends PrintableInList> musea = databaseHelper.queryMusea(cityID);
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < musea.size(); i++) {
            map.put(i + 1, musea.get(i).getID());
        }
        int option = 0;
        while (!map.containsKey(option)) {  //option < 1 || option > musea.size()
            printEntitiesInMenu(musea);
            try {
                option = scanner.nextInt();
                if (map.containsKey(option)) {
                    ArrayList<? extends PrintableInList> artists = databaseHelper.queryArtistsInMuseum(map.get(option));
                    Set<? extends PrintableInList> set = new HashSet<>(artists);
                    System.out.println();
                    System.out.println("De volgende kunstenaars zijn hier te zien: ");
                    for (PrintableInList artist : set) {
                        System.out.println(" - " + artist.getName());
                    }
                    verlangLijstjeToevoegenMenu(map.get(option));
                }

            } catch (InputMismatchException ex) {
                System.out.println("Please enter an integer value between 1 and " + musea.size());
                scanner.next();
            }
        }

    }

    private void verlangLijstjeToevoegenMenu(Long locationID) {
        int option = 0;
        while (option < 1 || option > optionsMuseumVerlanglijstje.size()) {
            printMenu(optionsMuseumVerlanglijstje);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        zetMuseumOpVerlanglijstje(locationID);
                        break;
                    case 2:
                        break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter an integer value between 1 and " + optionsMuseumVerlanglijstje.size());
                scanner.next();
            }
        }
    }

    private void zetMuseumOpVerlanglijstje(Long option) {
        databaseHelper.zetMuseumOpVerlanglijstje(option);
        System.out.println();
        System.out.println("museum op verlanglijstje gezet");
    }

}
