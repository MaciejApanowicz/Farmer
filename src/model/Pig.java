package model;

public class Pig extends Animal{
    private final String TYPE = "PIG";

    public Pig (String name, double age, boolean isVaccinated){
        super(name, age, isVaccinated);
    }

    public final String getTYPE(){
        return TYPE;
    }
    public void sound(){
        System.out.println("oink oink oink");
    }
}

