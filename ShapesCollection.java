import java.util.*;  // for Scanner class
import java.util.Random;

/**
 * FILE NAME:ShapesCollection.java
 * WHO: 
 * WHEN: 
 * WHAT: Uses an array to maintain a collection of Shapes 
 * (circles, triangles, or rectangles)
 */

public class ShapesCollection {
    //int maxNumShapes = 1; //the max number of the shape we process.
    //Notice, this version handles the case when the array becomes too small,
    //so we can do without this variable


    //instance variables
    private Shape [] blocks;
    private int counter = 0;  //counts the current number of shapes in the collection (array)
    private Random rand = new Random();

   ShapesCollection(){

   }

     /**
     * getCounter
     * @return int counter index where next element can be placed in array
     **/
    public int getCounter(){
        return counter;
    }

    /**
     * adds the input Shape to the collection
     * Doubles the array size when needed
     * @input Shape The shape to be added to the collection
     *
     * */
    public void add(Shape s) {

        Shape[] newarr= new Shape[counter+1];
        newarr[counter] = s;
        for (int i = 0; i<counter; i++) {
            newarr[i] = blocks[i];
        }
        blocks = newarr;
        counter++;


    }


    /**
     *  Sorts the collection of Shapes
     */
    public  void sort () {
        // sorts the  Shape[] in increasing order,
        // according to the area of each Shape obj
        // uses the selection sort algorithm

        Shape maxShape;  // Shape with maximum area
        int maxIndex;   // index of maximum area Shape
        int i, j;
        for (j = counter - 1; j > 0; j--) {
            maxIndex = 0;
            maxShape = blocks[0];
            for (i = 1; i <= j; i++) {
                if (blocks[i].compareTo(maxShape) > 0) {
                    maxShape = blocks[i];
                    maxIndex = i;
                }
            }
            swap(blocks, maxIndex, j);
        }


    }

    /**
     * exchanges the contents of input array at positions i and j
     */
    private  void swap (Shape[] a, int i, int j) {
        // exchanges the contents of locations i and j in input array
        Shape temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * toString
     * returns a string represenation of this collection of shapes
     * @return String a string representation of this collection
     **/
    public String toString(){
        if (counter == 0){
            return "This collection contains 0 shapes.";
        }


        StringBuilder s = new StringBuilder();

        s.append(String.format("This collection contains %d shapes.",counter));
        s.append("\n");
        for (int i = 0; i < counter; i++) {
            s.append(blocks[i].toString());
            s.append("\n");
        }

        String str = s.toString();

        return str;
    }

    /**
     * findLargest
     * returns the index of the Shape with the largest area in this collection of shapes
     * @return int the index of the shape with the largest area
     *
     **/
    public int findLargest() {
        double largestArea = 0;
        int index = 0;

        for (int i = 0; i < counter; i++) {
            if (blocks[i].getArea() >= largestArea) {
                index = i;
            }
        }

        return index;

    }

    /**
     * removeLargest
     * removes the largest Shape in the collection.
     * returns the Shape that was removed
     *
     * @return Shape the Shape that was removed
     *
     **/
    public Shape removeLargest() {

        Shape[] returnShape = new Shape[1];


        if (counter == 0){
            return returnShape[0];
        }

        Shape[] newarr= new Shape[counter-1];

        int newarrIndex = 0;
        int largestIndex = this.findLargest();

        for (int i = 0; i < newarr.length; i++){
            if (i == largestIndex) {
                returnShape[0] = blocks[i];
                continue;
            }
            newarr[newarrIndex++] = blocks[i];
        }

        blocks = newarr;
        counter--;
        System.out.format("Largest Shape's Index = %d%n",largestIndex);
        System.out.println("Removing largest shape");
        System.out.println("");

        return returnShape[0];


    }

    /**
     *  static main method
     *  Method to read in data, from the standard input.
     *  Then, sorts and displays the inputted Shape objects according to their area
     *
     *    @param args an array of strings
     */
    public static void main(String[ ] args) {

        ShapesCollection shapes = new ShapesCollection();

        Circle c1 = new Circle(20f);
        c1.setArea(c1.area());
        c1.setPerimeter(c1.perimeter());
        Circle c2 = new Circle(0f);
        c2.setArea(c2.area());
        c2.setPerimeter(c2.perimeter());
        Circle c3 = new Circle(5.5f);
        c3.setArea(c3.area());
        c3.setPerimeter(c3.perimeter());

        Triangle t1 = new Triangle(3f,4f,5f);
        t1.setArea(t1.area());
        t1.setPerimeter(t1.perimeter());

        Rectangle r1 = new Rectangle(4.5f,6.2f);
        r1.setArea(r1.area());
        r1.setPerimeter(r1.perimeter());

        Square s1 = new Square(4.5f,6.2f);
        s1.setArea(r1.area());
        s1.setPerimeter(s1.perimeter());

        shapes.add(c1);
        shapes.add(c2);
        shapes.add(c3);
        shapes.add(t1);
        shapes.add(r1);
        shapes.add(s1);

        System.out.println(shapes);
        shapes.sort();
        System.out.println(shapes);

        for (int i = shapes.getCounter()-1; i > -1; i--){
            shapes.removeLargest();
            System.out.println(shapes);
        }


    }
}



//****** Developing this interactive way of collecting data can be a separate exercise *****
//  Read in, from the standard input (the keyboard), the type
// of shape and the required shape information.  Then, place
// it in an array. At the end sort the array based on area, and
// print the results.
    
    /* Version 2.0 
     * 
    
	
	
	
	
	
	
	
	
	
	
    
    
  }//End main()
  
} //End ShapesCollection

     */