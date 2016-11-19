package area.task;

/**
 * Created by Viktor on 11.11.2016.
 */
public class Circle extends Figure {
    private final double PI = 3.14;
    int r;
    public Circle(int startX, int startY, int r)
    {
        super(startX,startY);
        this.r = r;
    }
    public double getArea()
    {
        return PI* Math.pow(r,2);
    }
}
