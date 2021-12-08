package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal extends AbstractWordMapElement{
    private MapDirection direction;
    private Vector2d position;
    private final AbstractWorldMap map;

    private final List<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(AbstractWorldMap map, Vector2d initialPosition){
        this.direction = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;
        this.addObserver(this.map);

    }
    public String toString(){
        return switch (this.direction){
            case EAST -> "E";
            case WEST -> "W";
            case SOUTH -> "S";
            case NORTH -> "N";
        };

    }
    public Vector2d getPosition(){
        return this.position;
    }

    public MapDirection getDirection(){
        return this.direction;
    }

    boolean isAt(Vector2d position){
        return this.position.x == position.x && this.position.y == position.y;
    }

    public void move(MoveDirection direction){
        switch (direction){
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case BACKWARD -> {
                if (this.map.canMoveTo(this.position.add(this.direction.toUnitVector().opposite()))){
                    Vector2d newPosition = this.position.add(this.direction.toUnitVector().opposite());
                    Vector2d oldPosition = this.position;


                    positionChanged(oldPosition, newPosition);
                    this.position = newPosition;

                }

            }
            case FORWARD -> {

                if (this.map.canMoveTo(this.position.add(this.direction.toUnitVector()))){
                    Vector2d newPosition = this.position.add(this.direction.toUnitVector());

                    Vector2d oldPosition = this.position;

                    positionChanged(oldPosition, newPosition);
                    this.position = newPosition;

                }


            }
        }

    }

    private void addObserver(IPositionChangeObserver observer) {
        this.observers.add(observer);
    }

    private void removeObserver(IPositionChangeObserver observer) {
        this.observers.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer : this.observers)
            observer.positionChanged(oldPosition, newPosition);
    }

}
