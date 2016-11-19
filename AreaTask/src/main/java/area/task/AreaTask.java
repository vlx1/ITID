package area.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Viktor on 11.11.2016.
 */
public class AreaTask {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));


        Areable figure;
        int[] startPoint;
        int startX, startY, num1, num2;
        while (true)
        {

            System.out.println("Площадь какой фигуры вы хотите посчитать?");
            System.out.println("Введите 1 - круг");
            System.out.println("2 - квадрат");
            System.out.println("3 - прямоугольник");
            System.out.println("***Для завершения программы введите любое другое значение.***");


            String choice = reader.readLine();


            if ("1".equals(choice))
            {
                startPoint = getStartPoint();
                System.out.println("Введите радиус");
                num1 = scanner.nextInt();
                figure = new Circle(startPoint[0],startPoint[1],num1);
                System.out.println(figure.getArea());

            }
            else if ("2".equals(choice))
            {
                startPoint = getStartPoint();
                System.out.println("Введите сторону квадрата");
                num1 = scanner.nextInt();
                figure = new Square(startPoint[0],startPoint[1],num1);
                System.out.println(figure.getArea());

            }
            else if ("3".equals(choice))
            {
                startPoint = getStartPoint();
                System.out.println("Введите первую сторону прямоугольника");
                num1 = scanner.nextInt();
                System.out.println("Введите вторую сторону прямоугольника");
                num2 = scanner.nextInt();
                figure = new Rectangle(startPoint[0],startPoint[1],num1, num2);
                System.out.println(figure.getArea());
            }
            else
            {
                break;
            }
        }
    }

    private static int[] getStartPoint()
    {
        Scanner scanner = new Scanner(System.in);
        int[] startPoint = new int[2];
        System.out.println("Введите координату X для стартовой точки");
        startPoint[0] = scanner.nextInt();
        System.out.println("Введите координату Y для стартовой точки");
        startPoint[1] = scanner.nextInt();
        return startPoint;
    }
}