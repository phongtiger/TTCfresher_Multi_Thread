package TTCFresher;

import java.util.concurrent.TimeUnit;

public class Tccfresher {
    public static void main(String[] args) throws InterruptedException {
        int n = 10;
        int sizeRoad = 100;
        Road road = new ConcreteBuilder()
                .setNumberOfAnimal(n)
                .setSizeRoad(sizeRoad)
                .setNumberOfThread(3)
                .setSecondInitialDelay(1)
                .setSecondDelay(1)
                .setAwaitTermination(41)
                .setTimeUnit(TimeUnit.SECONDS)
                .build();
       // Khong gioi han luong
//        road.playRoadUnLimit();
        //Co gioi han luong
        road.playRoadNew();
    }
}
