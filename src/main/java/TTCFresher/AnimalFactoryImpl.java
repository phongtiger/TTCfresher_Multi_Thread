package TTCFresher;

public class AnimalFactoryImpl implements AnimalFactory {
    @Override
    public Animal getAnimal(AnimalType animalType, long idOfAnimal, int sizeRoad) {
                Animal animal;
        switch (animalType){
            case DOG:
                animal = new Dog(idOfAnimal,sizeRoad);
                break;
            case CAT:
                animal = new Cat(idOfAnimal,sizeRoad);
                break;
            case LEO:
                animal = new Leo(idOfAnimal,sizeRoad);
                break;
            default:
                animal = null;
        }
        return animal;
    }
}
