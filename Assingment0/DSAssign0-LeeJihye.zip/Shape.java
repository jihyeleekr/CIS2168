package KW.CH01.Shapes;

/**
 * An interface for a geometric shape
 * @author Koffman and Wolfgang
 */
public interface Shape {
    
    // abstract methods

    /**
     * Compute the area of the shape
     * @return The area of the shape
     */
    double computeArea();

    /**
     * Compute the perimeter of the shape
     * @return The perimeter of the shape
     */
    double computePerimeter();

    /**
     * Prompt the user for the parameters of the shape
     * and read them.
     */
    void readShapeData();
    
    /**
     * Get the width of the shape
     * @return The width of the shape
     */
    double getWidth();
    
    /**
     * Get the height of the shape
     * @return The height of the shape
     */
    double getHeight();

}
