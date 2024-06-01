package KW.CH01.Shapes;

/*<exericse type="endOfChapter" chapter="1" number="12">*/
import java.util.Scanner;

/**
 * Definition of the class Parallelogram
 * @author Koffman and Wolfgang
 */
public class Parallelogram  extends AbstrtactShape {
    // Data fields
    
    /** One side */
    private double a;
    /** The other side */
    private double b;
    /** The angle between a and b */
    private double theta;
    
    /** Default constructor */
    public Parallelogram() {
        super("Parallelogram");
    }
    
    /** 
     * Construct a Parallelogram with the specified values
     * 
     * @param a The length of one side
     * @param b The length of the other side
     * @param theta The angle between a and b in radians between 0 and PI/4
     */
    public Parallelogram(double a, double b, double theta) {

		/*Your Code Here*/
        super("Parallelogram");
        this.a = a;
        this.b = b;
        this.theta = theta;

    }

    /**
     * Compute the area
     * @return the area
     */
    @Override
    public double computeArea() {
		/*Your Code Here*/
        return a * b * Math.sin(theta);

    }

    /**
     * Compute the perimeter
     * @return the perimeter
     */
    @Override
    public double computePerimeter() {
		/*Your Code Here*/
        return 2*(a+b);
    }

    /** 
     * Read the attributes of the parallelogram..
     */
    @Override
    public void readShapeData() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the one side of the Parallelogram");
        a = in.nextDouble();
        System.out.println("Enter the other side of the Parallelogram");
        b = in.nextDouble();
        System.out.println("Enter the angle between sides a and b in degrees");
        double angle = in.nextDouble();
        if (0 < angle && angle <= 90.0) {
            theta = angle*Math.PI/180.0;
        } else {
            throw new IllegalArgumentException(angle + 
                    " must be greater than 0 and less than or equal to 90");
        }
    }


    /**
     * Get the width of the bounding rectangle
     * @return the width
     */
    @Override
    public double getWidth() {
        return b + a*Math.cos(theta);
    }

    /**
     * Get the height of the bounding rectangle
     * @return the height
     */
    @Override
    public double getHeight() {
        return a*Math.sin(theta);
    }   
}
/*</exercise>*/
