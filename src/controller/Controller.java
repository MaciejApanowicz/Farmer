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
                    showFarmerBarns(janusz);
                }
                break;
                case 2: {
                    handleAddNewBarn();
                    break;
                }
                case 3: {
                    if (janusz.countFarmerBarns() == 0) {
                        UserView.tryingAddAnimalWithoutHavingAnyBarn();
                        break;
                    }
                    UserView.messageAfter3rdOption();
                    UserView.showAvailiabeAnimalType();
                    int animalType = scanner.nextInt();
                    switch (animalType) {
                        case 1: {
                            addAnimalToBarn(createNewAnimal("PIG"));
                            break;
                        }
                        case 2: {
                            addAnimalToBarn( createNewAnimal("COW"));
                            break;
                        }
                        case 3: {
                            addAnimalToBarn( createNewAnimal("SHEEP"));
                            break;
                        }
                        case 4: {
                            addAnimalToBarn( createNewAnimal("HORSE"));
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
        } while (choose != 4);
        UserView.messageExit();
    }

    private void showFarmerBarns(Farmer farmer) {
        UserView.showFarmerBarns();
        if (farmer.countFarmerBarns() == 0) {
            UserView.messageNoBarnsYet();
            UserView.askForTheNextTask();
        } else {
            farmer.showMyBarns();
            UserView.askForTheNextTask();
        }
    }

    private void handleAddNewBarn() {
        Barn newBarn = buildNewBarn();
        janusz.addBarn(newBarn);
        out.println(UserView.confirmationThatBarnHasBeenBuilt() + newBarn.toString());
        UserView.askForTheNextTask();
    }

    private Barn buildNewBarn() {
        UserView.askForTheNameOfNewBarn();
        Scanner scanner = new Scanner(System.in);
        String barnName = scanner.nextLine();
        Barn newBarn = new Barn(barnName);
        newBarn.setId();
        return newBarn;
    }

    private Animal createNewAnimal(String animalType) {
        UserView.someQuestionsAboutNewAnimal();
        Scanner scanner = new Scanner(System.in);
        UserView.askForAnimalName();
        String animalName = scanner.nextLine();
        UserView.askForAnimalAge();
        double animalAge = scanner.nextDouble();
        UserView.askIfVaccinated();
        boolean isItVaccinated = scanner.hasNext("yes");
        return AnimalsFactory.getAnimal(animalType, animalName, animalAge,isItVaccinated);
    }

    private void addAnimalToBarn(Animal animalToAdd) {
        UserView.showFarmerBarns();
        janusz.showMyBarns();
        UserView.askForBarnNumberToAddAnimal();
        int whichBarn = this.scanner.nextInt();
        janusz.farm.get(whichBarn - 1).addAnimal(animalToAdd);
        UserView.confirmationAddAnimal();
        System.out.println(janusz.farm.get(whichBarn - 1).toString());
        System.out.println();
    }
}

