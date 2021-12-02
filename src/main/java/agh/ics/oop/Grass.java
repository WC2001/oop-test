package agh.ics.oop;

public class Grass extends AbstractWordMapElement{

    public Grass(Vector2d position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "*";
    }

}
