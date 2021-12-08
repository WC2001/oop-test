package agh.ics.oop;

import java.util.ArrayList;

public class OptionsParser{
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
                    throw new IllegalArgumentException(s + " is not legal move specification");
                }
            }
        }

        return v.toArray(new MoveDirection[v.size()] );

    }
}
