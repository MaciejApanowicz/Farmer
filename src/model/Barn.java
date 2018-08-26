package model;

import java.util.Arrays;

public class Barn {
    private static int nextID =1;
    private int id;
    private String name;
    private int capacity;
    private Animal[] animals;

    public Barn(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.animals = new Animal[capacity];
    }
    public int getId(){
        return id;
    }
    public void setId(){
        id = nextID;
        nextID++;
    }
    public String getName(){
        return name;
    }
    public int getCapacity() {
        return capacity;
    }
    public Animal[] getAnimals() {
        return animals;
    }
    public void addAnimal (Animal animalToAdd){
        for (int i = 0; i < animals.length; i ++){
            if (animals[i] == null){
                this.animals[i] = animalToAdd;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Barn{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", animals=" + (animals == null ? null : Arrays.asList(animals)) +
                '}';
    }
}

