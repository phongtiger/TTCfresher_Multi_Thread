package TTCFresher;

public class AnimalFactoryImpl implements AnimalFactory {
    @Override
    public Animal getAnimal(AnimalType animalType, long i, int road) {
                Animal animal = null;
        switch (animalType){
            case DOG:
                animal = new Dog(i,road);
                break;
            case CAT:
                animal = new Cat(i,road);
                break;
            case LEO:
                animal = new Leo(i,road);
                break;
        }
        return animal;
    }
}
