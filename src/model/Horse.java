package model;

public class Horse extends Animal{

    public Horse (String name, double age, boolean isVaccinated){
        super(name, age, isVaccinated);
    }

    public Horse(){
    };

    public final String getTYPE(){
        return  "HORSE";
    }

    public void sound(){
        System.out.println("neigh neigh neigh");
    }
}
