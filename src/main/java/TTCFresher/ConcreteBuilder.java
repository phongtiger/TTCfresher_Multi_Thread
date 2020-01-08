package TTCFresher;

import java.util.List;

public class ConcreteBuilder implements RoadBuilder {
    private List<List<Animal>> animals1;
    private int numberAnimal;
    private int size;


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
    public Road build() {
        return new Road(animals1,numberAnimal,size);
    }
}
