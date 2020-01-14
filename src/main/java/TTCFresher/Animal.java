package TTCFresher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public interface Animal {
    String getInfo();

    String endRoad();

    void setNext(Runnable next);

    void setThreadPoolExecutor(ExecutorService executor);

}
