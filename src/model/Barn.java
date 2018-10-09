package model;

import view.UserView;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Barn implements Serializable{
    private static int nextID = 0;
    private int id;
    private String name;
    private ArrayList<Animal> animals;

    public Barn(String name){
        this.name = name;
        this.animals = new ArrayList<>();
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public final void setId(){
        id = nextID;
        nextID++;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animalToAdd){
                this.animals.add(animalToAdd);
    }

    @Override
    public String toString() {
        return "Barn(" +
                "id=" + id +
                ", name=" + name +
                ", animals=" + animals +
                ')';
    }
    public String barnFormatToWrite(){
        return id + ";" + name +"[."+animalsToWrite(animals);
    }
    public String animalsToWrite (ArrayList<Animal> animals){
        StringBuilder allAnimals = new StringBuilder();
        for (Animal a : animals){
            String animal = a.formatToWrite();
            allAnimals = allAnimals.append(animal);
        }
        String allAnimalsInBarnToWrite = allAnimals.toString();
        return allAnimalsInBarnToWrite;
    }

    public static void writeBarn (Barn barnToWrite){
        File file = new File("Barn.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.write(file.toPath(), (barnToWrite.barnFormatToWrite()+ '\r'+'\n').getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Barn readData(Scanner in){
        String line = in.nextLine();
        String[] parts = line.split("\\[");
        String dataNeededForBarnCreation = parts[0];
        String[] barnData = dataNeededForBarnCreation.split(";");
        int id = Integer.parseInt(barnData[0]);
        String name = barnData[1];
        Barn newBarn = new Barn(name);
        String dataNeededForAnimals = parts[1].substring(1);
        if (!dataNeededForAnimals.isEmpty()) {
            newBarn.setAnimals(Animal.animalsInTheBarn(dataNeededForAnimals));
        }
        System.out.println(UserView.confirmationThatBarnHasBeenBuilt() + newBarn.toString());
        return newBarn;
    }
}

