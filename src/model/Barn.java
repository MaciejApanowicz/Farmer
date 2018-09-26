package model;

import java.io.Serializable;
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
}

