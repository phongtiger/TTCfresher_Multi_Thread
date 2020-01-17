package TTCFresher;

import java.util.concurrent.ExecutorService;

public interface Animal {
    String getKindOfAnimal();

    String endRoad();

    void setAnimalNext(Runnable next);

    void setExecutorService(ExecutorService executor);

}
