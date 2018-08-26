package controller;

import model.Animal;
import model.Barn;
import model.Farmer;
import model.Pig;
import view.UserView;

import java.util.Scanner;

import static java.lang.System.out;

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
                    UserView.askForTheNameOfNewBarn();
                    barnName = scanner.next();
                    Barn newBarn = new Barn(barnName,4);
                    newBarn.setId();
                    janusz.addBarn(newBarn);
                    out.println(UserView.confirmationThatBarnHasBeenBuilt() + newBarn.toString());
                    UserView.askForTheNextTask();
                    break;
                }
                case  3:{
                    UserView.messageAfter3rdOption();
                    UserView.showAvailiabeAnimalType();
                    int animalType = scanner.nextInt();
                    switch (animalType){
                        case 1: {
                            System.out.println("So farmer , you want to add new Pig?");
                            Animal test = new Pig("piggy",0.5,false);
                            janusz.barnArray[0].addAnimal(test);
                            System.out.println("Swinka została dołączona do farmy");
                            janusz.showMyBarns();
                            break;
                        }
                        case 2: {
                            break;
                        }
                        case 3: {
                            System.out.println();
                            break;
                        }
                    }

                }
            }
        }while (choose != 4) ;
        UserView.messageExit();
    }
}