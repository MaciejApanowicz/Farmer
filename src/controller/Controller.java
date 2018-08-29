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
                    } else {
                        janusz.showMyBarns();
                        UserView.askForTheNextTask();
                }

                break;
                }
                case 2: {
                    UserView.askForTheNameOfNewBarn();
                    Scanner scanner = new Scanner(System.in);
                    String barnName = scanner.nextLine();
                    UserView.askHowManyAnimalsWillBeInThisBarn();
                    int capacity = scanner.nextInt();
                    Barn newBarn = new Barn(barnName, capacity);
                    newBarn.setId();
                    janusz.addBarn(newBarn);
                    out.println(UserView.confirmationThatBarnHasBeenBuilt() + newBarn.toString());
                    UserView.askForTheNextTask();
                    break;

                }

                case 3: {

                    if (janusz.countFarmerBarns() == 0) {

                        UserView.tryingAddAnimalWithoutHavingAnyBarn();

                        break; }

                    UserView.messageAfter3rdOption();

                    UserView.showAvailiabeAnimalType();

                    int animalType = scanner.nextInt();
                    Scanner scanner = new Scanner(System.in);
                    switch (animalType) {

                        case 1: {
        UserView.someQuestionsAboutNewAnimal();
        UserView.askForAnimalName();
                            String pigName = scanner.nextLine();
        UserView.askForAnimalAge();
                            double pigAge = scanner.nextDouble();
        UserView.askIfVaccinated();

        boolean isItVaccinated = scanner.hasNext("yes");
                            Animal animalToAdd = new Pig(pigName, pigAge, isItVaccinated);
        UserView.showFarmerBarns();

        janusz.showMyBarns();

        UserView.askForBarnNumberToAddAnimal();

        int whichBarn = this.scanner.nextInt();

        janusz.barnArray[whichBarn - 1].addAnimal(animalToAdd);

        UserView.confirmationAddAnimal();

        System.out.println(janusz.barnArray[whichBarn - 1].toString());

        System.out.println();
                            break;
    }
                        case 2: {
        UserView.someQuestionsAboutNewAnimal();
        UserView.askForAnimalName();
                            String cowName = scanner.nextLine();
        UserView.askForAnimalAge();
                            double cowAge = scanner.nextDouble();
        UserView.askIfVaccinated();

        boolean isItVaccinated = scanner.hasNext("yes");
                            Animal animalToAdd = new Cow(cowName, cowAge, isItVaccinated);
        UserView.showFarmerBarns();

        janusz.showMyBarns();

        UserView.askForBarnNumberToAddAnimal();

        int whichBarn = this.scanner.nextInt();

        janusz.barnArray[whichBarn - 1].addAnimal(animalToAdd);

        UserView.confirmationAddAnimal();

        System.out.println(janusz.barnArray[whichBarn - 1].toString());

        System.out.println();
                            break;
    }
                        case 3: {
        UserView.someQuestionsAboutNewAnimal();
        UserView.askForAnimalName();

        String animalName = scanner.nextLine();

        UserView.askForAnimalAge();

        double animalAge = scanner.nextDouble();

        UserView.askIfVaccinated();

        boolean isItVaccinated = scanner.hasNext("yes");
                            Animal animalToAdd = new Sheep(animalName, animalAge, isItVaccinated);
        UserView.showFarmerBarns();

        janusz.showMyBarns();

        UserView.askForBarnNumberToAddAnimal();

        int whichBarn = this.scanner.nextInt();

        janusz.barnArray[whichBarn - 1].addAnimal(animalToAdd);

        UserView.confirmationAddAnimal();

        System.out.println(janusz.barnArray[whichBarn - 1].toString());

        System.out.println();
                            break;
    }
                        case 4: {
        UserView.someQuestionsAboutNewAnimal();
        UserView.askForAnimalName();

        String animalName = scanner.nextLine();

        UserView.askForAnimalAge();

        double animalAge = scanner.nextDouble();

        UserView.askIfVaccinated();

        boolean isItVaccinated = scanner.hasNext("yes");
                            Animal animalToAdd = new Horse(animalName, animalAge, isItVaccinated);
        UserView.showFarmerBarns();

        janusz.showMyBarns();

        UserView.askForBarnNumberToAddAnimal();

        int whichBarn = this.scanner.nextInt();

        janusz.barnArray[whichBarn - 1].addAnimal(animalToAdd);

        UserView.confirmationAddAnimal();

        System.out.println(janusz.barnArray[whichBarn - 1].toString());
                            System.out.println();
                            break;
                        }
                        case 5: {
        System.out.println();
                            break;
    }
                        default: {
                            UserView.instructUserToChooseCorrectly();
                            break;
                        }
                    }
    }
        }
        }   while (choose != 4) ;
            UserView.messageExit();

    }

}