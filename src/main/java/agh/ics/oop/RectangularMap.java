package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{
    private final int width;
    private final int height;
    private final List<Animal> animals = new ArrayList<>();
    private final MapVisualizer mapVisualizer = new MapVisualizer(this);

    public RectangularMap(int w, int h){
        this.width = Math.max(w,1);
        this.height = Math.max(h,1);

    }



    @Override
    public boolean canMoveTo(Vector2d position) {
        if (position.x >= width || position.x < 0 || position.y >= height || position.y < 0)
            return false;

        return !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if ( canMoveTo(animal.getPosition()) )
            this.animals.add(animal);
        return !canMoveTo(animal.getPosition());
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal a: this.animals) {
            if (a.getPosition().equals(position))
                return true;
        }

        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal a: animals) {
            if (a.getPosition().equals(position))
                return a;
        }
        return null;
    }

    public String toString(){

        return this.mapVisualizer.draw(new Vector2d(0,0), new Vector2d(this.width-1,this.height-1));
    }

}
