package agh.ics.oop;

import org.testng.internal.collections.Pair;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{

    private final MoveDirection[] directions;
    private final AbstractWorldMap map;
    private final List<Animal> animals ;

    SimulationEngine(MoveDirection[] directions, AbstractWorldMap map, Vector2d[] positions) {
        this.directions = directions;
        this.map = map;
        this.animals = new ArrayList<>();

        for (Vector2d v:positions) {
            Animal animal = new Animal(this.map,v);
            if(this.map.place(animal))
                animals.add(animal);

        }

    }
    @Override
    public void run() {

        int animalNumber = animals.size();
        System.out.println(this.map);
        if (animalNumber > 0){

            for(int i=0;i<directions.length;i++){
                this.animals.get(i%animalNumber).move(this.directions[i]);

            }
        }
        System.out.println(this.map);

    }
    public List<Pair<Vector2d,MapDirection>> getPositions(){
        List<Pair<Vector2d,MapDirection>> positions = new ArrayList<>();
        for (Animal a: animals) {
            positions.add(new Pair<>(a.getPosition(), a.getDirection()));
        }

        return positions;

    }
}
