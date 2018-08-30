package model;

public  class Animal {
    private String name;
    private double age;
    private boolean isVaccinated;
    private String TYPE;

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

    public String getTYPE() {
        return TYPE;
    }

    @Override
    public String toString() {
        return  '{' + getTYPE() +
                ", name= " + name +
                ", age= " + age +
                ", isVaccinated= " + isVaccinated +
                '}';
    }
}
