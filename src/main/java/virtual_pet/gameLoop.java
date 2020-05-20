package virtual_pet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class gameLoop {
    static void birth(VirtualPet myTest) {
        Runnable tickSchedule = new Runnable() {
            @Override
            public void run() {

                VirtualPetApplication.tick(myTest);
            }
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(tickSchedule, 0, 5, TimeUnit.SECONDS);
    }
}
