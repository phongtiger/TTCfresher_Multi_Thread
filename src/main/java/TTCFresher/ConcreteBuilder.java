package TTCFresher;

import java.util.List;

public class ConcreteBuilder implements RoadBuilder {
    private List<List<Animal>> animals1;
    private int numberAnimal;
    private int size;
    private int numberOfThread;
    private int initialDelay;
    private int delay;

    @Override
    public RoadBuilder setAllListAnimal(List<List<Animal>> listListAnimal) {
        this.animals1 = listListAnimal;
        return this;
    }

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
    public Road build() {
        return new Road(animals1,numberAnimal,size,numberOfThread,initialDelay,delay);
    }
}
