package model;

public class Cow extends Animal {
    private final String TYPE = "COW";

    public Cow (String name, double age, boolean isVaccinated){
        super(name, age, isVaccinated);
    }

    public final String getTYPE(){
        return TYPE;
    }
    public void sound(){
        System.out.println("moo moomooo");
    }
}
