package view;

public class UserView {

    public static void welcomeMessage () {
        System.out.println('\n' + "Welcome Farmer!");
        System.out.println("I was created to help you manage your farm. What can I do for you?" + '\n');
    }

    public static void showMenu (){
        System.out.println("1 - Show me my barns");
        System.out.println("2 - Build new barn");
        System.out.println("3 - Add new animal");
        System.out.println("4 - EXIT");
    }
    public static void askForTheNameOfNewBarn(){
        System.out.println("Write a name of this new barn");
    }
    public static void askHowManyAnimalsWillBeInThisBarn(){
        System.out.println("How big is this barn. How many animals can live here?");
    }
    public static void askForTheNextTask(){
        System.out.println('\n' + "What can I do for you next?");
    }
    public static String confirmationThatBarnHasBeenBuilt(){
        return "This barn has been built: ";
    }
    public static void showFarmerBarns(){
        System.out.println("Your Barns:");
    }
    public static void messageNoBarnsYet(){
        System.out.println("You do not have any barns yet. Please add some.");
    }
    public static void messageExit () {
        System.out.println("You have exited the program.");
    }
    public static void messageAfter3rdOption(){
        System.out.println("You have decided to add new animal. What is the type of new animal? ");
    }
    public static void showAvailiabeAnimalType(){
        System.out.println("1 - Pig");
        System.out.println("2 - Cow");
        System.out.println("3 - Return");
    }
}
