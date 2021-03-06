package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return String.format( "(%d,%d)", x, y);
    }
    boolean precedes(Vector2d other){
        if (this.x <= other.x && this.y <= other.y)
            return true;
        return false;
    }
    boolean follows(Vector2d other){
        if (this.x >= other.x && this.y >= other.y)
            return true;
        return false;
    }
    Vector2d upperRight(Vector2d other){
        return new Vector2d(Math.max(this.x, other.x), Math.max(this.y, other.y) );
    }
    Vector2d lowerLeft(Vector2d other){
        return new Vector2d(Math.min(this.x, other.x), Math.min(this.y, other.y) );
    }
    Vector2d add(Vector2d other){
        return new Vector2d(this.x + other.x, this.y +other.y );
    }
    Vector2d subtract(Vector2d other){
        return new Vector2d(this.x - other.x, this.y - other.y );
    }
    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        if (that.x == this.x && that.y == this.y)
            return true;
        return false;
    }
    Vector2d opposite(){
        return new Vector2d(- this.x , - this.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

}
