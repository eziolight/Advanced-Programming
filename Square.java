/**
 * FILE NAME:Square.java
 * WHO: 
 * WHAT: Class with Rectangle properties. Adds a length and a width property
 * Inherits from Shape class. Added javadoc
 * Implements the area() method
 */
public class Square extends Shape {

    private double length; //length of the rectangle
    private double width;  //width of the rectangle

    /**
     * Constructor
     * @param len length of rectangle
     * @param wid width of rectangle
     */
    public Square(double len, double wid) {
        super ("square"); //call the constructor in the super class (Shape)
        this.length = len;
        this.width = wid;
    }

    /**
     * Area Implemented for rectangle
     *  @return area
     */
    public double area() {
        return this.length * this. width;
    }

    /**
     * perimeter() Implemented for rectangle
     *  @return perimeter
     */
    public double perimeter() {
        return 2 * (this.length + this. width);
    }

    public String toString() {
        String s = super.toString();
        s = s + " (length: " + length + " width: " + width + ")" ;
        return s;
    }


} //End Square Class