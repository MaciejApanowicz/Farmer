package model;

public class Sheep extends Animal {

    public Sheep(String name, double age, boolean isVaccinated) {
        super(name, age, isVaccinated);
    }

    public Sheep (){
    }

    public final String getTYPE() {
        return "SHEEP";
    }

    public void sound() {
        System.out.println("baa baa baa");
    }
}
