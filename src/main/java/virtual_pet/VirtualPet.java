package virtual_pet;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/*
 * There's alot to like here, but I want to encourage you to rethink the tick method and remove the timer based tick and
 * replace it with a 'turn based' tick.  Think of the tick as way to advance a game state after teh user takes a turn.
 * Consider the application a turn-based app instead of a realtime application.  I know a good deal of research was
 * probably done to figure out the every Executor, but its a little much at this point and will be a bear to work with
 * as we expand on this project later in the week.
 *
 * Also we would like to see the VirtualPet class a little simpler, it has a bunch of references to how the game works
 * and displays data beside the behavior of a pet.  We want the VirtualPet class to be only about the things you pet
 * would know about.
 */
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
        executor.scheduleAtFixedRate(tickSchedule, 0, 5, TimeUnit.SECONDS);
    }

    void tick() {
        System.out.println(" . ");
        System.out.println(" . ");
        System.out.println("Time flies when you're responsible for another living creature!");
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
            System.out.println(name + " is feelin happy! m(^o^)m");
        }
    }
    private void death() {
        System.out.println("oh no, it looks like " + name + " is dying");
        System.out.println("Farewell, small creature m(x.x)m");
        System.out.println("Farewell, negligent owner");
        System.exit(0);
    }

    private void calculateHunger(){
        if(hungerLevel <=4){
            System.out.println(name + " is feelin hungry m(0.0)m ");
            hunger = true;
        }else{
            hunger = false;
        }
    }

    private void calculateLoneliness(){
        if(lonelyLevel <=4){
            System.out.println(name + " is feelin lonely m(v.v)m");
            lonely = true;
        }else{
            lonely = false;
        }
    }

    private void calculateBoredom() {
        if(boredomLevel <=4){
            System.out.println(name + " is feelin  bored m(-.-)m");
            boredom = true;
        }else{
            boredom = false;
        }
    }

    public void updateHunger(){
        hungerLevel++;
        System.out.println("you fed "+ name + " a nutritous tasty snack m(^.^)m");
        calculateMood();

    }

    public void updateBoredom(){
      boredomLevel++;
      System.out.println("you and "+ name + " played around for a while m(>.<)m");
        calculateMood();
    }

    public void updateLoneliness(){
        lonelyLevel++;
        System.out.println("you remind " + name + " that they are very important m(v//v)m");
        calculateMood();
    }
}