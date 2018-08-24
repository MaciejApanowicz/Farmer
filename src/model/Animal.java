package model;

public class Animal {
    private String type;
    private int age;
    private boolean isVaccinated;

    public Animal (String type, int age, boolean isVaccinated){
        this.type = type;
        this.age = age;
        this.isVaccinated = isVaccinated;
    }
    public Animal (){
    }

    public String getType(){
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public boolean getIsVaccinated() {
        return isVaccinated;
    }
    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    @Override
    public String toString() {
        return "model.Animal{" +
                "type='" + type + '\'' +
                ", age=" + age +
                ", isVaccinated=" + isVaccinated +
                '}';
    }
}
