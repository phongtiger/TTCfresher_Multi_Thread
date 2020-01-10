package TTCFresher;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ConcreteBuilder implements RoadBuilder {
    private List<List<Animal>> animals1;
    private int numberAnimal;
    private int size;
    private int numberOfThread;
    private int initialDelay;
    private int delay;
    private int awaitTermination;
    private TimeUnit timeUnit;

    @Override
    public RoadBuilder setNumberOfAnimal(int numberOfAnimal) {
        this.numberAnimal = numberOfAnimal;
        return this;
    }

    @Override
    public RoadBuilder setSizeRoad(int sizeRoad) {
        this.size = sizeRoad;
        return this;
    }

    @Override
    public RoadBuilder setNumberOfThread(int numberOfThread) {
        this.numberOfThread = numberOfThread;
        return this;
    }

    @Override
    public RoadBuilder setSecondInitialDelay(int initialDelay) {
        this.initialDelay = initialDelay;
        return this;
    }

    @Override
    public RoadBuilder setSecondDelay(int secondDelay) {
        this.delay = secondDelay;
        return this;
    }

    @Override
    public RoadBuilder setAwaitTermination(int awaitTermination) {
        this.awaitTermination = awaitTermination;
        return this;
    }

    @Override
    public RoadBuilder setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
        return this;
    }

    @Override
    public Road build() {
        return new Road(animals1, numberAnimal, size, numberOfThread, initialDelay, delay, awaitTermination, timeUnit);
    }
}
