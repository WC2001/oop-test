package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap{
    protected List<Animal> animals = new ArrayList<>();
    private final MapVisualizer mapVisualizer = new MapVisualizer(this);

    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())) {
            this.animals.add(animal);
            return true;
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        for (Animal a: animals) {
            if (a.isAt(position))
                return a;
        }
        return null;
    }

    public boolean isOccupied(Vector2d position) {
        for (Animal a: this.animals) {
            if (a.isAt(position))
                return true;
        }

        return false;
    }

    public String toString( Vector2d v, Vector2d k){

        return this.mapVisualizer.draw(v, k);
    }

}
