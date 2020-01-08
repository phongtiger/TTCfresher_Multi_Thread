package TTCFresher;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
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

//    private static List<Cat> getCats(int n,int road){
//        List<Cat> catList = new ArrayList<>();
//        for(int i = 0; i< n; i++){
//            catList.add(new Cat((long) i,road));
//        }
//        return catList;
//    }
//    private static List<Dog> getDogs(int n,int road){
//        List<Dog> dogList = new ArrayList<>();
//        for(int i = 0; i< n; i++){
//            dogList.add(new Dog((long) i,road));
//        }
//        return dogList;
//    }
//    private static List<Leo> getLeos(int n,int road){
//        List<Leo> leoList = new ArrayList<>();
//        for(int i = 0; i< n; i++){
//            leoList.add(new Leo((long) i,road));
//        }
//        return leoList;
//    }

    public static void main(String[] args) throws InterruptedException {
        int n = 10;
        int sizeRoad = 1000;
        List<List<Animal>> lists = getListListAnimal(n,sizeRoad);
        Road road = new ConcreteBuilder()
                .setAllListAnimal(lists)
                .setNumberOfAnimal(10)
                .setSizeRoad(10000)
                .build();
        road.playRoad();
//        HashMap<String,LocalDateTime> localDateTimeHashMap = new HashMap<>();
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (Cat a: getCats(10,1000)) {
//                    try {
//                        a.runRoad();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                System.out.println(" Thread Cat");
//                localDateTimeHashMap.put("Cat",LocalDateTime.now());
//            }
//        });
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (Dog a: getDogs(10,1000)) {
//                    try {
//                        a.runRoad();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                System.out.println(" Thread Dog");
//                localDateTimeHashMap.put("Dog",LocalDateTime.now());
//            }
//        });
//        Thread thread3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (Leo a: getLeos(10,1000)) {
//                    try {
//                        a.runRoad();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                System.out.println("Thread Leo");
//                localDateTimeHashMap.put("Leo",LocalDateTime.now());
//            }
//        });
//        thread.start();
//        thread2.start();
//        thread3.start();
//        Thread.sleep(37000);
//        System.out.println(localDateTimeHashMap);
    }
}
