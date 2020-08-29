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
    
    public void closestPair() {
        double[] distances = new double[(points.length - 1) * (points.length)/2];
        int iterations = 0;
        double closest = 1;
        int p1 = 0, p2 = 0;
        for(int i = 0; i < points.length; i++) {
            for(int j = i + 1; j < points.length; j++) {
                distances[iterations] = getDistance(i,j);
                if (distances[iterations] < closest) {
                    closest = distances[iterations];
                    p1 = i;
                    p2 = j;
                }
                String s = String.format("Distance from %d to %d is %f", i, j, distances[iterations]);
                StdOut.println(s);
                iterations++;
            }
        }
        StdOut.println("Number of operations: " + iterations);
        String s = String.format("Closest pair is points %s and %s: %f", p1, p2, closest);
        highlightPoints(p1,p2);
        StdOut.println(s);
    }
    
    public void highlightPoints(int p1, int p2) {
        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(StdDraw.YELLOW);
        Point2D h1 = points[p1];
        Point2D h2 = points[p2];
        h1.draw();
        h2.draw();
    }
    
    public static void main(String[] args) {
        int nPoints = 100;
        ClosestPair cp = new ClosestPair(nPoints);
        
        cp.randomPoints();
        cp.plotPoints();
        cp.closestPair();
    }
}
