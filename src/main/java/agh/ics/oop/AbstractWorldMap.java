package agh.ics.oop;

import org.testng.internal.collections.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected List<Animal> animals = new ArrayList<>();
    protected Map<Vector2d, AbstractWordMapElement> hashMap = new HashMap<>();
    protected final MapVisualizer mapVisualizer = new MapVisualizer(this);

    protected Vector2d upper = new Vector2d(0,0);
    protected Vector2d lower = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);

    public boolean canMoveTo(Vector2d position){
        if (position.x<0 || position.y<0)
            return false;

        return ! (objectAt(position) instanceof Animal);
    }

    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())) {
            this.animals.add(animal);
            hashMap.put(animal.getPosition(), animal);
            updateArea(animal.getPosition());
            return true;
        }
        return false;
    }

    public Object objectAt(Vector2d position) {

        return hashMap.get(position);
    }

    public boolean isOccupied(Vector2d position) {
        return ! (hashMap.get(position) == null);
    }

    public void updateArea(Vector2d test){
        upper = upper.upperRight(test);
        lower = lower.lowerLeft(test);
    }

    public Pair<Vector2d,Vector2d> getArea()
    {
        return new Pair<>(this.lower,this.upper);
    }

    public String toString( Vector2d v, Vector2d k){

        return this.mapVisualizer.draw(v, k);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        AbstractWordMapElement e = hashMap.remove(oldPosition);
        hashMap.put(newPosition, e);

    }
}
