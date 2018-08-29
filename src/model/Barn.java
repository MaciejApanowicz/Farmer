package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Barn {
    private static int nextID =1;
    private int id;
    private String name;
    private ArrayList<Animal> animals2;

    public Barn(String name){
        this.name = name;
        this.animals2 = new ArrayList<>();
    }
    public int getId(){
        return id;
    }
    public void setId(){
        id = nextID;
        nextID++;
    }

    public void addAnimal2 (Animal animalToAdd){
                this.animals2.add(animalToAdd);
    }

    @Override
    public String toString() {
        return "Barn(" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", animals2=" + animals2 +
                ')';
    }
}

