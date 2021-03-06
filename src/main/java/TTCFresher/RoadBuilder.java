package TTCFresher;

import java.util.concurrent.TimeUnit;

public interface RoadBuilder {
    RoadBuilder setNumberOfAnimal( int numberOfAnimal);
    RoadBuilder setSizeRoad(int sizeRoad);
    RoadBuilder setNumberOfThread( int numberOfThread);
    RoadBuilder setAwaitTermination(int awaitTermination);
    RoadBuilder setTimeUnit(TimeUnit timeUnit);
    Road build();
}
