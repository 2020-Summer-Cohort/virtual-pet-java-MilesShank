package virtual_pet;

import java.sql.Time;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VirtualPet {
    public String name;
    public int affection;
    public int hunger;
    public int boredom;
    public String currentMood;
    public long startTime;
    public int mood;
    public VirtualPet(String name) {
        this.name = name;
        this.currentMood = moods[3];
        this.affection = 5;
        this.hunger = 5;
        this.boredom = 5;
        this.startTime = 0;
    }

    void birth() {
        Runnable tickSchedule = new Runnable() {
            @Override
            public void run() {
                tick();
            }
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(tickSchedule, 0, 7, TimeUnit.SECONDS);
    }

    void tick() {
        updateLoop();
    }

    String[] moods = {"hungry", "bored", "unwanted", "happy",
            "loving", "dead"};
    int[] needs = {hunger, boredom, affection};
    String[] moodDisplays = {"your pet is dreaming of food", "your pet wishes you'd play with them", " wonders whether or not they deserve to be loved"};

    int calculateMood() {

        if (hunger == 0 || affection == 0 || boredom == 0) {
            mood = 5;
            System.out.println("oh no, it looks like " + name + "is dying");
            System.out.println("Farewell, small creature");
            System.out.println("Farewell, negligent owner");
            System.exit(0);

        }

        for (int i = 0; i < needs.length; i++) {
            if (needs[i] < 4) {
                System.out.println(moodDisplays[i]);
                currentMood = moods[i];
            }
        }

        if (hunger > 5 && boredom > 5 && affection > 3) {
            mood = 3;
            System.out.println(name + " is contented and healthy");
        }
        if (affection > 6) {
            mood = 4;
            System.out.println(name + " loves you so very much");
        }

        return mood;
    }

    void updateDisplay() {
        System.out.println(name + " is feeling " + currentMood + " currently");
    }

    public void updateHunger(){
        hunger++;
        System.out.println("you fed "+ name + " a tasty snack");
        updateDisplay();
    }
    public void updateBoredom(){
      boredom++;
      System.out.println("you and "+ name + " played with a ball for a while");
      updateDisplay();
    }
    public void updateAffection(){
        affection++;
        System.out.println("you pet " + name + " vigorously, and remind them that they are good and important");
        updateDisplay();
    }

    public void updateLoop() {
        moodDecay();
        currentMood = moods[calculateMood()];
        updateDisplay();
    }

    int moodMode = 0;

    private void moodDecay() {
        if (moodMode == 0) {
            hunger--;
        } else if (moodMode == 1) {
            boredom--;
        } else if(moodMode >=2) {
            affection--;
            moodMode = 0;
        }

    }

    public String getName() {
        return name;
    }
}