package TTCFresher;

import java.util.*;
import java.util.concurrent.*;

public class Road {
    private List<List<Animal>> lists1;
    private List<Animal> list;
    private int numberAnimalOnce;
    private int sizeRoad;
    private int numberOfThread;
    private int awaitTermination;
    private TimeUnit timeUnit;

    public Road() {
    }

    public Road(List<List<Animal>> lists1, int numberAnimalOnce, int sizeRoad, int numberOfThread, int awaitTermination, TimeUnit timeUnit) {
        this.lists1 = lists1;
        this.numberAnimalOnce = numberAnimalOnce;
        this.sizeRoad = sizeRoad;
        this.numberOfThread = numberOfThread;
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
    public List<Animal> getListMixAnimal() {
    List<Animal> animalsList = new ArrayList<>();
    AnimalFactory animalFactory = new AnimalFactoryImpl();
    for (AnimalType a : AnimalType.values()) {
        for (int i = 0; i <= this.numberAnimalOnce; i++) {
            animalsList.add(animalFactory.getAnimal(a, i, sizeRoad));
        }
    }
    return animalsList;
    }
    public void playRoadNew() throws InterruptedException {
        List<Animal> listMixAnimal = getListMixAnimal();
        HashMap<String, LinkedList<Animal>> hashMapWithKindOfAnimalVSAnimal = new HashMap<>();
        for (Animal animal : listMixAnimal
        ) {
            switch (animal.getKindOfAnimal()) {
                case "CAT":
                    if (!hashMapWithKindOfAnimalVSAnimal.containsKey("CAT")) {
                        hashMapWithKindOfAnimalVSAnimal.put("CAT", new LinkedList<>());
                    } else if (hashMapWithKindOfAnimalVSAnimal.containsKey("CAT")) {
                        hashMapWithKindOfAnimalVSAnimal.get("CAT").add(animal);
                    }
                    break;
                case "LEO":
                    if (!hashMapWithKindOfAnimalVSAnimal.containsKey("LEO")) {
                        hashMapWithKindOfAnimalVSAnimal.put("LEO", new LinkedList<>());
                    } else if (hashMapWithKindOfAnimalVSAnimal.containsKey("LEO")) {
                        hashMapWithKindOfAnimalVSAnimal.get("LEO").add(animal);
                    }
                    break;
                case "DOG":
                    if (!hashMapWithKindOfAnimalVSAnimal.containsKey("DOG")) {
                        hashMapWithKindOfAnimalVSAnimal.put("DOG", new LinkedList<>());
                    } else if (hashMapWithKindOfAnimalVSAnimal.containsKey("DOG")) {
                        hashMapWithKindOfAnimalVSAnimal.get("DOG").add(animal);
                    }
                    break;
            }
        }
        LinkedList<Animal> cat = hashMapWithKindOfAnimalVSAnimal.get(AnimalType.CAT.toString());
        LinkedList<Animal> dog = hashMapWithKindOfAnimalVSAnimal.get(AnimalType.DOG.toString());
        LinkedList<Animal> leo = hashMapWithKindOfAnimalVSAnimal.get(AnimalType.LEO.toString());

        ExecutorService executor = Executors.newFixedThreadPool(numberOfThread);
        for (int i = 0; i < numberAnimalOnce - 1; i++) {
            cat.get(i).setAnimalNext((Runnable) cat.get(i + 1));
            dog.get(i).setAnimalNext((Runnable) dog.get(i + 1));
            leo.get(i).setAnimalNext((Runnable) leo.get(i + 1));
            cat.get(i).setExecutorService(executor);
            dog.get(i).setExecutorService(executor);
            leo.get(i).setExecutorService(executor);
        }
        executor.execute((Runnable) cat.get(0));
        executor.execute((Runnable) dog.get(0));
        executor.execute((Runnable) leo.get(0));
        executor.awaitTermination(awaitTermination, timeUnit);
        executor.shutdown();
    }
}
