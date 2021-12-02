package agh.ics.oop;

public class AbstractWordMapElement implements IMapElement {

    protected Vector2d position = new Vector2d(0,0);

    @Override
    public Vector2d getPosition() {
        return this.position;
    }
}
