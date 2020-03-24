package up.edu.dimcalc;

import android.graphics.Point;

import java.util.Random;

/**
 * This class is designed to perform operations on two points in 2D space
 */
public class TwoPoints {

    private Point[] points = new Point[2];
    private Random rand = new Random();

    /** ctor */
    public TwoPoints() {
        points[0] = new Point(0,0);
        points[1] = new Point(0,0);
    }

    /** get a point */
    public Point getPoint(int index) {
        return points[index];
    }

    /** set a point */
    public void setPoint(int index, int x, int y) {
        points[index].x = x;
        points[index].y = y;
    }

    /** assign a random value to a point */
    public void randomValue(int index) {
        //changed the bounds of the random number to only positive, since negative numbers
        //cannot be typed in by the user
        int x = rand.nextInt(20);
        int y = rand.nextInt(20);
        setPoint(index, x, y);
    }

    /** sets a point to the origin */
    public void setOrigin(int index) {
        setPoint(index, 0, 0);
    }

    /** copy the values in one points to the other */
    public void copy(int srcIndex, int destIndex) {
        points[destIndex] = points[srcIndex];
    }

    /** calculates the distance between the two points rounded to the nearest integer */
    public double distance() {
        double result = 0.0;
        int xDiff = points[0].x - points[1].x;
        int yDiff = points[0].y - points[1].y;
        result = Math.sqrt(xDiff*xDiff + yDiff*yDiff);
        return result;
    }

    /** calculates the slope of a line passing through the two points
     *
     * @return the slope or 0 if the points are equal */
    public double slope() {
        double result = 0.0;
        if (points[0] == points[1]){
            return result;
        }

        //added check for dividing by 0
        int xDiff = points[0].x - points[1].x;
        if(xDiff == 0){
            return result;
        }
        int yDiff = points[0].y - points[1].y;

        //switched xDiff/yDiff to yDiff/xDiff
        result = (double)yDiff / (double)xDiff;
        return result;
    }


}//TwoPoints
