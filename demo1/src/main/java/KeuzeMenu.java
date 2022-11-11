import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class KeuzeMenu {

    ArrayList<String> optionsHoofdMenu;
    ArrayList<String> optionsPlanKunstreis;
    ArrayList<String> optionsReserveerKunsttour;
    Scanner scanner;
    DatabaseHelper databaseHelper;

    public KeuzeMenu() {

        scanner = new Scanner(System.in);
        databaseHelper = new DatabaseHelper();

        optionsHoofdMenu = new ArrayList<>(
                List.of("1- Alle musea met impressionistische kunst in Parijs",
                        "2- Plan de kunstreis",
                        "3- Reserveer een kunsttour (WIP)",
                        "4- Exit")
        );

        optionsPlanKunstreis = new ArrayList<>(
                List.of("1- Kies een stad die u wilt bezoeken",
                        "2- Kies een kunstenaar die u wilt bezichtigen",
                        "3- Ga één optie terug")
        );

        optionsReserveerKunsttour = new ArrayList<>(
                List.of("1- Kies een stad die u wilt bezoeken",
                        "2- Kies één of meer kunstenaars die u wilt bezichtigen",
                        "3- Ga één optie terug")
        );
    }



    public void toonHoofdmenu() {

        int option = 1;
        while (option!=optionsHoofdMenu.size()) {
            printMenu(optionsHoofdMenu);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1: option1(databaseHelper); break;
                    case 2: planReisMenu(); break;
                    case 3: option3(databaseHelper); break;
                    case 4: exit(0);
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 1 and " + optionsHoofdMenu.size());
                scanner.next();
            }
        }
    }

//    private void verwerkMenuKeuze(int option) {
//
//        switch (option) {
//            case 1: option1(databaseHelper); break;
//            case 2: option2(databaseHelper, scanner); break;
//            case 3: option3(databaseHelper); break;
//            case 4: exit(0);
//        }
//    }

    private void printMenu(ArrayList<String> options){
        System.out.println();
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    private void planReisMenu() {
        int option = 1;
        while (option!=optionsPlanKunstreis.size()) {
            printMenu(optionsPlanKunstreis);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1: option1(databaseHelper); break;
                    case 2: artistMenu(); break;
                    case 3: option3(databaseHelper); break;
                    case 4: exit(0);
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 1 and " + optionsPlanKunstreis.size());
                scanner.next();
            }
        }
    }

    private void artistMenu() {

        int option = 1;
        while (option!=optionsPlanKunstreis.size()) {
            toonArtists();
            try {
                option = scanner.nextInt();
                databaseHelper.querySteden(option);
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 1 and " + optionsPlanKunstreis.size());
                scanner.next();
            }
        }

    }

    private void toonArtists() {
        System.out.println();
        ArrayList<Artist> artists = databaseHelper.queryArtists(new ArrayList<Integer>());
        for (Artist artist : artists) {
            System.out.println("" + artist.getArtistid() + "- " + artist.getName());
        }
        System.out.print("Choose your option : ");
    }

    // Options

    //Alle musea met impressionistische kunst in Parijs
    public void option1(DatabaseHelper databaseHelper) {

        databaseHelper.queryMuseaInParijs();

    }

    //Plan de kunstreis
    public void option2(DatabaseHelper databaseHelper, Scanner scanner) {

        int option = 1;
        while (option!=optionsPlanKunstreis.size()) {
            printMenu(optionsPlanKunstreis);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1: option1sub1(databaseHelper, scanner); break;
                    case 2: option1sub2(databaseHelper, scanner); break;
                    case 3: break;
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 1 and " + optionsPlanKunstreis.size());
                scanner.next();
            }
        }
    }

    //Reserveer een kunsttour
    public void option3(DatabaseHelper databaseHelper) {
        System.out.println("Thanks for choosing option 3");
    }

    //Kies één of meer steden die u wilt bezoeken
    public void option1sub1(DatabaseHelper databaseHelper, Scanner scanner) {
        System.out.println("Thanks for choosing option 1.1");
    }

    //Kies één of meer kunstenaars die u wilt bezichtigen
    public void option1sub2(DatabaseHelper databaseHelper, Scanner scanner) {
        System.out.println("Thanks for choosing option 1.2");
    }
}
