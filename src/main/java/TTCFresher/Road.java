package TTCFresher;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Road {
    private List<List<Animal>> lists1;
    private List<Animal> list;
    private int numberAnimalOnce;
    private int sizeRoad;
    private int numberOfThread;
    private int initialDelay;
    private int delay;
    private int awaitTermination;
    private TimeUnit timeUnit;

    public Road() {
    }

    public Road(List<List<Animal>> lists1, int numberAnimalOnce, int sizeRoad, int numberOfThread, int initialDelay, int delay, int awaitTermination, TimeUnit timeUnit) {
        this.lists1 = lists1;
        this.numberAnimalOnce = numberAnimalOnce;
        this.sizeRoad = sizeRoad;
        this.numberOfThread = numberOfThread;
        this.initialDelay = initialDelay;
        this.delay = delay;
        this.awaitTermination = awaitTermination;
        this.timeUnit = timeUnit;
    }

    private List<List<Animal>> getListListAnimal() {
        List<List<Animal>> lists = new ArrayList<>();
        for (AnimalType a : AnimalType.values()) {
            List<Animal> catList = new ArrayList<>();
            for (int i = 0; i < this.numberAnimalOnce; i++) {
                catList.add(new AnimalFactory().getAnimal(a, i, this.sizeRoad));
            }
            lists.add(catList);
        }
        return lists;
    }

    public List<Animal> getListThreadPool() {
        List<Animal> animalsList = new ArrayList<>();
        for (AnimalType a : AnimalType.values()) {
            for (int i = 0; i < this.numberAnimalOnce; i++) {
                animalsList.add(new AnimalFactory().getAnimal(a, i, this.sizeRoad));
            }
        }
        return animalsList;
    }

    public List<Runnable> getRunList() {
        List<Runnable> runnableList = new ArrayList<>();
        for (List<Animal> l : getListListAnimal()
        ) {
            Runnable runnable = new Thread((() -> {
                ExecutorService executor1 = Executors.newSingleThreadExecutor();
                for (Animal a : l) {
                    Runnable runnable1 = (Runnable) a;
                    executor1.execute(runnable1);
                }
                executor1.shutdown();
                while (!executor1.isTerminated()) {

                }
                System.out.println(" Thread: " + l.get(0).endRoad() + " Done");

            }));
            runnableList.add(runnable);
        }
        return runnableList;
    }

    public List<Thread> getRunListThreadPool() {
        List<Thread> runList = new ArrayList<>();
        for (List<Animal> l : getListListAnimal()
        ) {
            for (Animal animal : l) {
                Thread runnable = new Thread((Runnable) animal);
                runList.add(runnable);
            }
        }
        return runList;
    }

    public void playRoadUnLimit() {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Runnable> listRun = getRunList();

        for (Runnable r : listRun
        ) {
            executor.execute(r);
        }
        executor.shutdown();

    }

    public void playRoadNew() throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(numberOfThread);
        List<Thread> listRun = getRunListThreadPool();
        for (Thread r : listRun
        ) {
            executor.scheduleWithFixedDelay(r, initialDelay, delay, TimeUnit.SECONDS);
        }
        executor.awaitTermination(awaitTermination, timeUnit);
        executor.shutdown();
    }
}
