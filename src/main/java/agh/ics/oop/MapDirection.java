package agh.ics.oop;
enum MapDirection{
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString() {
        return switch (this) {
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case EAST -> "Wschód";
            case WEST -> "Zachód";
        };
    }
    public MapDirection previous(){
        return switch (this) {
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case EAST -> NORTH;
            case WEST -> SOUTH;
        };
    }
    public MapDirection next(){
        return switch (this) {
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case EAST -> SOUTH;
            case WEST -> NORTH;
        };
    }
    public World.Vector2d toUnitVector(){
        return switch (this) {
            case NORTH -> new World.Vector2d(0, 1);
            case SOUTH -> new World.Vector2d(0, -1);
            case EAST -> new World.Vector2d(1, 0);
            case WEST -> new World.Vector2d(-1, 0);
        };
    }
}

