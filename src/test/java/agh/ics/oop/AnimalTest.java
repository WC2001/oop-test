package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    void moveT(Vector2d v, MapDirection d, String[] toParse){

        MoveDirection[] parsed= new OptionsParser(toParse).parse();
        Animal animal = new Animal(new RectangularMap(5,5), new Vector2d(2,2));
        for (MoveDirection i: parsed) {
            animal.move(i);
        }
        assertEquals(v, animal.getPosition());
        assertEquals(d, animal.getDirection());

    }

    @Test
    void moveTest(){

        moveT(new Vector2d(2, 2),MapDirection.NORTH, new String[]{});
        moveT(new Vector2d(2, 4),MapDirection.WEST, new String[]{"f", "forward", "f", "l"});
        moveT(new Vector2d(2, 2),MapDirection.WEST, new String[]{"g", "l"});
        moveT(new Vector2d(3, 2),MapDirection.EAST, new String[]{"", "r", "f"});
        moveT(new Vector2d(2, 2),MapDirection.SOUTH, new String[]{"r", "r"});
        moveT(new Vector2d(4, 4),MapDirection.SOUTH, new String[]{"f", "f", "l", "b", "b", "b", "b", "l"});
        moveT(new Vector2d(2, 0),MapDirection.SOUTH, new String[]{"b", "b", "b", "b", "r", "r"});
        moveT(new Vector2d(0, 4),MapDirection.EAST, new String[]{"f", "f", "f", "r", "b", "b", "b"});
    }

}
