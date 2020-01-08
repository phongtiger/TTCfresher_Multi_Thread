package TTCFresher;

import java.util.List;

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
    public void playRoad(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (Animal a: lists1.get(0)) {
                    try {
                       a.runRoad();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(" Thread Cat Done");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (Animal a: lists1.get(1)) {
                    try {
                        a.runRoad();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(" Thread Dog Done");
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (Animal a: lists1.get(2)) {
                    try {
                        a.runRoad();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread Leo Done");
            }
        });
        thread.start();
        thread2.start();
        thread3.start();
    }
}
