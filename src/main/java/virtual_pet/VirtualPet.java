package virtual_pet;


public class VirtualPet implements IgameLoopable{
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

    public void update() {
        System.out.println(" . ");
        System.out.println(" . ");
        System.out.println("Time flies when you're responsible for another living creature!");
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

    public void calculateHunger(){
        if(hungerLevel <=4){
            System.out.println(name + " is feelin hungry m(0.0)m ");
            hunger = true;
        }else{
            hunger = false;
        }
    }

    public void calculateLoneliness(){
        if(lonelyLevel <=4){
            System.out.println(name + " is feelin lonely m(v.v)m");
            lonely = true;
        }else{
            lonely = false;
        }
    }

    public void calculateBoredom() {
        if(boredomLevel <=4){
            System.out.println(name + " is feelin  bored m(-.-)m");
            boredom = true;
        }else{
            boredom = false;
        }
    }
    public String getName(){
      return name;
    };

}