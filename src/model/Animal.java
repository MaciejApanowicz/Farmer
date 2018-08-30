package model;

public  class Animal {
    private String name;
    private double age;
    private boolean isVaccinated;

    public Animal(String name, double age, boolean isVaccinated){
        this.name = name;
        this.age = age;
        this.isVaccinated = isVaccinated;
    }

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
        return // '{' + getTYPE() +   ..zrób to
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isVaccinated=" + isVaccinated +
                '}';
    }
}
