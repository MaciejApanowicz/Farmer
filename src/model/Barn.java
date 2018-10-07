package model;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Barn implements Serializable{
    private static int nextID = 0;
    private int id;
    private String name;
    private ArrayList<Animal> animals;

    public Barn(String name){
        this.name = name;
        this.animals = new ArrayList<>();
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
            Files.write(file.toPath(), (barnToWrite.toString()+ '\r'+'\n').getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

