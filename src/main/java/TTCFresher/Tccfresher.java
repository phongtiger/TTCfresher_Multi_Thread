package TTCFresher;

import java.util.ArrayList;
import java.util.List;

public class Tccfresher {

    private static List<List<Animal>> getListListAnimal(int n,int sizeRoad){
        List<List<Animal>> lists = new ArrayList<>();
        for(AnimalType a: AnimalType.values()){
            List<Animal> catList = new ArrayList<>();
            for(int i = 0; i< n; i++){
                catList.add(new AnimalFactory().getAnimal(a,i,sizeRoad));
            }
            lists.add(catList);
        }
        return lists;
    }

    public static void main(String[] args) throws InterruptedException {
        int n = 10;
        int sizeRoad = 1000;
        List<List<Animal>> lists = getListListAnimal(n,sizeRoad);
        Road road = new ConcreteBuilder()
                .setAllListAnimal(lists)
                .setNumberOfAnimal(10)
                .setSizeRoad(10000)
                .build();
//Khong gioi han luong
//        road.playRoad();
        //Co gioi han luong
        road.playRoadNew();

    }
}
