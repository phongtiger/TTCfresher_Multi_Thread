package TTCFresher;

import java.util.List;

public interface RoadBuilder {
    RoadBuilder setAllListAnimal(List<List<Animal>> listListAnimal);
    RoadBuilder setNumberOfAnimal( int numberOfAnimal);
    RoadBuilder setSizeRoad(int sizeRoad);
    Road build();
}
