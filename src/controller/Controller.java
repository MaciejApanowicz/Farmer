package controller;

import model.Barn;
import model.Farmer;
import view.UserView;

import java.util.Scanner;
import static java.lang.System.out;
import static java.lang.System.setOut;

public class Controller {
    private Scanner scanner;
    private Farmer janusz;

    public Controller() {
        scanner = new Scanner(System.in);
        janusz = new Farmer();
    }

    public void start() {
        UserView.welcomeMessage();
        createMenu();
    }

    public void createMenu() {
        int choose;
        String barnName;
        do {
            UserView.showMenu();
            choose = scanner.nextInt();
            switch (choose) {
                case 1: {
                    UserView.showFarmerBarns();
                    if (janusz.barnArray[0] == null) {
                        UserView.messageNoBarnsYet();
                        UserView.askForTheNextTask();
                    }   else {
                        janusz.showMyBarns();
                        UserView.askForTheNextTask();
                    }   break;
                }
                case 2: {
                    System.out.println("Pierwszy skaner nie działa: ");
                    String pierwszySkaner = scanner.nextLine(); //nie działa pierwszy skaner.
                    System.out.println("Drugi skaner działa: ");
                    String drugiSkaner = scanner.nextLine(); // ale drugi skaner już działa
                    System.out.println("Trzeci skaner też działa!: ");
                    String trzeciSkaner = scanner.nextLine(); // no i trzeci też działa prawidłowo

                    System.out.println("pierwszy skaner: " + pierwszySkaner);
                    System.out.println("drugi skaner: " + drugiSkaner);
                    System.out.println("trzeci skaner: " + trzeciSkaner);

                    Barn newBarn = new Barn(trzeciSkaner,4);
                    newBarn.setId();
                    janusz.addBarn(newBarn);
                    out.println(UserView.confirmationThatBarnHasBeenBuilt() + newBarn.toString());
                    UserView.askForTheNextTask();
                    break;
                }
            }
        }while (choose != 3) ;
        UserView.messageExit();
    }
}