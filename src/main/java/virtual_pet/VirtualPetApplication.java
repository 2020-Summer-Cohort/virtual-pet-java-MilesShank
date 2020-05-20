package virtual_pet;

import java.util.Scanner;
/*
 * I love the application, but I would like to see some simplifying of the VirtualPet class.  It's a little crowded with
 * some game engine stuff, when all that class should have is the behaviors of a pet.
 *
 * There is a principle we usually talk about later in the cohort called the 'Single Responsibility Principle'
 * - https://en.wikipedia.org/wiki/Single-responsibility_principle
 * I feel like the VirtualPet class right now is hiding a couple responsibilities, the first is the behaviors and
 * properties of a pet, and the second the timed execution of the tick.  Separating them would be be beneficial in the
 * long run.
 *
 * Again, really like the app, but we are going to be building on it for another week and it might be easier with a
 * simplified VirtualPet and a turn-based approach rather than a time based.  But if you want to keep the time based
 * approach, schedule a time with me to help extract the timer based methods to their own class.
 */
public class VirtualPetApplication {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name = initialInstructions(input);

        VirtualPet myTest = new VirtualPet(name);
        gameLoop.birth(myTest);
        while (true) {
            String userCommand = input.nextLine();
            if (userCommand.equalsIgnoreCase("FEED")) {
                updateHunger(myTest);
                if (!myTest.hunger) {
                    System.out.println(name + " seems pretty full!");
                }
            } else if (userCommand.equalsIgnoreCase("PLAY")) {
                updateBoredom(myTest);
                if (!myTest.boredom) {
                    System.out.println(name + " is having a lot of fun!");
                }
            } else if (userCommand.equalsIgnoreCase("PET")) {
                System.out.println("you pet " + name + " vigorously, ");
                updateLoneliness(myTest);
                if (!myTest.lonely) {
                    System.out.println(name + " feels adored");
                }
            } else {
                System.out.println("You did not enter the valid inputs FEED PLAY or PET");
                System.out.println("But, " + name + " notices that you care");
                updateLoneliness(myTest);
            }
        }
    }
    static void tick(VirtualPet myTest) {
        System.out.println(" . ");
        System.out.println(" . ");
        System.out.println("Time flies when you're responsible for another living creature!");
        myTest.updateLoop();
    }
    public static String initialInstructions(Scanner input) {
        System.out.println("It's so kind of you to open your heart and adopt!");
        System.out.println("Please enter a name for your new animal friend");
        String petName = input.nextLine();
        System.out.println(petName + " Huh? Well that's kind of an odd name, but that's ok.");
        System.out.println("You can type PLAY to entertain your pet");
        System.out.println("You can type FEED to feed your pet");
        System.out.println("You can type PET to give your pet affection");
        System.out.println("Make sure you type your commands out and enter them on the same line!");
        System.out.println("Otherwise you might confuse your new pet");
        System.out.println("Press ENTER to begin");
        String userAgreement = input.nextLine();
        System.out.println("this is " + petName + " m(o.o)m");
        System.out.println("your new pet!");
        return petName;


    }    public static void updateHunger(VirtualPet myTest){
        myTest.hungerLevel++;
        System.out.println("you fed "+ myTest.getName() + " a nutritous tasty snack m(^.^)m");
        myTest.calculateMood();

    }

    public static void updateBoredom(VirtualPet myTest){
        myTest.boredomLevel++;
        System.out.println("you and "+ myTest.getName() + " played around for a while m(>.<)m");
        myTest.calculateMood();
    }

    public static void updateLoneliness(VirtualPet myTest){
        myTest.lonelyLevel++;
        System.out.println("you remind " + myTest.getName() + " that they are very important m(v//v)m");
        myTest.calculateMood();
    }
}
