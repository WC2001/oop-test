package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    final int width = 10;
    final int height = 10;

    @Test
    void canMoveToTest(){
        RectangularMap map = new RectangularMap(width,height);
        Animal a = new Animal(map, new Vector2d(width-1,height-1));


        assertTrue(map.canMoveTo(new Vector2d(0,height-1)));
        assertFalse(map.canMoveTo(new Vector2d(width,0)));
        assertFalse(map.canMoveTo(new Vector2d(0,height)));
        assertTrue(map.canMoveTo(new Vector2d(0,0)));
        assertTrue(map.canMoveTo(new Vector2d(width-1,0)));

        map.place(a);
        assertFalse(map.canMoveTo(a.getPosition()));

    }

    @Test
    void placeTest(){
        RectangularMap map = new RectangularMap(width, height);

        assertTrue(map.place(new Animal(map,new Vector2d(width-1,height-1))));
        assertFalse(map.place(new Animal(map,new Vector2d(width-1,height-1))));

    }

    @Test
    void isOccupiedTest(){
        RectangularMap map = new RectangularMap(width, height);
        assertFalse(map.isOccupied(new Vector2d(width-1,height-1)));
        Animal a = new Animal(map,new Vector2d(width-1,height-1));
        map.place(a);
        assertTrue(map.isOccupied(new Vector2d(width-1,height-1)));

    }

    @Test
    void objectAtTest(){
        RectangularMap map = new RectangularMap(5, 5);
        Animal a = new Animal(map,new Vector2d(4,4));
        map.place(a);

        assertEquals(a,map.objectAt(new Vector2d(4,4)));
        assertNull(map.objectAt(new Vector2d(0,0)));
        assertNull(map.objectAt(new Vector2d(10,10)));

    }

}
