package agh.ics.oop;

import org.testng.internal.collections.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GrassField extends AbstractWorldMap{

    private final int n;
    private final List<Grass> grasses = new ArrayList<>();

    private Vector2d upper = new Vector2d(0,0);
    private Vector2d lower = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);


    public GrassField(int n){
        this.n = n;
        for(int i = 0;i<n;i++)
        {
            Vector2d v = this.findSpot();
            this.updateArea(v);
            grasses.add(new Grass(v));
        }
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        if(position.x<0 || position.y<0)
            return false;
        if(this.objectAt(position) != null && this.objectAt(position).getClass() == Grass.class){

            Vector2d v = this.findSpot();
            for (Grass g: grasses) {
                if(g.getPosition().equals(position)){
                    g.eatGrass(v);
                    this.updateArea(v);
                    return true;
                }
            }
        }
        if(this.objectAt(position) != null && this.objectAt(position).getClass() == Animal.class)
            return false;

        this.updateArea(position);

        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {

        for (Grass g: grasses) {
            if (g.getPosition().equals(position))
                return true;
        }

        return super.isOccupied(position);
    }

    @Override
    public Object objectAt(Vector2d position) {

        for (Grass g: grasses) {
            if (g.getPosition().equals(position))
                return g;
        }

        return super.objectAt(position);
    }

    public void updateArea(Vector2d test){
        upper = upper.upperRight(test);
        lower = lower.lowerLeft(test);

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
    public Pair<Vector2d,Vector2d> getArea()
    {
        return new Pair<>(this.lower,this.upper);
    }

    public List<Grass> getGrasses(){
        return grasses;
    }

    @Override
    public String toString(){

        return super.toString(lower,upper);
    }
}
