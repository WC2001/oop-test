package agh.ics.oop;
import java.util.*;
import java.util.ArrayList;

public class World {

    public static void main(String[] args){

        System.out.println("Start");

        run(transform(args));

        System.out.println("Stop");

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

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

        int u = 0;
        for (String j : arg) {

            switch (j) {
                case "f" -> out.add(Direction.FORWARD);
                case "b" -> out.add(Direction.BACKWARD);
                case "r" -> out.add(Direction.RIGHT);
                case "l" -> out.add(Direction.LEFT);
                default -> u++;
            }
        }
        if (u>0){
            String p = String.format("%s nieznane wartości", u);
            System.out.println(p);
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
        Vector2d lowerleft(Vector2d other){
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
}
