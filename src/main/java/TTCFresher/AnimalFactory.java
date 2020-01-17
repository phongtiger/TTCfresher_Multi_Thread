package TTCFresher;

public interface AnimalFactory {
    Animal getAnimal(AnimalType animalType, long idOfAnimal, int sizeRoad);
}
