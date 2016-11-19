package area.task;

/**
 * Created by Viktor on 11.11.2016.
 */
public class Square extends Figure {
    private final double PI = 3.14;
    int side1;
    public Square(int startX, int startY, int side1)
    {
        super(startX,startY);
        this.side1 = side1;
    }
    public double getArea()
    {
        return Math.pow(side1,2);
    }
}
