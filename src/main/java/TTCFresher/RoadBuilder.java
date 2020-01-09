package TTCFresher;

import java.util.List;

public interface RoadBuilder {
    RoadBuilder setAllListAnimal(List<List<Animal>> listListAnimal);
    RoadBuilder setNumberOfAnimal( int numberOfAnimal);
    RoadBuilder setSizeRoad(int sizeRoad);
    RoadBuilder setNumberOfThread( int numberOfThread);
    RoadBuilder setSecondInitialDelay(int initialDelay);
    RoadBuilder setSecondDelay(int secondDelay);
    Road build();

}
