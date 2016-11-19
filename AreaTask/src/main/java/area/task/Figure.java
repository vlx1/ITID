package area.task;

/**
 * Created by Viktor on 11.11.2016.
 */
public abstract class Figure implements Areable {
    int startX;
    int startY;

    public Figure(int startX, int startY)
    {
        this.startX = startX;
        this.startY = startY;
    }
    //public abstract double getArea();

}
