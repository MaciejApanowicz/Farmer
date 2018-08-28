package controller;

import model.*;
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

    private void createMenu() {
        int choose;
        do {
            UserView.showMenu();
            choose = this.scanner.nextInt();
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
                    Scanner scanner2 = new Scanner(System.in);
                    String barnName = scanner2.nextLine();
                    UserView.askHowManyAnimalsWillBeInThisBarn();
                    int capacity = scanner2.nextInt();
                    Barn newBarn = new Barn(barnName,capacity);
                    newBarn.setId();
                    janusz.addBarn(newBarn);
                    out.println(UserView.confirmationThatBarnHasBeenBuilt() + newBarn.toString());
                    UserView.askForTheNextTask();
                    break;
                }
                case  3:{
                    if (janusz.countFarmerBarns() == 0){
                        UserView.tryingAddAnimalWithoutHavingAnyBarn();
                        break;
                    }
                    UserView.messageAfter3rdOption();
                    UserView.showAvailiabeAnimalType();
                    int animalType = scanner.nextInt();
                    Scanner scanner3 = new Scanner(System.in);
                    switch (animalType){
                        case 1: {
                            UserView.someQuestionsAboutNewAnimal();
                            UserView.askForAnimalName();
                            String pigName = scanner3.nextLine();
                            UserView.askForAnimalAge();
                            double pigAge = scanner3.nextDouble();
                            UserView.askIfVaccinated();
                            boolean isItVacinated = scanner3.hasNext("yes");
                            Animal animalToAdd = new Pig(pigName,pigAge,isItVacinated);
                            UserView.showFarmerBarns();
                            janusz.showMyBarns();
                            UserView.askForBarnNumberToAddAnimal();
                            int whichBarn = scanner.nextInt();
                            janusz.barnArray[whichBarn-1].addAnimal(animalToAdd);
                            UserView.confirmationAddAnimal();
                            System.out.println(janusz.barnArray[whichBarn-1].toString());
                            System.out.println();
                            break;
                        }
                        case 2: {
                            UserView.someQuestionsAboutNewAnimal();
                            UserView.askForAnimalName();
                            String cowName = scanner3.nextLine();
                            UserView.askForAnimalAge();
                            double cowAge = scanner3.nextDouble();
                            UserView.askIfVaccinated();
                            boolean isItVacinated = scanner3.hasNext("yes");
                            Animal animalToAdd = new Cow(cowName,cowAge,isItVacinated);
                            UserView.showFarmerBarns();
                            janusz.showMyBarns();
                            UserView.askForBarnNumberToAddAnimal();
                            int whichBarn = scanner.nextInt();
                            janusz.barnArray[whichBarn-1].addAnimal(animalToAdd);
                            UserView.confirmationAddAnimal();
                            System.out.println(janusz.barnArray[whichBarn-1].toString());
                            System.out.println();
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