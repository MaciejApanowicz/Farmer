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
                    Scanner scanner2 = new Scanner(System.in);
                    UserView.askForTheNameOfNewBarn();
                    String pierwszySkaner = scanner2.nextLine();

                    Barn newBarn = new Barn(pierwszySkaner,4);
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