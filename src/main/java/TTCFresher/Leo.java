package TTCFresher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadLocalRandom;

public class Leo extends AbstractAnimal implements Animal, Runnable {
    private String name = "LEO";
    private Long id;
    private double step;
    private int timeStep;
    private int sizeRoad;
    private Runnable next;
    private ExecutorService executor;

    public Leo(Long id) {
        this.id = id;
        this.step = ThreadLocalRandom.current().nextDouble(30, 50);
        this.timeStep = ThreadLocalRandom.current().nextInt(900, 1000);

    }

    public Leo(Long id, int sizeRoad) {
        this.id = id;
        this.step = ThreadLocalRandom.current().nextDouble(100, 150);
        this.timeStep = ThreadLocalRandom.current().nextInt(800, 1000);
        this.sizeRoad = sizeRoad;
    }

    public Leo() {
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

    public Runnable getNext() {
        return next;
    }


    @Override
    public void setAnimalNext(Runnable next) {
        this.next = next;
    }

    @Override
    public void setExecutorService(ExecutorService executor) {
        this.executor = executor;
    }

    @Override
    public String getKindOfAnimal() {
        return this.name;
    }

    @Override
    public String endRoad() {
        return super.showTime(this.name);
    }

    @Override
    public void run() {
        super.runAnimal(id, name, sizeRoad, step, timeStep, next, executor);
    }
}
