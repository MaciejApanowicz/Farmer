package model;

public class Horse extends Animal{
    private final String TYPE = "HORSE";

    public Horse (String name, double age, boolean isVaccinated){
        super(name, age, isVaccinated);
    }

    public final String getTYPE(){
        return TYPE;
    }
    public void sound(){
        System.out.println("neigh neigh neigh");
    }
}
