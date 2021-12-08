package agh.ics.oop;

import org.testng.internal.collections.Pair;

import java.util.SortedSet;
import java.util.TreeSet;

import static agh.ics.oop.Comparators.compareX;
import static agh.ics.oop.Comparators.compareY;

public class MapBoundary implements IPositionChangeObserver{

    private final AbstractWorldMap map;
    private final SortedSet<AbstractWordMapElement> boundaryX = new TreeSet<>(compareX);
    private final SortedSet<AbstractWordMapElement> boundaryY = new TreeSet<>(compareY);

    public MapBoundary(AbstractWorldMap map){
        this.map = map;

    }

    public void addToSet(AbstractWordMapElement element) {

            this.boundaryX.add(element);
//            System.out.println(boundaryX.size());
            this.boundaryY.add(element);

    }
    public void removeFromSet(AbstractWordMapElement element){
        this.boundaryX.remove(element);
//        System.out.println(boundaryX.size());
        this.boundaryY.remove(element);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {

        removeFromSet(this.map.objectAt(oldPosition));

        addToSet(this.map.objectAt(newPosition));
    }

    public Pair<Vector2d,Vector2d> getBoundary(){
        Vector2d lowerLeft;
        Vector2d upperRight;
        if(this.boundaryX.size() == 0) {

            return new Pair<>(new Vector2d(0,0), new Vector2d(0,0));
        }
        lowerLeft = this.boundaryX.first().getPosition().lowerLeft(this.boundaryY.first().getPosition());
        upperRight = this.boundaryX.last().getPosition().upperRight(this.boundaryY.last().getPosition());

        return new Pair<>(lowerLeft, upperRight);
    }
}
