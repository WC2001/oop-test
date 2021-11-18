package agh.ics.oop;

import org.junit.jupiter.api.Test;
import org.testng.internal.collections.Pair;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SimulationEngineTest {

    @Test
    void runTest_0(){
        MoveDirection[] directions = new OptionsParser(new String[]{"f", "b", "r", "l", "f", "f", "r", "r",
                "f", "f", "f", "f", "f", "f", "f", "f"}).parse();
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        List<Pair<Vector2d,MapDirection>> correctPositions = new ArrayList<>();
        correctPositions.add(new Pair<>(new Vector2d(2,0),MapDirection.SOUTH));
        correctPositions.add(new Pair<>(new Vector2d(3,4),MapDirection.NORTH));

        List<Pair<Vector2d,MapDirection>> gotPositions = engine.getPositions();

        assertEquals(correctPositions.size(), gotPositions.size());

        for (int i=0;i<correctPositions.size();i++){
            assertEquals(correctPositions.get(i), gotPositions.get(i));
        }
    }



    @Test
    void runTest_1(){
        MoveDirection[] directions = new OptionsParser(new String[]{"f", "l", "f", "l", "b", "f", "f", "b", "f"}).parse();
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4), new Vector2d(1,1) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        List<Pair<Vector2d,MapDirection>> correctPositions = new ArrayList<>();
        correctPositions.add(new Pair<>(new Vector2d(2,3),MapDirection.WEST));
        correctPositions.add(new Pair<>(new Vector2d(5,4),MapDirection.WEST));
        correctPositions.add(new Pair<>(new Vector2d(1,4), MapDirection.NORTH));

        List<Pair<Vector2d,MapDirection>> gotPositions = engine.getPositions();

        assertEquals(correctPositions.size(), gotPositions.size());

        for (int i=0;i<correctPositions.size();i++){
            assertEquals(correctPositions.get(i), gotPositions.get(i));
        }

    }

    @Test
    void runTest_2(){
        MoveDirection[] directions = new OptionsParser(new String[]{"f", "b", "b", "r", "l", "r", "b", "f", "f", "f", "r"}).parse();
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(1,4), new Vector2d(1,1), new Vector2d(7,3)};
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        List<Pair<Vector2d,MapDirection>> correctPositions = new ArrayList<>();
        correctPositions.add(new Pair<>(new Vector2d(2,3),MapDirection.WEST));
        correctPositions.add(new Pair<>(new Vector2d(1,3),MapDirection.EAST));
        correctPositions.add(new Pair<>(new Vector2d(1,0), MapDirection.EAST));
        correctPositions.add(new Pair<>(new Vector2d(8,3), MapDirection.EAST));


        List<Pair<Vector2d,MapDirection>> gotPositions = engine.getPositions();

        assertEquals(correctPositions.size(), gotPositions.size());

        for (int i=0;i<correctPositions.size();i++){
            assertEquals(correctPositions.get(i), gotPositions.get(i));
        }

    }
}
