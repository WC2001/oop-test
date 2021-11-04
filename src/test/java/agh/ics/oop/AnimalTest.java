package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    void moveT(World.Vector2d v, MapDirection d, String[] toParse){

        MoveDirection[] parsed= new World.OptionsParser(toParse).parse();
        World.Animal animal = new World.Animal();
        for (MoveDirection i: parsed) {
            animal.move(i);
        }
        assertEquals(v, animal.getPosition());
        assertEquals(d, animal.getDirection());

    }

    @Test
    void moveTest(){

        moveT(new World.Vector2d(2, 2),MapDirection.NORTH, new String[]{});
        moveT(new World.Vector2d(2, 4),MapDirection.WEST, new String[]{"f", "forward", "f", "l"});
        moveT(new World.Vector2d(2, 2),MapDirection.WEST, new String[]{"g", "l"});
        moveT(new World.Vector2d(3, 2),MapDirection.EAST, new String[]{"", "r", "f"});
        moveT(new World.Vector2d(2, 2),MapDirection.SOUTH, new String[]{"r", "r"});
        moveT(new World.Vector2d(4, 4),MapDirection.SOUTH, new String[]{"f", "f", "l", "b", "b", "b", "b", "l"});
        moveT(new World.Vector2d(2, 0),MapDirection.SOUTH, new String[]{"b", "b", "b", "b", "r", "r"});
        moveT(new World.Vector2d(0, 4),MapDirection.EAST, new String[]{"f", "f", "f", "r", "b", "b", "b"});
    }

}
