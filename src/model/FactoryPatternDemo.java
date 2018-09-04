package model;

public class FactoryPatternDemo {

    public static void main(String[] args) {
       AnimalsFactory animalsFactory = new AnimalsFactory();

        //get an object of Circle and call its draw method.
        Animal pig = AnimalsFactory.getAnimal("Pig");

        //call draw method of Circle


        //get an object of Rectangle and call its draw method.
//        Animal Cow = AnimalsFactory.getAnimal("COW","name",0,false);

        //call draw method of Rectangle
        //shape2.draw();

        //get an object of Square and call its draw method.
//        Animal Sheep = AnimalsFactory.getAnimal("SHEEP","name",0,false);

        //call draw method of square
        //shape3.draw();
    }
}