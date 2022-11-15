package main;

import util.KeuzeMenu;

public class TravelToSeeArt {

    public static void main(String[] args) {

        KeuzeMenu keuzeMenu = new KeuzeMenu();
        keuzeMenu.toonHoofdmenu();
        
    }

}



















//    public static void printMenu(String[] options){
//        System.out.println();
//        for (String option : options) {
//            System.out.println(option);
//        }
//        System.out.print("Choose your option : ");
//    }
//
//    // Options
//
//    //Alle musea met impressionistische kunst in Parijs
//    private static void option1(util.DatabaseHelper databaseHelper) {
//
//        databaseHelper.queryMuseaInParijs();
//
//    }
//
//    //Plan de kunstreis
//    private static void option2(util.DatabaseHelper databaseHelper, Scanner scanner) {
//
//        String[] options = {"1- Kies één of meer steden die u wilt bezoeken",
//                "2- Kies één of meer kunstenaars die u wilt bezichtigen",
//                "3- Ga één optie terug",
//        };
//
//        int option = 1;
//        while (option!=options.length) {
//            printMenu(options);
//            try {
//                option = scanner.nextInt();
//                switch (option) {
//                    case 1: option1sub1(databaseHelper, scanner); break;
//                    case 2: option1sub2(databaseHelper, scanner); break;
//                    case 3: break;
//                }
//            }
//            catch (Exception ex){
//                System.out.println("Please enter an integer value between 1 and " + options.length);
//                scanner.next();
//            }
//        }
//    }
//
//    //Reserveer een kunsttour
//    private static void option3(util.DatabaseHelper databaseHelper) {
//        System.out.println("Thanks for choosing option 3");
//    }
//
//    //Kies één of meer steden die u wilt bezoeken
//    private static void option1sub1(util.DatabaseHelper databaseHelper, Scanner scanner) {
//        System.out.println("Thanks for choosing option 1.1");
//    }
//
//    //Kies één of meer kunstenaars die u wilt bezichtigen
//    private static void option1sub2(util.DatabaseHelper databaseHelper, Scanner scanner) {
//        System.out.println("Thanks for choosing option 1.2");
//    }

