package TTCFresher;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Leo implements Animal,Runnable{
    private String name = "LEO";
    private Long id;
    private double step;
    private int timeStep;
    private int sizeRoad;

    public Leo(Long id) {
        this.id = id;
        this.step = ThreadLocalRandom.current().nextDouble(30, 50);
        this.timeStep = ThreadLocalRandom.current().nextInt(900, 1000);

    }

    public Leo(Long id, int sizeRoad) {
        this.id = id;
        this.step = ThreadLocalRandom.current().nextDouble(100, 150);
        this.timeStep = ThreadLocalRandom.current().nextInt(800, 1000);
        this.sizeRoad = sizeRoad;
    }

    public int getSizeRoad() {
        return sizeRoad;
    }

    public void setSizeRoad(int sizeRoad) {
        this.sizeRoad = sizeRoad;
    }
    public Leo() {
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


    @Override
    public String runRoad(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSSS");
        String dateString = simpleDateFormat.format(date);
        return " "+this.name+ " "+dateString+" ";
    }
    @Override
    public void run() {
        System.out.println(this.name + " id: " + this.id + " start");
        int count = 0;
        while (count<= this.sizeRoad){
            count += this.step*this.timeStep/10000;
            processCommand();
        }
        System.out.println(this.name + " id: " + this.id + " done");
    }
    private void processCommand() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
