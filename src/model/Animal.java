package model;

public abstract class Animal {
    private String name;
    private double age;
    private boolean isVaccinated;

    public Animal(String name, double age, boolean isVaccinated) {
        this.name = name;
        this.age = age;
        this.isVaccinated = isVaccinated;
    }
    public Animal (){
    };

    public final String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public abstract String getTYPE();

    @Override
    public String toString() {
        return '{' + getTYPE() +
                ", name= " + name +
                ", age= " + age +
                ", isVaccinated= " + isVaccinated +
                '}';
    }
}
