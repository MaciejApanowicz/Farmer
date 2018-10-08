package model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public abstract class Animal implements Serializable,Comparable {
    private String name;
    private double age;
    private boolean isVaccinated;

    Animal(String name, double age, boolean isVaccinated) {
        this.name = name;
        this.age = age;
        this.isVaccinated = isVaccinated;
    }
    public Animal (){
    }

    public final String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public abstract String getTYPE();

    public static void writeAnimal (Animal a){
        File file = new File("All_Animals_added_history2.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.write(file.toPath(), (a.formatToWrite()+ '\r'+'\n').getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Animal readAnimal (Scanner in){
        String line = in.nextLine();
        String[] tokens = line.split("\\|");

        String animalType = tokens[0];
        String name = tokens[1];
        double age = Double.parseDouble(tokens[2]);
        boolean isVaccinated = false;
        if (tokens[3].equals("true")) isVaccinated = true;
        for (String t : tokens){
            System.out.println(t);
        }
        if (animalType.equals("PIG")){
            return AnimalsFactory.getAnimal(animalType, name, age,isVaccinated);
        }
        System.out.println(AnimalsFactory.getAnimal(animalType, name, age,isVaccinated));
       return AnimalsFactory.getAnimal(animalType, name, age,isVaccinated);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (Double.compare(animal.age, age) != 0) return false;
        if (isVaccinated != animal.isVaccinated) return false;
        return name != null ? name.equals(animal.name) : animal.name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(age);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isVaccinated ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return '{' + getTYPE() +
                ", name= " + name +
                ", age= " + age +
                ", isVaccinated= " + isVaccinated +
                '}';
    }
    public String formatToWrite (){
        return getTYPE() + "|" + name + "|" + age +"|" + isVaccinated;
    }
}
