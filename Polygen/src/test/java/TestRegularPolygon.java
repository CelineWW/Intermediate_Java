/**
 * Testing RegularPolygon class.
 *
 * @Author: Celine Wang
 * classname: CISC 191
 * @Version: 1.0
 */

public class TestRegularPolygon {
    public static void main(String[] args) {
        // Create Polygon 1 using the no-arg constructor
        RegularPolygon p1 = new RegularPolygon();
        System.out.println("Polygon 1 perimeter: " + p1.getPerimeter());
        System.out.println("Polygon 1 area: " + p1.getArea());

        // Create Polygon 2 using the two arguments constructor
        RegularPolygon p2 = new RegularPolygon(6, 4);
        System.out.println("Polygon 2 perimeter: " + p2.getPerimeter());
        System.out.println("Polygon 2 area: " + p2.getArea());

        // Create Polygon 3 using the four arguments constructor
        RegularPolygon p3 = new RegularPolygon(10, 4, 5.6, 7.8);
        System.out.println("Polygon 3 perimeter: " + p3.getPerimeter());
        System.out.println("Polygon 3 area: " + p3.getArea());
    }
}
