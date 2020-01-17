package TTCFresher;

import java.util.concurrent.TimeUnit;

public class Tccfresher {
    public static void main(String[] args) throws InterruptedException {
        int numberOfAnimal = 10;
        int sizeRoad = 100;
        Road road = new ConcreteBuilder()
                .setNumberOfAnimal(numberOfAnimal)
                .setSizeRoad(sizeRoad)
                .setNumberOfThread(3)
                .setAwaitTermination(41)
                .setTimeUnit(TimeUnit.SECONDS)
                .build();
       // Khong gioi han luong
//        road.playRoadUnLimit();
        //Co gioi han luong
        road.playRoadNew();
    }
}
