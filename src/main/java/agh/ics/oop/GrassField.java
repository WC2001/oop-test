package agh.ics.oop;

import org.testng.internal.collections.Pair;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.ThreadLocalRandom;

public class GrassField extends AbstractWorldMap{

    private final int n;
    private final MapBoundary boundary;

    private final List<Grass> grasses = new ArrayList<>();


    public GrassField(int n){
        this.n = n;
        this.boundary = new MapBoundary(this);
        for(int i = 0;i<n;i++)
        {
            Vector2d v = this.findSpot();
            Grass g = new Grass(v);
            grasses.add(g);
            hashMap.put(v,g);
            this.boundary.addToSet(g);
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(super.canMoveTo(position)){
            if (objectAt(position) instanceof Grass) {
                this.boundary.removeFromSet(this.objectAt(position));
                hashMap.remove(position);
                replaceGrass();
            }
            return true;
        }

        return false;
    }
    @Override
    public  boolean place(Animal animal){
        super.place(animal);
        this.boundary.addToSet(animal);
        return true;
    }

    public Vector2d findSpot(){

        int x = ThreadLocalRandom.current().nextInt(0, (int) (Math.sqrt(10*this.n)+ 1));
        int y = ThreadLocalRandom.current().nextInt(0, (int) (Math.sqrt(10*this.n)+ 1));

        while (this.isOccupied(new Vector2d(x,y))) {
            x = ThreadLocalRandom.current().nextInt(0, (int) (Math.sqrt(10*this.n)+ 1));
            y = ThreadLocalRandom.current().nextInt(0, (int) (Math.sqrt(10*this.n)+ 1));
        }

        return new Vector2d(x,y);
    }


    public List<Grass> getGrasses(){
        return grasses;
    }

    public void replaceGrass(){

        Vector2d v = this.findSpot();

        hashMap.put(v,new Grass(v));
        this.boundary.addToSet(new Grass(v));

    }

    @Override
    public String toString(){
        return super.toString(this.boundary.getBoundary().first(),this.boundary.getBoundary().second());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        AbstractWordMapElement element = this.hashMap.get(oldPosition);
        hashMap.put(newPosition,element);
        this.boundary.positionChanged(oldPosition,newPosition);
        hashMap.remove(oldPosition);
    }
}
