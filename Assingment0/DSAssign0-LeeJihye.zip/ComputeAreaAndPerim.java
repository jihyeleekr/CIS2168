/*<listing chapter="1" number="8">*/
/**
 *  Listing 1.8
 *  @author Koffman and Wolfgang
 */
package KW.CH01.Shapes;

import java.util.Scanner;

/**
 * Computes the area and perimeter of selected figures.
 */
public class ComputeAreaAndPerim {

    /**
     * The main program performs the following steps.
     * 1. It asks the user for the type of figure.
     * 2. It asks the user for the characteristics of that figure.
     * 3. It computes the perimeter.
     * 4. It computes the area.
     * 5. It displays the result.
     * @param args The command line arguments -- not used
     */
    public static void main(String args[]) {
        Shape myShape;
        double perimeter;
        double area;
        myShape = getShape(); // Ask for figure type
        myShape.readShapeData(); // Read the shape data
        perimeter = myShape.computePerimeter(); // Compute perimeter
        area = myShape.computeArea(); // Compute the area
        displayResult(area, perimeter); // Display the result
        System.exit(0); // Exit the program
    }

    /**
     * Ask the user for the type of figure.
     * @return An instance of the selected shape
     */
    public static Shape getShape() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter C for Circle");
        System.out.println("Enter R for Rectangle");
        System.out.println("Enter T for Right Triangle");
        System.out.println("Enter P for Parallelogram");
        /*<exercise chapter="1" type="programming-project" number="6">*/
        System.out.println("Enter E for Equilateral Triangle");
        System.out.println("Enter S for Square");
        /*</exercise>*/
        String figType = in.next();
        switch (figType) {
            case "C": case "c":
                return new Circle();
            case "R": case "r":
                return new Rectangle();
            case "T": case "t":
                return new RtTriangle();
            case "P": case "p":
                return new Parallelogram();
            /*<exercise chapter="1" type="programming-project" number="6">*/
            case "E": case "e":
                return new EQTriangle();
            case "S": case "s":
                return new Square();
            /*</exercise>*/
            default:
                return null;
        }
    }
    

    /**
     * Display the result of the computation.
     * @param area The area of the figure
     * @param perim The perimeter of the figures
     */
    private static void displayResult(double area, double perim) {
        System.out.printf("The area is %.2f%nThe perimeter is %.2f%n",
                area, perim);
    }
}
/*</listing>*/
