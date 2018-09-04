package model;

public class Pig extends Animal{

    public Pig (String name, double age, boolean isVaccinated){
        super(name, age, isVaccinated);
    }

    public Pig (){
        super();
    }

    public final String getTYPE(){
        return "PIG";
    }

    public void sound(){
        System.out.println("oink oink oink");
    }
}

