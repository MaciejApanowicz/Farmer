package model;

public class AnimalsFactory {
    private static AnimalsFactory INSTANCE = new AnimalsFactory();

    AnimalsFactory(){}

    public static AnimalsFactory getINSTANCE(){
        return INSTANCE;
    }

    public static Animal getAnimal(String animalType) {
        if (animalType == null) {
            return null;
        }
        if (animalType.equals("PIG"))
            return new Pig(name, age, isVaccinated);
        if (animalType.equals("COW"))
            return new Cow();
        if (animalType.equals("SHEEP"))
            return new Sheep();
        if (animalType.equals("HORSE")) {
            return new Horse();
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
