package virtual_pet;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class gameLoop {
    public ArrayList<IgameLoopable> updateList;

    void tick() {
        for (IgameLoopable item : updateList) {
            item.update();
        }
    }
    public void startGameLoop() {
        Runnable tickSchedule = new Runnable() {
            @Override
            public void run() {

                tick();
            }
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(tickSchedule, 5, 5, TimeUnit.SECONDS);
    }

    public void initialize() {
        updateList = new ArrayList<IgameLoopable>();
    }
}
