package model;

public abstract class Animal {
    private String name;
    private double age;
    private boolean isVaccinated;

    Animal(String name, double age, boolean isVaccinated){
        this.name = name;
        this.age = age;
        this.isVaccinated = isVaccinated;
    }
    public abstract String getTYPE();

    public final String getName (){
        return name;
    }

    public double getAge() {
        return age;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    @Override
    public String toString() {
        return "Animal{" +
                getTYPE() +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isVaccinated=" + isVaccinated +
                '}';
    }
}
