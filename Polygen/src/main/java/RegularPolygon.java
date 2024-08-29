/**
 * RegularPolygon is an Object-Oriented Class.
 * RegularPolygon class calculate Perimeter and Area of Polygon using number of side, side length, and center coordinates.
 * @Author: Celine Wang
 * classname: CISC 191
 * @Version: 1.0
 */
import static java.lang.Math.*;

public class RegularPolygon {

    /** The number of sides */
    private int n = 3;

    /** The length of the side */
    private double side = 1;

    /** The x-coordinate of the polygon's center */
    private double x = 0.0;

    /** The y-coordinate of the polygon's center */
    private double y = 0.0;

    /** Construct a regular polygon with default value*/
    RegularPolygon() {};

    /** Construct a regular polygon centered at (0, 0)
     * @param n The number of sides
     * @param side The length of the sides
     */
    RegularPolygon(int n, double side) {
        this.n = n;
        this.side = side;
    }

    /** Construct a regular polygon with specified value of all data fields
     * @param n The number of sides.
     * @param side The length of the sides.
     * @param x The x-coordinate of the center.
     * @param y The y-coordinate of the center.
     */
    RegularPolygon(int n, double side, double x, double y) {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    // Accessors
    /** Return the number of sides
     * @return The number of sides
     */
    public int getN() {
        return n;
    }

    /** Return the length of sides
     * @return The length of sides
     */
    public double getSide() {
        return side;
    }

    /** Return x-coordinate of the polygon's center
     * @return The x-coordinate of the center
     */
    public double getX() {
        return x;
    }

    /** Return y-coordinate of the polygon's center
     * @return The y-coordinate of the center.
     */
    public double getY() {
        return y;
    }

    // Mutators
    /** Set the number of sides
     * @param n The number of sides
     */
    public void setN(int n) {
        this.n = n;
    }

    /** Set the length of sides
     * @param side The length of side
     */
    public void setSide(double side) {
        this.side = side;
    }

    /** Set x-coordinate of the polygon's center
     * @param x The x-coordinate of the center
     */
    public void setX(double x) {
        this.x = x;
    }

    /** Set y-coordinate of the polygon's center
     * @param y The y-coordinate of the center
     */
    public void setY(double y) {
        this.y = y;
    }

    // Methods
    /** Return the perimeter of the polygon
     * @return The perimeter of the polygon
     * */
    public double getPerimeter() {
        return n * side;
    }

    /**
     * Returns the area of the polygon.
     * @return The area of the polygon
     */
    public double getArea() {
        return n * pow(side, 2) / (4 * tan( PI / n));
    }
}
