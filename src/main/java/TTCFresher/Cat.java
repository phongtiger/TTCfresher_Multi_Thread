package TTCFresher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;

public class Cat extends AbstractAnimal implements Animal, Runnable {
    private String name = "CAT";
    private Long id;
    private double step;
    private int timeStep;
    private int sizeRoad;
    private Runnable next;
    private ExecutorService executor;


    public Cat(Long id, int sizeRoad) {
        this.id = id;
        this.step = ThreadLocalRandom.current().nextDouble(30, 50);
        this.timeStep = ThreadLocalRandom.current().nextInt(900, 1000);
        this.sizeRoad = sizeRoad;
    }

    public Cat() {
    }

    public Runnable getNext() {
        return next;
    }

    @Override
    public void setNext(Runnable next) {
        this.next = next;
    }

    @Override
    public void setThreadPoolExecutor(ExecutorService executor) {
        this.executor = executor;
    }

    public void setExecutor(ThreadPoolExecutor executor) {
        this.executor = executor;
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

    public int getSizeRoad() {
        return sizeRoad;
    }

    public void setSizeRoad(int sizeRoad) {
        this.sizeRoad = sizeRoad;
    }

    @Override
    public String getInfo() {
        return this.name;
    }

    @Override
    public String endRoad() {
        return super.showTime(this.name);
    }

    @Override
    public void run() {
        super.catRun(id, name, sizeRoad, step, timeStep, next, executor);
    }
}
