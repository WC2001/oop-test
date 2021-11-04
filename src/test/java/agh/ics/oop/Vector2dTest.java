package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    void equalsTest(){
        assertTrue(new World.Vector2d(1,4).equals(new World.Vector2d(1,4)));
        assertFalse(new World.Vector2d(4,5).equals(new World.Vector2d(4, 4)));
        assertFalse(new World.Vector2d(1,2).equals("(1,2)"));
    }
    @Test
    void toStringTest(){
        String s = "(3,4)";
        World.Vector2d v = new World.Vector2d(1,4);
        String k = "(1,4)";
        assertEquals(v.toString(), k);
        assertNotEquals(v.toString(), s);
    }
    @Test
    void precedesTest(){
        assertTrue(new World.Vector2d(1,1).precedes(new World.Vector2d(1,5)));
        assertFalse(new World.Vector2d(1,2).precedes(new World.Vector2d(1,0)));


    }
    @Test
    void followsTest(){
        assertTrue(new World.Vector2d(3,3).follows(new World.Vector2d(3,0)));
        assertFalse(new World.Vector2d(3,4).follows(new World.Vector2d(4,4)));

    }
    @Test
    void upperRightTest(){
        assertEquals(new World.Vector2d(3,3), new World.Vector2d(3,1).upperRight(new World.Vector2d(1,3)));
        assertNotEquals(new World.Vector2d(3,5), new World.Vector2d(3, 5).upperRight(new World.Vector2d(3,7)));

    }
    @Test
    void lowerLeftTest(){
        assertEquals(new World.Vector2d(5,3), new World.Vector2d(5,19).lowerLeft(new World.Vector2d(6,3)));
        assertNotEquals(new World.Vector2d(5, 13), new World.Vector2d(5, 13).lowerLeft(new World.Vector2d(5,4)));
    }
    @Test
    void addTest(){
        assertEquals(new World.Vector2d(10,3), new World.Vector2d(11, -1).add(new World.Vector2d(-1,4)));
        assertNotEquals(new World.Vector2d(3,3), new World.Vector2d(2, 0).add(new World.Vector2d(1, 8)));
    }
    @Test
    void subtractTest(){
        assertEquals(new World.Vector2d(10,4), new World.Vector2d(5,6).subtract(new World.Vector2d(-5,2)));
        assertNotEquals(new World.Vector2d(4,2), new World.Vector2d(5,5).subtract(new World.Vector2d(1,-3)));
    }
    @Test
    void oppositeTest(){
        assertEquals(new World.Vector2d(1,4).opposite(), new World.Vector2d(-1,-4));
        assertNotEquals(new World.Vector2d(4,2), new World.Vector2d(-4, 0));
    }
}
