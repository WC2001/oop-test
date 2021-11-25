package agh.ics.oop;

import org.junit.jupiter.api.Test;
import org.testng.internal.collections.Pair;
import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    public Vector2d findEmpty(GrassField map){
        Pair<Vector2d,Vector2d> p = map.getArea();
        for(int i=p.first().x;i<p.second().x;i++){

            for(int j=p.first().y;j<p.second().y;j++){

                if (!map.isOccupied(new Vector2d(i,j))){
                    return new Vector2d(i,j);
                }
            }
        }
        return null;
    }


    void toEmpty(GrassField map){
        assertTrue(map.canMoveTo(findEmpty(map)));
    }
    void  toGrass(GrassField map){
        assertTrue(map.canMoveTo(map.getGrasses().get(1).getPosition()));
    }
    void toAnimal(GrassField map,Vector2d v){
        assertFalse(map.canMoveTo(v));
    }


    @Test
    void canMoveToTest(){
        GrassField map = new GrassField(10);
        Animal a = new Animal(map,new Vector2d(3,4));
        map.place(a);

        toEmpty(map);
        toGrass(map);
        toAnimal(map,new Vector2d(3,4));
    }
    @Test
    void placeTest(){
        GrassField map = new GrassField(10);
        Animal a = new Animal(map,new Vector2d(1,3));
        map.place(a);

        assertTrue(map.place(new Animal(map,new Vector2d(2,2))));
        assertFalse(map.place(a));

    }

    @Test
    void isOccupiedTest(){

        GrassField map = new GrassField(10);
        Animal a = new Animal(map,new Vector2d(1,3));
        map.place(a);
        Vector2d g = map.getGrasses().get(1).getPosition();

        assertFalse(map.isOccupied(findEmpty(map)));
        assertTrue(map.isOccupied(g));
        assertTrue(map.isOccupied(a.getPosition()));
    }

    @Test
    void objectAtTest(){

        GrassField map = new GrassField(10);
        Animal a = new Animal(map,new Vector2d(4,4));
        map.place(a);
        Vector2d g = map.getGrasses().get(1).getPosition();

        assertEquals(a,map.objectAt(new Vector2d(4,4)));
        assertEquals(map.getGrasses().get(1),map.objectAt(g));
        assertNull(map.objectAt(findEmpty(map)));
    }

}
