package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static agh.ics.oop.MapDirection.NORTH;
import static agh.ics.oop.MapDirection.WEST;
import static agh.ics.oop.MapDirection.EAST;
import static agh.ics.oop.MapDirection.SOUTH;


public class MapDirectionTest {

    @Test
    void nextTest(){
        assertEquals(NORTH.next(), EAST);
        assertEquals(EAST.next(), SOUTH);
        assertEquals(SOUTH.next(), WEST);
        assertEquals(WEST.next(), NORTH);
    }

   @Test
    void previousTest(){
        assertEquals(NORTH.previous(), WEST);
        assertEquals(EAST.previous(), NORTH);
        assertEquals(SOUTH.previous(), EAST);
        assertEquals(WEST.previous(), SOUTH);
    }

}
