package model;

public abstract class Animal {
    private String name;
    private double age;
    private boolean isVaccinated;

    public Animal(String name, double age, boolean isVaccinated) {
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
    public String toString() {
        return '{' + getTYPE() +
                ", name= " + name +
                ", age= " + age +
                ", isVaccinated= " + isVaccinated +
                '}';
    }
}
