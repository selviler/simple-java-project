import java.util.Scanner;
import java.util.Stack;

public class Hello {

    private String name;

    Hello(String name) {
        this.name = name;
        System.out.println("Hello "+ this.name);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Cosine of the entered value: ");
        double number3 = sc.nextDouble();
        cos(number3);

        System.out.println("Sine of the entered value: ");
        double number1 = sc.nextDouble();
        sin(number1);

        System.out.println();
        System.out.println("Please enter a radius to calculate the area of the circle: ");
        int number2 = sc.nextInt();
        int total = radius(number2);
        System.out.println("Total: " + total);

        System.out.println();
        System.out.println("enter the first edge: ");
        int first = sc.nextInt();
        System.out.println();
        System.out.println("enter the second edge: ");
        int second = sc.nextInt();

        rectangle(first, second);
        System.out.println();
        perimeter(first, second);
        sc.close();
    }

    public static void cos(double number)
    {
        System.out.println("cosine of the entered value: "+ Math.cos(Math.toRadians(number)));
    }
    public static void sin(double number)
    {
        System.out.println("Sine of the entered value: "+ Math.sin(Math.toRadians(number)));
    }

    public static int radius(int number)
    {
        return (int) (Math.PI * Math.pow(number, 2));
    }

    public static void rectangle(int first, int second)
    {
        System.out.println("Area of a rectangle: " + (first * second));
    }

    public static void perimeter(int first, int second)
    {
        System.out.println("Perimeter of a rectangle: " + (2 * (first + second)));
    }
}
