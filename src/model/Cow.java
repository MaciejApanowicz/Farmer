package model;

public class Cow extends Animal {

    public Cow(String name, double age, boolean isVaccinated) {
        super(name, age, isVaccinated);
    }
    public Cow(){
    };

    public final String getTYPE() {
        return "COW";
    }

    public void sound() {
        System.out.println("moo moomooo");
    }
}
