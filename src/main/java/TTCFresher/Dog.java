package TTCFresher;

import java.util.concurrent.*;

public class Dog extends AbstractAnimal implements Animal, Runnable {
    private String name = "DOG";
    private Long id;
    private double step;
    private int timeStep;
    private int sizeRoad;
    private Runnable next;
    private ExecutorService executor;

    public Dog(Long id, int sizeRoad) {
        this.id = id;
        this.step = ThreadLocalRandom.current().nextDouble(60, 70);
        this.timeStep = ThreadLocalRandom.current().nextInt(500, 700);
        this.sizeRoad = sizeRoad;
    }

    public Dog() {
    }

    @Override
    public void setAnimalNext(Runnable next) {
        this.next = next;
    }

    @Override
    public void setExecutorService(ExecutorService executor) {
        this.executor = executor;
    }


    public int getSizeRoad() {
        return sizeRoad;
    }

    public void setSizeRoad(int sizeRoad) {
        this.sizeRoad = sizeRoad;
    }

    public Runnable getNext() {
        return next;
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
