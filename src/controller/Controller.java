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
                    showFarmerBarns();
                    }
                    break;
                case 2: {
                    buildNewBarn();
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
                            createNewAnimal();
                            Pig pigToAdd = new Pig(Farmer.getAnimalToAdd().getName(),Farmer.getAnimalToAdd().getAge(),Farmer.getAnimalToAdd().isVaccinated());
                            addAnimalToBarn(pigToAdd);
                            break;
                        }
                        case 2: {
                            createNewAnimal();
                            Cow cowToAdd = new Cow(Farmer.getAnimalToAdd().getName(),Farmer.getAnimalToAdd().getAge(),Farmer.getAnimalToAdd().isVaccinated());
                            addAnimalToBarn(cowToAdd);
                            break;
                        }
                        case 3: {
                            createNewAnimal();
                            Sheep animalToAdd = new Sheep(Farmer.getAnimalToAdd().getName(),Farmer.getAnimalToAdd().getAge(),Farmer.getAnimalToAdd().isVaccinated());
                            addAnimalToBarn(animalToAdd);
                            break;
                        }
                        case 4: {
                            createNewAnimal();
                            Horse horseToAdd = new Horse(Farmer.getAnimalToAdd().getName(),Farmer.getAnimalToAdd().getAge(),Farmer.getAnimalToAdd().isVaccinated());
                            addAnimalToBarn(horseToAdd);
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

    private void showFarmerBarns(){
        UserView.showFarmerBarns();
        if (janusz.countFarmerBarns()==0){
            UserView.messageNoBarnsYet();
            UserView.askForTheNextTask();
        } else {
            janusz.showMyBarns();
            UserView.askForTheNextTask();
        }
    }

    private void buildNewBarn(){
        UserView.askForTheNameOfNewBarn();
        Scanner scanner2 = new Scanner(System.in);
        String barnName = scanner2.nextLine();
        Barn newBarn = new Barn(barnName);
        newBarn.setId();
        janusz.addBarn(newBarn);
        out.println(UserView.confirmationThatBarnHasBeenBuilt() + newBarn.toString());
        UserView.askForTheNextTask();
    }

    private void createNewAnimal(){
        UserView.someQuestionsAboutNewAnimal();
        Scanner scanner = new Scanner(System.in);
        UserView.askForAnimalName();
        String animalName = scanner.nextLine();
        UserView.askForAnimalAge();
        double animalAge = scanner.nextDouble();
        UserView.askIfVaccinated();
        boolean isItVaccinated = scanner.hasNext("yes");
        Farmer.setAnimalToAdd(new Animal(animalName,animalAge,isItVaccinated));
    }

    private void addAnimalToBarn(Animal animalToAdd){
        UserView.showFarmerBarns();
        janusz.showMyBarns();
        UserView.askForBarnNumberToAddAnimal();
        int whichBarn = this.scanner.nextInt();
        janusz.farm.get(whichBarn - 1).addAnimal2(animalToAdd);
        UserView.confirmationAddAnimal();
        System.out.println(janusz.farm.get(whichBarn - 1).toString());
        System.out.println();
    }
}

