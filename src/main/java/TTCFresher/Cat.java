package TTCFresher;

import java.util.concurrent.ThreadLocalRandom;

public class Cat implements Animal{
    private  String name = "CAT";
    private Long id;
    private double step;
    private int timeStep;
    private int sizeRoad;

    public Cat(Long id,int sizeRoad) {
        this.id = id;
        this.step = ThreadLocalRandom.current().nextDouble(30, 50);
        this.timeStep = ThreadLocalRandom.current().nextInt(900, 1000);
        this.sizeRoad = sizeRoad;
    }

    public Cat() {
    }

    public Cat(long i) {
        this.id = id;
        this.step = ThreadLocalRandom.current().nextDouble(30, 50);
        this.timeStep = ThreadLocalRandom.current().nextInt(900, 1000);
    }


    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public double getTimeStep() {
        return timeStep;
    }

    public void setTimeStep(int timeStep) {
        this.timeStep = timeStep;
    }

    public int getSizeRoad() {
        return sizeRoad;
    }

    public void setSizeRoad(int sizeRoad) {
        this.sizeRoad = sizeRoad;
    }

    @Override
    public void runRoad() throws InterruptedException {
        System.out.println(this.name + " id: " + this.id + " start");
        int count = 0;
        while (count<= this.sizeRoad){
            count += this.step*this.timeStep/10000;
            Thread.sleep(10);
        }
        System.out.println(this.name + " id: " + this.id + " done");
    }
}
