package TTCFresher;

public class AnimalFactory {
    public Animal getAnimal(AnimalType animalType,long i){
        Animal animal = null;
        switch (animalType){
            case DOG:
                animal = new Dog(i);
            case CAT:
                animal = new Cat(i);
            case LEO:
                animal = new Leo(i);
        }
        return animal;
    }

}
