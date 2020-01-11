package TTCFresher;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Dog extends AbstractAnimal implements Animal, Runnable {
    private String name = "DOG";
    private Long id;
    private double step;
    private int timeStep;
    private int sizeRoad;

    public Dog(Long id, int sizeRoad) {
        this.id = id;
        this.step = ThreadLocalRandom.current().nextDouble(60, 70);
        this.timeStep = ThreadLocalRandom.current().nextInt(500, 700);
        this.sizeRoad = sizeRoad;
    }

    public Dog() {
    }

    public Dog(long i) {
        this.id = id;
        this.step = ThreadLocalRandom.current().nextDouble(60, 70);
        this.timeStep = ThreadLocalRandom.current().nextInt(500, 700);
    }

    public int getSizeRoad() {
        return sizeRoad;
    }

    public void setSizeRoad(int sizeRoad) {
        this.sizeRoad = sizeRoad;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public double getTimeStep() {
        return timeStep;
    }

    public void setTimeStep(int timeStep) {
        this.timeStep = timeStep;
    }

    public synchronized void runDog() {
        System.out.println(name + " id: " + id + " start");
        int count = 0;
        while (count <= sizeRoad) {
            count += step;
            this.processCommand(timeStep);
        }
        System.out.println(name + " id: " + id + " done");
    }

    private void processCommand(int timeStep) {
        try {
            Thread.sleep(timeStep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String endRoad() {
        return super.showTime(this.name);
    }

    @Override
    public void run() {
        runDog();
    }

}
