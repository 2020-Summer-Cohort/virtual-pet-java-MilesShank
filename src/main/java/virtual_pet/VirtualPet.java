package virtual_pet;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VirtualPet {
    public String name;
    public int lonelyLevel;
    public int hungerLevel;
    public int boredomLevel;
    public boolean hunger;
    public boolean boredom;
    public boolean lonely;
    public VirtualPet(String name) {
        this.name = name;
        this.lonelyLevel = 5;
        this.hungerLevel = 5;
        this.boredomLevel = 5;
    }

    void birth() {
        Runnable tickSchedule = new Runnable() {
            @Override
            public void run() {
                tick();
            }
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(tickSchedule, 0, 9, TimeUnit.SECONDS);
    }

    void tick() {
        updateLoop();
    }

    public void updateLoop() {
        moodDecay();
        updateDisplay();
    }

    int whichMoodDecays = 0;
    private void moodDecay() {

        if (whichMoodDecays == 0) {
            hungerLevel--;
            whichMoodDecays++;
        } else if (whichMoodDecays == 1) {
            boredomLevel--;
            whichMoodDecays++;
        } else if(whichMoodDecays >=2) {
            lonelyLevel--;
            whichMoodDecays = 0;
        }
    }

    void updateDisplay() {
        calculateMood();
    }

    void calculateMood() {
        if (hungerLevel == 0 || lonelyLevel == 0 || boredomLevel == 0) {
             death();
        }
        calculateHunger();
        calculateLoneliness();
        calculateBoredom();

        if((!hunger && !boredom && !lonely)){
            System.out.println("feelin happy!");
        }
    }

    private void death() {
        System.out.println("oh no, it looks like " + name + " is dying");
        System.out.println("Farewell, small creature");
        System.out.println("Farewell, negligent owner");
        System.exit(0);
    }
    private void calculateHunger(){
        if(hungerLevel <=4){
            System.out.println("feelin hungry");
            hunger = true;
        }else{
            hunger = false;
        }
    }
    private void calculateLoneliness(){
        if(lonelyLevel <=4){
            System.out.println("feelin lonely");
            lonely = true;
        }else{
            lonely = false;
        }
    }
    private void calculateBoredom() {
        if(boredomLevel <=4){
            System.out.println("feelin bored");
            boredom = true;
        }else{
            boredom = false;
        }
    }

    public void updateHunger(){
        System.out.println(hungerLevel);
        hungerLevel++;
        System.out.println("you fed "+ name + " a tasty snack");
        System.out.println(hungerLevel);
        calculateMood();

    }
    public void updateBoredom(){
        System.out.println(boredomLevel);
      boredomLevel++;
      System.out.println(boredomLevel);
      System.out.println("you and "+ name + " played around for a while");
        calculateMood();
    }
    public void updateLoneliness(){
        System.out.println(lonelyLevel);
        lonelyLevel++;
        System.out.println(lonelyLevel);
        System.out.println("you pet " + name + " vigorously, and remind them that they are good and important");
        calculateMood();
    }
}