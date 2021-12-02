package agh.ics.oop;

import org.testng.internal.collections.Pair;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.ThreadLocalRandom;

public class GrassField extends AbstractWorldMap{

    private final int n;
    private final List<Grass> grasses = new ArrayList<>();


    public GrassField(int n){
        this.n = n;
        for(int i = 0;i<n;i++)
        {
            Vector2d v = this.findSpot();
            this.updateArea(v);
            Grass g = new Grass(v);
            grasses.add(g);
            hashMap.put(v,g);
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {

        if (objectAt(position) instanceof Grass) {
            hashMap.remove(position);
            replaceGrass();
        }

        return super.canMoveTo(position);
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
        updateArea(v);
    }

    @Override
    public String toString(){

        return super.toString(lower,upper);
    }
}
