package virtual_pet;

import java.util.Scanner;

public class VirtualPetApplication {

    static public gameLoop looper;

    public static void main(String[] args) {
        looper = new gameLoop();
        looper.initialize();
        Scanner input = new Scanner(System.in);
        String name = initialInstructions(input);
        VirtualPet newPet = new VirtualPet(name);
        looper.updateList.add(newPet);
        looper.startGameLoop();
        while (true) {
            String userCommand = input.nextLine();
            if (userCommand.equalsIgnoreCase("FEED")) {
                updateHunger(newPet);
                if (!newPet.hunger) {
                    System.out.println(name + " seems pretty full!");
                }
            } else if (userCommand.equalsIgnoreCase("PLAY")) {
                updateBoredom(newPet);
                if (!newPet.boredom) {
                    System.out.println(name + " is having a lot of fun!");
                }
            } else if (userCommand.equalsIgnoreCase("PET")) {
                System.out.println("you pet " + name + " vigorously, ");
                updateLoneliness(newPet);
                if (!newPet.lonely) {
                    System.out.println(name + " feels adored");
                }
            } else {
                System.out.println("You did not enter the valid inputs FEED PLAY or PET");
                System.out.println("But, " + name + " notices that you care");
                updateLoneliness(newPet);
            }
        }
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
