package TTCFresher;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    public void playRoad() throws InterruptedException {
        HashMap<String,Long> localDateTimeHashMap = new HashMap<>();
        Thread thread1;
        Thread thread2;
        Thread thread3;

        thread1= new Thread(new Runnable() {
            @Override
            public void run() {
                Date start1 = new Date();
                ExecutorService executor = Executors.newSingleThreadExecutor();
                for (Animal a: lists1.get(0)) {
                    Runnable runnable = (Runnable) a;
                    executor.execute(runnable);;
                }
                executor.shutdown();
                while (!executor.isTerminated()) {

                }
                System.out.println(" Thread Cat Done");
                Date stop1 = new Date();
                localDateTimeHashMap.put("Cat",stop1.getTime()-start1.getTime());
            }
        });
        thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Date start1 = new Date();
                ExecutorService executor = Executors.newSingleThreadExecutor();
                for (Animal a: lists1.get(1)) {
                    Runnable runnable = (Runnable) a;
                    executor.execute(runnable);;
                }
                executor.shutdown();
                while (!executor.isTerminated()) {

                }
                System.out.println(" Thread Dog Done");
                Date stop1 = new Date();
                localDateTimeHashMap.put("Dog",stop1.getTime()-start1.getTime());

            }
        });
        thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                Date start1 = new Date();
                ExecutorService executor = Executors.newSingleThreadExecutor();
                for (Animal a: lists1.get(2)) {
                    Runnable runnable = (Runnable) a;
                    executor.execute(runnable);;
                }
                executor.shutdown();
                while (!executor.isTerminated()) {

                }
                System.out.println("Thread Leo Done");
                Date stop1 = new Date();
                localDateTimeHashMap.put("Leo",stop1.getTime()-start1.getTime());
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println(localDateTimeHashMap);
    }
    public void playRoadNew(){
        HashMap<String,Long> localDateTimeHashMap = new HashMap<>();
        final int NUM_OF_THREAD = 2;
        ExecutorService executor = Executors.newFixedThreadPool(NUM_OF_THREAD);
        Runnable thread1;
        Runnable thread2;
        Runnable thread3;
        thread1= new Thread(() -> {
            Date start1 = new Date();
            ExecutorService executor1 = Executors.newSingleThreadExecutor();
            for (Animal a: lists1.get(0)) {
                Runnable runnable = (Runnable) a;
                executor1.execute(runnable);;
            }
            executor1.shutdown();
            while (!executor1.isTerminated()) {

            }
            System.out.println(" Thread Cat Done");
            Date stop1 = new Date();
            localDateTimeHashMap.put("Cat",stop1.getTime()-start1.getTime());
        });
        thread2 = new Thread(() -> {
            Date start1 = new Date();
            ExecutorService executor12 = Executors.newSingleThreadExecutor();
            for (Animal a: lists1.get(1)) {
                Runnable runnable = (Runnable) a;
                executor12.execute(runnable);;
            }
            executor12.shutdown();
            while (!executor12.isTerminated()) {

            }
            System.out.println(" Thread Dog Done");
            Date stop1 = new Date();
            localDateTimeHashMap.put("Dog",stop1.getTime()-start1.getTime());

        });
        thread3 = new Thread(() -> {
            Date start1 = new Date();
            ExecutorService executor13 = Executors.newSingleThreadExecutor();
            for (Animal a: lists1.get(2)) {
                Runnable runnable = (Runnable) a;
                executor13.execute(runnable);;
            }
            executor13.shutdown();
            while (!executor13.isTerminated()) {

            }
            System.out.println("Thread Leo Done");
            Date stop1 = new Date();
            localDateTimeHashMap.put("Leo",stop1.getTime()-start1.getTime());
        });
        List<Runnable> runnables = new ArrayList<>();
        runnables.add(thread1);
        runnables.add(thread2);
        runnables.add(thread3);
        for (Runnable r: runnables
             ) {
            executor.execute(r);
        }
        executor.shutdown();

        while (!executor.isTerminated()) {

        }
        System.out.println(localDateTimeHashMap);
    }
}
