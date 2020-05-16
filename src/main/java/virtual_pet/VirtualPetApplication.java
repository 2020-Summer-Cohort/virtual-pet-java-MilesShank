package virtual_pet;

import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name = initialInstructions(input);

        VirtualPet myTest = new VirtualPet( name);
        myTest.birth();
        while(true) {
            String userCommand = input.nextLine();
            if (userCommand.equals("FEED")) {
                myTest.updateHunger();
                if (!myTest.hunger){
                    System.out.println(name + " seems pretty full!");
                }
            } else if (userCommand.equals("PLAY")) {
                myTest.updateBoredom();
                if (!myTest.boredom){
                    System.out.println(name + " is having a lot of fun!");
                }
            } else if (userCommand.equals("PET")) {
                myTest.updateLoneliness();
                if (!myTest.lonely){
                    System.out.println(name + " feels adored");
                }
            } else {
                System.out.println("You did not enter the valid inputs FEED PLAY or PET");
                System.out.println("But, its good that you are trying for " + name);
                myTest.updateLoneliness();
            }
        }
        }

        //Interact with a VirtualPet object in this method
    public static String initialInstructions(Scanner input){
        System.out.println("It's so kind of you to open your heart and adopt!");
        System.out.println("Please enter a name for your new animal friend");
        String petName=input.nextLine();
        System.out.println(petName+" Huh? Well that's kind of an odd name, but that's ok.");
        System.out.println("You can type PLAY to entertain your pet");
        System.out.println("You can type FEED to feed your pet");
        System.out.println("You can type PET to give your pet affection");
        System.out.println("Press ENTER to begin");
        String userAgreement = input.nextLine();
            return petName;


    }

}
