package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap {

    private ArrayList<Animal> animals = new ArrayList<>();
    private MapVisualizer visualizer = new MapVisualizer(this);
    private Vector2d start = new Vector2d(0, 0);
    private Vector2d end;

    public RectangularMap(int width, int height) {
        this.end = new Vector2d(width, height);
    }


    public boolean canMoveTo(Vector2d position) {
        if (this.isOccupied(position))
            return false;

        return position.precedes(this.end) && position.follows(this.start);
    }

    public boolean place(Animal animal) {
        if (!canMoveTo(animal.getPosition()))
            return false;

        this.animals.add(animal);
        return true;

    }

    public boolean isOccupied(Vector2d position) {
        for (Animal x : this.animals) {
            if (x.getPosition().equals(position))
                return true;
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        for (Animal x : this.animals) {
            if (x.getPosition().equals(position))
                return x;
        }
        return null;
    }

    public String toString() {
        return this.visualizer.draw(this.start, this.end);
    }
}