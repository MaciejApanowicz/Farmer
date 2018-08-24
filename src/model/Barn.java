package model;

import model.Animal;

import java.util.Arrays;

public class Barn {
    private int id;
    private String name;
    private int capacity;
    private Animal[] animals;

    public Barn(int id, String name, int capacity){
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.animals = new Animal[capacity];
    }
    public int getId(){
        return id;
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

