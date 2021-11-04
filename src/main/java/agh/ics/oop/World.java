package agh.ics.oop;
import java.util.*;
import java.util.ArrayList;

public class World {

    public static void main(String[] args){

        System.out.println("Start");

        run(transform(args));

        System.out.println("Stop");
        OptionsParser v = new OptionsParser(args);
        MoveDirection[] t = v.parse();

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        Animal k = new Animal();
        for (MoveDirection e:t) {
            k.move(e);
            System.out.println(k);

        }
        System.out.println(k.toString());
        System.out.println(k.isAt(new Vector2d(2,2)));
        /*k.move(MoveDirection.RIGHT);
        k.move(MoveDirection.FORWARD);
        k.move(MoveDirection.FORWARD);
        k.move(MoveDirection.FORWARD);
        k.move(MoveDirection.FORWARD);
        k.move(MoveDirection.FORWARD);
        System.out.println(k.toString());*/

    }

    public static void run(ArrayList<Direction> args){
        for (Direction e: args){
            String o = switch (e) {
                case LEFT -> "Zwierzak idzie w lewo";
                case RIGHT -> "Zwierzak idzie w prawo";
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
            };

            System.out.println(o);
        }

    }
    public static ArrayList<Direction> transform(String[] arg){

        ArrayList<Direction> out = new ArrayList<Direction>();

        for (String j : arg) {

            switch (j) {
                case "f" -> out.add(Direction.FORWARD);
                case "b" -> out.add(Direction.BACKWARD);
                case "r" -> out.add(Direction.RIGHT);
                case "l" -> out.add(Direction.LEFT);
                default -> {}
            }
        }
        return out;
    }

    static class Vector2d {
        public final int x;
        public final int y;

        public Vector2d(int x, int y){
            this.x = x;
            this.y = y;
        }
        public String toString(){
            return String.format( "(%d,%d)", x, y);
        }
        boolean precedes(Vector2d other){
            if (this.x <= other.x && this.y <= other.y)
                return true;
            return false;
        }
        boolean follows(Vector2d other){
            if (this.x >= other.x && this.y >= other.y)
                return true;
            return false;
        }
        Vector2d upperRight(Vector2d other){
            return new Vector2d(Math.max(this.x, other.x), Math.max(this.y, other.y) );
        }
        Vector2d lowerLeft(Vector2d other){
            return new Vector2d(Math.min(this.x, other.x), Math.min(this.y, other.y) );
        }
        Vector2d add(Vector2d other){
            return new Vector2d(this.x + other.x, this.y +other.y );
        }
        Vector2d subtract(Vector2d other){
            return new Vector2d(this.x - other.x, this.y - other.y );
        }
        public boolean equals(Object other){
            if (this == other)
                return true;
            if (!(other instanceof Vector2d))
                return false;
            Vector2d that = (Vector2d) other;
            if (that.x == this.x && that.y == this.y)
                return true;
            return false;
        }
        Vector2d opposite(){
            return new Vector2d(- this.x , - this.y);
        }

    }

    static class Animal{
        private MapDirection direction;
        private Vector2d position;
        private final int low= 0;
        private final int high = 4;

         public Animal(){
             this.direction = MapDirection.NORTH;
             this.position = new Vector2d(2,2);

         }
         public String toString(){
             return String.format("(%d,%d) %s", position.x, position.y, direction);

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
                 case BACKWARD -> {this.position = this.position.add(this.direction.toUnitVector().opposite());
                 if (this.position.x<this.low || this.position.y <this.low || this.position.x>this.high || this.position.y>this.high)
                     this.move(MoveDirection.FORWARD);
                 }
                 case FORWARD -> {this.position = this.position.add(this.direction.toUnitVector());
                     if (this.position.x<this.low || this.position.y <this.low || this.position.x>this.high || this.position.y>this.high)
                         this.move(MoveDirection.BACKWARD);
                 }
             }

         }
    }
    static class OptionsParser{
        private final String[] in;

        public OptionsParser(String[] args){
            this.in = args;
        }


        MoveDirection[] parse(){
            ArrayList<MoveDirection> v = new ArrayList<MoveDirection>();
            for (String s: in) {
                switch (s) {
                    case "f", "forward" -> {
                        v.add(MoveDirection.FORWARD);
                    }
                    case "b", "backward" -> {
                        v.add(MoveDirection.BACKWARD);
                    }
                    case "r", "right" -> {
                        v.add(MoveDirection.RIGHT);
                    }
                    case "l", "left" -> {
                        v.add(MoveDirection.LEFT);
                    }
                    default -> {
                    }
                }
            }
            MoveDirection[] out = new MoveDirection[v.size()];
            for( int i=0;i<v.size();i++)
                out[i] = v.get(i);

            return out;

        }
    }
}
