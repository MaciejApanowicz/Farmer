package model;

import java.io.Serializable;

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
