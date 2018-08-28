package model;

public class Sheep extends Animal{
    private final String TYPE = "SHEEP";

    public Sheep (String name, double age, boolean isVaccinated){
        super(name, age, isVaccinated);
    }

    public final String getTYPE(){
        return TYPE;
    }
    public void sound(){
        System.out.println("baa baa baa");
    }
}
