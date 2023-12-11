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

}
