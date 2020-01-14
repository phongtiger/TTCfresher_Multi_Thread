package TTCFresher;

import java.util.*;
import java.util.concurrent.*;

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

//    private List<List<Animal>> getListListAnimal() {
//        List<List<Animal>> lists = new ArrayList<>();
//        for (AnimalType a : AnimalType.values()) {
//            List<Animal> catList = new ArrayList<>();
//            for (int i = 0; i < this.numberAnimalOnce; i++) {
//                catList.add(new AnimalFactory().getAnimal(a, i, sizeRoad, executor, initialDelay, delay, timeUnit));
//            }
//            lists.add(catList);
//        }
//        return lists;
//    }

    public List<Animal> getListThreadPool() {
        List<Animal> animalsList = new ArrayList<>();
        for (AnimalType a : AnimalType.values()) {
            for (int i = 0; i <= this.numberAnimalOnce; i++) {
                animalsList.add(new AnimalFactory().getAnimal(a, i, sizeRoad));
            }
        }
        return animalsList;
    }
//
//    public List<Runnable> getRunList() {
//        List<Runnable> runnableList = new ArrayList<>();
//        for (List<Animal> l : getListListAnimal()
//        ) {
//            Runnable runnable = new Thread((() -> {
//                ExecutorService executor1 = Executors.newSingleThreadExecutor();
//                for (Animal a : l) {
//                    Runnable runnable1 = (Runnable) a;
//                    executor1.execute(runnable1);
//                }
//                executor1.shutdown();
//                while (!executor1.isTerminated()) {
//
//                }
//                System.out.println(" Thread: " + l.get(0).endRoad() + " Done");
//
//            }));
//            runnableList.add(runnable);
//        }
//        return runnableList;
//    }


//    public void playRoadUnLimit() {
//        ExecutorService executor = Executors.newCachedThreadPool();
//        List<Runnable> listRun = getRunList();
//
//        for (Runnable r : listRun
//        ) {
//            executor.execute(r);
//        }
//        executor.shutdown();
//
//    }

    public void playRoadNew() throws InterruptedException {


        List<Animal> listAnimal = getListThreadPool();
        HashMap<String, LinkedList<Animal>> stringLinkedListHashMap = new HashMap<>();
        for (Animal animal : listAnimal
        ) {
            switch (animal.getInfo()) {
                case "CAT":
                    if (!stringLinkedListHashMap.containsKey("CAT")) {
                        stringLinkedListHashMap.put("CAT", new LinkedList<>());
                    } else if (stringLinkedListHashMap.containsKey("CAT")) {
                        stringLinkedListHashMap.get("CAT").add(animal);
                    }
                    break;
                case "LEO":
                    if (!stringLinkedListHashMap.containsKey("LEO")) {
                        stringLinkedListHashMap.put("LEO", new LinkedList<>());
                    } else if (stringLinkedListHashMap.containsKey("LEO")) {
                        stringLinkedListHashMap.get("LEO").add(animal);
                    }
                    break;
                case "DOG":
                    if (!stringLinkedListHashMap.containsKey("DOG")) {
                        stringLinkedListHashMap.put("DOG", new LinkedList<>());
                    } else if (stringLinkedListHashMap.containsKey("DOG")) {
                        stringLinkedListHashMap.get("DOG").add(animal);
                    }
                    break;
            }
        }
        LinkedList<Animal> cat = stringLinkedListHashMap.get(AnimalType.CAT.toString());
        LinkedList<Animal> dog = stringLinkedListHashMap.get(AnimalType.DOG.toString());
        LinkedList<Animal> leo = stringLinkedListHashMap.get(AnimalType.LEO.toString());

        ExecutorService executor = Executors.newFixedThreadPool(numberOfThread);
        for (int i = 0; i < numberAnimalOnce - 1; i++) {
            cat.get(i).setNext((Runnable) cat.get(i + 1));
            dog.get(i).setNext((Runnable) dog.get(i + 1));
            leo.get(i).setNext((Runnable) leo.get(i + 1));
            cat.get(i).setThreadPoolExecutor(executor);
            dog.get(i).setThreadPoolExecutor(executor);
            leo.get(i).setThreadPoolExecutor(executor);
        }
        executor.execute((Runnable) cat.get(0));
        executor.execute((Runnable) dog.get(0));
        executor.execute((Runnable) leo.get(0));
        executor.awaitTermination(awaitTermination, timeUnit);
        executor.shutdown();
    }
}

