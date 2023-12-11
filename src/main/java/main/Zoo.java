package main;

import java.util.AbstractList;
import java.util.ArrayList;

public class Zoo {

    private int zooSize;
    private ArrayList<Animal> animals;

    public Zoo(int zooSize) {
        this.zooSize = zooSize;
        animals = new ArrayList<>(zooSize);
    }

    public boolean zooIsEmpty() {
        return animals.isEmpty();
    }

    public int getZooSize() {
        return zooSize;
    }

    public boolean add(Animal animal) {
        if (animals.size() < zooSize) {
            animals.add(animal);
            return true;
        }
        return false;
    }

    public String listAnimals() {
        String animalList = "";
        animals.sort((animal1, animal2) -> animal1.getName().compareTo(animal2.getName()));
        for (Animal animal : animals) {
            animalList += animal.getName() + ", ";
        }
        return animalList.substring(0, animalList.length() - 2);
    }

}
