package model;

import java.util.ArrayList;

public class Farmer {
    public ArrayList<Barn> farm;
    public static Animal animalToAdd;

    public Farmer(){
        farm = new ArrayList<>();
    }

    public void addBarn (Barn barnToAdd) {
       farm.add(barnToAdd);
    }

    public int countFarmerBarns(){
       return farm.size();
    }

    public void showMyBarns (){
        for (Barn b : farm){
            System.out.println(b.toString());
            }
    }
    public Animal getAnimalToAdd(){
        return animalToAdd;
    }
    public static void setAnimalToAdd(Animal animalToAdd) {
        Farmer.animalToAdd = animalToAdd;
    }
}



