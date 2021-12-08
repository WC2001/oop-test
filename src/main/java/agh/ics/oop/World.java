package agh.ics.oop;
import java.util.*;
import java.util.ArrayList;

public class World {

    public static void main(String[] args){


        try{
            AbstractWorldMap map = new GrassField(10);
            MoveDirection[] directions = new OptionsParser(args).parse();
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        } catch (IllegalArgumentException ex){
            System.out.println(ex);
            return;
        }


    }

//    public static void run(ArrayList<Direction> args){
//        for (Direction e: args){
//            String o = switch (e) {
//                case LEFT -> "Zwierzak idzie w lewo";
//                case RIGHT -> "Zwierzak idzie w prawo";
//                case FORWARD -> "Zwierzak idzie do przodu";
//                case BACKWARD -> "Zwierzak idzie do tyłu";
//            };
//
//            System.out.println(o);
//        }
//
//    }
//    public static ArrayList<Direction> transform(String[] arg){
//
//        ArrayList<Direction> out = new ArrayList<Direction>();
//
//        for (String j : arg) {
//
//            switch (j) {
//                case "f" -> out.add(Direction.FORWARD);
//                case "b" -> out.add(Direction.BACKWARD);
//                case "r" -> out.add(Direction.RIGHT);
//                case "l" -> out.add(Direction.LEFT);
//                default -> {}
//            }
//        }
//        return out;
//    }
}
