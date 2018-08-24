package view;

public class UserView {

    public static void welcomeMessage () {
        System.out.println('\n' + "Welcome Farmer!");
        System.out.println("I was created to help you manage your farm. What can I do for you?" + '\n');
    }

    public static void showMenu (){
        System.out.println("1 - Show me my barns");
        System.out.println("2 - Build a new barn");
        System.out.println("3 - EXIT");
    }
    public static void askForTheNameOfNewBarn(){
        System.out.println("Write a name of this barn");
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
}