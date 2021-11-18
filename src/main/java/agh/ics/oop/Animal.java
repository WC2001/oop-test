package agh.ics.oop;

public class Animal{
    private MapDirection direction;
    private Vector2d position;
    private IWorldMap map;

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.direction = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;

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
                if (this.map.canMoveTo(this.position.add(this.direction.toUnitVector().opposite())))
                    this.position = this.position.add(this.direction.toUnitVector().opposite());
            }
            case FORWARD -> {
                if (this.map.canMoveTo(this.position.add(this.direction.toUnitVector())))
                    this.position = this.position.add(this.direction.toUnitVector());

            }
        }

    }
}
