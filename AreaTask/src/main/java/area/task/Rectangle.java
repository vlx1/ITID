package area.task;

/**
 * Created by Viktor on 11.11.2016.
 */
public class Rectangle extends Square {
    int side2;

    public Rectangle(int startX, int startY, int side1, int side2)
    {
        super(startX, startY, side1);
        this.side2 =side2;
    }
    public double getArea()
    {
        return side1*side2;
    }


}
