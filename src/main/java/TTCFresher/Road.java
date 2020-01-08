package TTCFresher;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Road {
    private List<List<Animal>> lists1;
    private int numberAnimalOnce;
    private int sizeRoad;

    public Road() {
    }

    public Road(List<List<Animal>> lists1, int numberAnimalOnce, int sizeRoad) {
        this.lists1 = lists1;
        this.numberAnimalOnce = numberAnimalOnce;
        this.sizeRoad = sizeRoad;
    }

    public List<List<Animal>> getLists1() {
        return lists1;
    }

    public void setLists1(List<List<Animal>> lists1) {
        this.lists1 = lists1;
    }

    public int getNumberAnimalOnce() {
        return numberAnimalOnce;
    }

    public void setNumberAnimalOnce(int numberAnimalOnce) {
        this.numberAnimalOnce = numberAnimalOnce;
    }

    public int getSizeRoad() {
        return sizeRoad;
    }

    public void setSizeRoad(int sizeRoad) {
        this.sizeRoad = sizeRoad;
    }

    public List<Runnable> getRunList(){
        List<Runnable> runnableList = new ArrayList<>();
        for (List<Animal> l: lists1
             ) {
            Runnable runnable = new Thread((() -> {
                ExecutorService executor1 = Executors.newSingleThreadExecutor();
                for (Animal a: l) {
                    Runnable runnable1 = (Runnable) a;
                    executor1.execute(runnable1);;
                }
                executor1.shutdown();
                while (!executor1.isTerminated()) {

                }
                System.out.println(" Thread: "+Thread.currentThread().getName() + l.get(0).runRoad() + " Done");

            }));
            runnableList.add(runnable);
        }
        return runnableList;
    }

    public void playRoadUnLimit(){
        ExecutorService executor = Executors.newCachedThreadPool();;

        List<Runnable> listRun = getRunList();

        for (Runnable r: listRun
        ) {
            executor.execute(r);
        }
        executor.shutdown();

    }
    public void playRoadNew() throws InterruptedException {
        final int NUM_OF_THREAD = 2;
        final int INITIAL_DELAY = 1; // second
        final int DELAY = 3; // second
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(NUM_OF_THREAD);

        List<Runnable> listRun = getRunList();

        for (Runnable r: listRun
             ) {
            executor.scheduleWithFixedDelay(r, INITIAL_DELAY, DELAY, TimeUnit.SECONDS);;
        }
        executor.awaitTermination(3, TimeUnit.SECONDS);
        executor.shutdown();

    }
    //    public void playRoad() throws InterruptedException {
//        HashMap<String,Long> localDateTimeHashMap = new HashMap<>();
//        Thread thread1;
//        Thread thread2;
//        Thread thread3;
//
//        thread1= new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Date start1 = new Date();
//                ExecutorService executor = Executors.newSingleThreadExecutor();
//                for (Animal a: lists1.get(0)) {
//                    Runnable runnable = (Runnable) a;
//                    executor.execute(runnable);;
//                }
//                executor.shutdown();
//                while (!executor.isTerminated()) {
//
//                }
//                System.out.println(" Thread Cat Done");
//                Date stop1 = new Date();
//                localDateTimeHashMap.put("Cat",stop1.getTime()-start1.getTime());
//            }
//        });
//        thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Date start1 = new Date();
//                ExecutorService executor = Executors.newSingleThreadExecutor();
//                for (Animal a: lists1.get(1)) {
//                    Runnable runnable = (Runnable) a;
//                    executor.execute(runnable);;
//                }
//                executor.shutdown();
//                while (!executor.isTerminated()) {
//
//                }
//                System.out.println(" Thread Dog Done");
//                Date stop1 = new Date();
//                localDateTimeHashMap.put("Dog",stop1.getTime()-start1.getTime());
//
//            }
//        });
//        thread3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Date start1 = new Date();
//                ExecutorService executor = Executors.newSingleThreadExecutor();
//                for (Animal a: lists1.get(2)) {
//                    Runnable runnable = (Runnable) a;
//                    executor.execute(runnable);;
//                }
//                executor.shutdown();
//                while (!executor.isTerminated()) {
//
//                }
//                System.out.println("Thread Leo Done");
//                Date stop1 = new Date();
//                localDateTimeHashMap.put("Leo",stop1.getTime()-start1.getTime());
//            }
//        });
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread1.join();
//        thread2.join();
//        thread3.join();
//        System.out.println(localDateTimeHashMap);
//    }
}
