package TTCFresher;

import java.util.concurrent.ExecutorService;

public interface Animal {
    String getKindOfAnimal();

    String endRoad();

    void setAnimalNext(Runnable nextRunnable);

    void setExecutorService(ExecutorService executor);

}
