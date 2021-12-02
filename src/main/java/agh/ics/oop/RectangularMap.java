package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap{
    private final int width;
    private final int height;

    public RectangularMap(int w, int h){
        this.width = Math.max(w,1);
        this.height = Math.max(h,1);

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (position.x >= width || position.y >= height)
            return false;

        return super.canMoveTo(position);
    }

    @Override
    public String toString(){

        return super.toString(new Vector2d(0,0),new Vector2d(this.width-1,this.height-1));
    }

}
