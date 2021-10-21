package agh.ics.oop;
import java.util.*;
import java.util.ArrayList;

public class World {

    public static void main(String[] args){

        System.out.println("Start");

        run(transform(args));

        System.out.println("Stop");
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

            switch (j){
                case "f":
                    out.add(Direction.FORWARD);
                    break;

                case "b":
                    out.add(Direction.BACKWARD);
                    break;
                case "r":
                    out.add(Direction.RIGHT);
                    break;
                case "l":
                    out.add(Direction.LEFT);
                    break;
                default:
                    u++;
            }
        }
        if (u>0){
            String p = String.format("%s nieznane wartości", u);
            System.out.println(p);
        }

        return out;

    }
}
