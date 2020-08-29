import edu.princeton.cs.introcs.*;
import edu.princeton.cs.algs4.*;
/**
 * Write a Point2D client that takes an integer value N from the command line, generates N 
 * random points in the unit square, and computes the distance separating the closest pair of points.
 *
 * @author Luisely Doza
 * @version August 28, 2020
 */
public class ClosestPair {
    private Point2D[] points;
    public ClosestPair(int n) {
        points = new Point2D[n];
    }
   
    public void randomPoints() {
        for (int i = 0; i < points.length; i++) {
            double x,y;
            x = StdRandom.uniform();
            y = StdRandom.uniform();
            Point2D p = new Point2D (x,y);
            points[i]=p;
        }
    }
    
    public void plotPoints() {
        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(StdDraw.PINK);
        for (int i=0; i<points.length; i++) {  
            Point2D p = points[i];
            p.draw();
        }
    }
    
    public double getDistance(int i1, int i2) {
        Point2D p1 = points[i1];
        Point2D p2 = points[i2];
        double dist = p1.distanceTo(p2);
        return dist;
    }
    
    public double[] allDistances() {
        double[] distances = new double[points.length * 2];
        for(int i = 0; i < points.length; i++) {
            for(int j = i; j < points.length; j++) {
                if (i == j) continue;
                distances[i] = getDistance(i,j);
                String s = String.format("Distance from %d to %d is %f",
                    i,j,distances[i]);
                StdOut.println(s);
            }
        }
        return distances;
    }
    
    public static void main(String[] args) {
        int nPoints = 5;
        ClosestPair cp = new ClosestPair(nPoints);
        
        cp.randomPoints();
        cp.plotPoints();
        cp.allDistances();
    }
}
