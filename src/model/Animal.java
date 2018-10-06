package model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

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
        File file = new File("All_Animals_added_history.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.write(file.toPath(), (a.toString()+ '\r'+'\n').getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
}
