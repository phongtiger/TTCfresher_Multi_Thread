package TTCFresher;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;

public abstract class AbstractAnimal {
    protected String showTime(String name) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSSS");
        String dateString = simpleDateFormat.format(date);
        return " " + name + " " + dateString + " ";
    }

    protected void catRun(Long id, String name, int sizeRoad, double step, int timeStep, Runnable next, ExecutorService executor) {
        System.out.println(name + " id: " + id + " start");
        int count = 0;
        while (count <= sizeRoad) {
            count += step;
            this.processCommand(timeStep);
        }
        try {
            System.out.println(name + " id: " + id + " done");
            executor.execute(next);
        } catch (Exception e) {
            System.out.println("End");
        }

    }

    private void processCommand(int timeStep) {
        try {
            Thread.sleep(timeStep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
