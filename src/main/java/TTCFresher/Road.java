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

    private List<List<Animal>> getListByListAnimal() {
        List<List<Animal>> animals = new ArrayList<>();
        AnimalFactory animalFactory = new AnimalFactoryImpl();
        for (AnimalType a : AnimalType.values()) {
            List<Animal> kindOfAnimals = new ArrayList<>();
            for (int i = 0; i < this.numberAnimalOnce; i++) {
                kindOfAnimals.add(animalFactory.getAnimal(a, i, sizeRoad));
            }
            animals.add(kindOfAnimals);
        }
        return animals;
    }


    public List<Runnable> getAnimalsRun() {
        List<Runnable> runnableAnimals = new ArrayList<>();
        List<List<Animal>> animalsFormListList = getListByListAnimal();
        for (List<Animal> animals : animalsFormListList
        ) {
            Runnable runnable = new Thread((() -> {
                ExecutorService executor1 = Executors.newSingleThreadExecutor();
                for (Animal a : animals) {
                    Runnable runnableChild = (Runnable) a;
                    executor1.execute(runnableChild);
                }
                executor1.shutdown();
                while (!executor1.isTerminated()) {

                }
                System.out.println(" Thread: " + animals.get(0).endRoad() + " Done");

            }));
            runnableAnimals.add(runnable);
        }
        return runnableAnimals;
    }

    public void playRoadUnLimit() {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Runnable> animalsRun = getAnimalsRun();

        for (Runnable r : animalsRun
        ) {
            executor.execute(r);
        }
        executor.shutdown();

    }

    public List<Animal> getMixAnimals() {
        List<Animal> mixAnimals = new ArrayList<>();
        AnimalFactory animalFactory = new AnimalFactoryImpl();
        for (AnimalType a : AnimalType.values()) {
            for (int i = 0; i <= this.numberAnimalOnce; i++) {
                mixAnimals.add(animalFactory.getAnimal(a, i, sizeRoad));
            }
        }
        return mixAnimals;
    }

    public void playRoadNew() throws InterruptedException {
        List<Animal> mixAnimals = getMixAnimals();
        HashMap<String, LinkedList<Animal>> hashMapWithKindOfAnimalVSAnimal = new HashMap<>();
        for (Animal animal : mixAnimals
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
        LinkedList<Animal> cats = hashMapWithKindOfAnimalVSAnimal.get(AnimalType.CAT.toString());
        LinkedList<Animal> dogs = hashMapWithKindOfAnimalVSAnimal.get(AnimalType.DOG.toString());
        LinkedList<Animal> leos = hashMapWithKindOfAnimalVSAnimal.get(AnimalType.LEO.toString());

        ExecutorService executor = Executors.newFixedThreadPool(numberOfThread);
        for (int i = 0; i < numberAnimalOnce - 1; i++) {
            cats.get(i).setAnimalNext((Runnable) cats.get(i + 1));
            dogs.get(i).setAnimalNext((Runnable) dogs.get(i + 1));
            leos.get(i).setAnimalNext((Runnable) leos.get(i + 1));
            cats.get(i).setExecutorService(executor);
            dogs.get(i).setExecutorService(executor);
            leos.get(i).setExecutorService(executor);
        }
        executor.execute((Runnable) cats.get(0));
        executor.execute((Runnable) dogs.get(0));
        executor.execute((Runnable) leos.get(0));
        executor.awaitTermination(awaitTermination, timeUnit);
        executor.shutdown();
    }
}
